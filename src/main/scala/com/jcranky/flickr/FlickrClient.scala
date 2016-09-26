package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

class FlickrClient(apiKey: String, baseUrl: String, httpClient: HttpClient, responseParser: ResponseParser) {
  import FlickrClient._

  def buscaFotos(tags: List[String]): Either[FlickrError, Seq[Foto]] = {
    val url = s"$baseUrl?method=$searchMethod&api_key=$apiKey&tags=${tags.mkString(",")}"

    val response = httpClient.get(url)

    response.fold(
      (err) => Left(FlickrError(err.msg)),
      (resp) => Right(responseParser.parse(resp.body))
    )
  }
}

object FlickrClient {
  case class FlickrError(msg: String)

  val searchMethod = "flickr.photos.search"

  def fromConfig(config: Config): FlickrClient = {
    val apiKey = config.getString("flickr.api.key")
    val baseUrl = config.getString("flickr.api.baseurl")

    new FlickrClient(apiKey, baseUrl, HttpClient.fromConfig(), ResponseParser.fromConfig(config))
  }
}
