package com.jcranky.scalando.cap11

import scala.io.Source

object XMLs extends App {
  val fotos =
    <fotos>
      <foto>uma foto</foto>
      <foto>outra foto</foto>
    </fotos>

  val fotosTxts = fotos \ "foto"
  val textosFotos = (fotos \ "foto").map(_.text)

  def buscaFotos(tag: Option[String]): Seq[Foto] = {
    val apiKey = "sua-api-key"
    val method = "flickr.photos.search"
    val tags = "scala"

    val url = s"https://api.flickr.com/services/rest/?method=$method&api_key=$apiKey&tags=$tags"

    new XMLParser().parse(Source.fromURL(url).mkString)
  }
}
