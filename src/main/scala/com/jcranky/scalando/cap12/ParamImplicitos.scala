package com.jcranky.scalando.cap12

import com.jcranky.scalando.cap11.{Foto, ResponseParser, XMLParser}

import scala.io.Source

object ParamImplicitos extends App {
  val apiKey = "flickr-api-key"

  def buscaFotosComImplicits(tag: Option[String])(
    implicit parser: ResponseParser): Seq[Foto] = {

    val method = "flickr.photos.search"
    val tagText = tag.map("&tags=" + _).getOrElse("")

    val params = s"?method=$method&per_page=10&api_key=$apiKey$tagText"
    val url =
      s"https://api.flickr.com/services/rest/$params"

    parser.parse(Source.fromURL(url).mkString)
  }


  implicit val parser: ResponseParser = new XMLParser()

  val fotos = buscaFotosComImplicits(None)
  fotos foreach println

}
