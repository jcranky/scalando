package com.jcranky.flickr

import com.jcranky.flickr.HttpClient.GetResponse
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
      val httpClient = mock[HttpClient]
      val parser = mock[ResponseParser]

      httpClient.get(any[String]) returns Right(GetResponse(200, "fotos-xml-here"))
      parser.parse(any[String]) returns List(Foto("1", "jcranky", "123", "321", 1, "my pic", true, false, false))

      val client = new FlickrClient("api-key", "base-url", httpClient, parser)
      client.buscaFotos(List("scala"))

      there was one(httpClient).get(anyString)
    }
  }
}
