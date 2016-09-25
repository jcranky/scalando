package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config
import FlickrClient._

class FlickrClient(apiKey: String, baseUrl: String, httpClient: HttpClient, responseParser: ResponseParser) {

  // TODO: usar Either para tratar error e evitar precisar lançar excessões ....
  def buscaFotos(tags: List[String]): Seq[Foto] = {
    val url = s"$baseUrl?method=$searchMethod&api_key=$apiKey&tags=${tags.mkString(",")}"

    val response = httpClient.get(url)

    responseParser.parse(response)
  }
}

object FlickrClient {
  val searchMethod = "flickr.photos.search"

  def fromConfig(config: Config): FlickrClient = {
    val apiKey = config.getString("flickr.api.key")
    val baseUrl = config.getString("flickr.api.baseurl")

    new FlickrClient(apiKey, baseUrl, HttpClient.fromConfig(), ResponseParser.fromConfig(config))
  }
}
