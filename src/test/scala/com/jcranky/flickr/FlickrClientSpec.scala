package com.jcranky.flickr

import com.jcranky.flickr.FlickrClient.ClientError
import com.jcranky.flickr.HttpClient.{GetError, GetResponse}
import com.jcranky.flickr.model.Foto
import com.typesafe.config.{ConfigException, ConfigFactory}
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class FlickrClientSpec extends Specification with Mockito {
  "FlickrClient.fromConfig" should {
    "work with valid configuration" in {
      val client = FlickrClient.fromConfig(ConfigFactory.load("app-test.conf"))
      client !=== null
    }

    "fail if some configuration is missing" in {
      FlickrClient.fromConfig(ConfigFactory.load("wrong.conf")) should throwAn[ConfigException]
    }
  }

  "FlickrClient.buscaFotos" should {
    "ask the httpclient for the photos and pass the response to the response parser" in {
      val fotos = List(Foto("1", "jcranky", "123", "321", 1, "my pic", true, false, false))
      val resp = buscaFotos(
        Right(GetResponse(200, "fotos-xml-here")),
        Right(fotos)
      )

      resp should beRight(fotos)
    }

    "return a client error if the parser returns a FlickrError" in {
      val error = FlickrKnownError(100, "Invalid API Key (Key has invalid format)")
      val resp = buscaFotos(
        Right(GetResponse(200, "error-xml-here")),
        Left(error)
      )

      resp should beLeft(ClientError(error.toString))
    }
  }

  /* Helper to test FlickrClient.buscaFotos */
  def buscaFotos(httpResp: Either[GetError, GetResponse], parsed: Either[FlickrError, Seq[Foto]]): Either[ClientError, Seq[Foto]] = {
    val httpClient = mock[HttpClient]
    val parser = mock[ResponseParser]

    httpClient.get(any[String]) returns httpResp
    parser.parse(any[String]) returns parsed

    val client = new FlickrClient("api-key", "base-url", httpClient, parser)
    val resp = client.buscaFotos(List("scala"))

    there was one(httpClient).get(anyString)

    resp
  }
}
