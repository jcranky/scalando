package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

class FlickrClient(apiKey: String, baseUrl: String, httpClient: HttpClient, responseParser: ResponseParser) {
  import FlickrClient._

  def buscaFotos(tags: List[String]): Either[ClientError, Seq[Foto]] = {
    val url = s"$baseUrl?method=$searchMethod&api_key=$apiKey&tags=${tags.mkString(",")}"

    val response = httpClient.get(url)

    response.fold(
      (err) => Left(ClientError(err.msg)),
      (resp) => responseParser.parse(resp.body) match {
        case Right(parsed) => Right(parsed)
        case Left(error) => Left(ClientError(error.toString))
      }
    )
  }
}

object FlickrClient {
  case class ClientError(msg: String)

  val searchMethod = "flickr.photos.search"

  def fromConfig(config: Config): FlickrClient = {
    val apiKey = config.getString("flickr.api.key")
    val baseUrl = config.getString("flickr.api.baseurl")

    new FlickrClient(apiKey, baseUrl, HttpClient.fromConfig(), ResponseParser.fromConfig(config))
  }
}
