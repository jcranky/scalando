package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config
import FlickrClient._

class FlickrClient(apiKey: String, baseUrl: String, httpClient: HttpClient, responseParser: ResponseParser) {

  // TODO: usar Either para tratar error e evitar precisar lançar excessões ....
  def buscaFotos(tag: String): Seq[Foto] = {
    //val url = s"$baseUrl?method=$method&api_key=$apiKey&tags=$tags"

    //usar o HttpClient ao invés da chamada direta abaixo
    //scala.io.Source.fromURL(url).getLines().foreach(println)

    // usar algum response parsear aqui, para retornar a lista de fotos

    ???
  }
}

object FlickrClient {
  val searchMethod = "flickr.photos.search"

  def fromConfig(config: Config): FlickrClient = {
    val apiKey = config.getString("flickr.api.key")
    val baseUrl = config.getString("flickr.api.baseurl")

    new FlickrClient(apiKey, baseUrl, HttpClient.fromConfig(), XmlParser.fromConfig())
  }
}
