package com.jcranky.scalando.cap08

object LowerTypeBounds extends App {
  trait Media {
    val tags: Set[String]
  }
  case class Foto(id: Int, tags: Set[String]) extends Media
  case class Video(id: Int, tags: Set[String]) extends Media

  val fotos = Set(Foto(1, Set("scala", "jcranky")), Foto(2, Set("jvm", "jcranky")))
  val videos = Set(Video(1, Set("praia", "ipanema")), Video(2, Set("campo", "ferias")))

  def acumulaTags(media: Media, outraMedia: Media): Media = new Media { val tags = media.tags ++ outraMedia.tags }

  val tagsFotos = fotos.reduceLeft(acumulaTags)
  println(s"tags fotos: ${tagsFotos.tags}")

  val tagsVideos = videos.reduceLeft(acumulaTags)
  println(s"tags videos: ${tagsVideos.tags}")
}
