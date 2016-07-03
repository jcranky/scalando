package com.jcranky.scalando.cap07

import scala.io.Source

object Map extends App {

  case class Foto(id: String, owner: String, server: Int, title: String, tags: Option[List[String]])

  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky", Some(List("scala")))
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky", None)
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky", Some(List("scala", "jvm")))

  val fotos = List(foto1, foto2, foto3)

  val lis = fotos.map(foto => <li>
    {foto.title}
  </li>)

  println(lis)
  println("-" * 50)

  def geraLi(foto: Foto): scala.xml.Elem = <li>
    {foto.title}
  </li>

  val lis2 = fotos map geraLi

  println(lis2)
  println("-" * 50)

  val html =
    <html>
      <body>
        <ul>
          {fotos map geraLi}
        </ul>
      </body>
    </html>

  println(html)
  println("-" * 50)

  val tagsTextOpt = foto1.tags.map(tags => tags.mkString(","))
  println(tagsTextOpt)

  println("-" * 50)

  val tagsText = foto1.tags.map(tags => tags.mkString(",")).getOrElse("")
  println(tagsText)


  def buscaFotos(tag: Option[String]) = {
    val apiKey = "minha-apiKey"
    val method = "flickr.photos.search"
    val tagText = tag.map("&tags=" + _).getOrElse("")

    val url = s"http://api.flickr.com/services/rest/?method=$method&api_key=$apiKey$tagText"
    Source.fromURL(url).getLines.foreach(println)
  }

}
