package com.jcranky.scalando.cap02

object ClienteFlickr extends App {
  val apiKey = "sua-api-key"
  val method = "flickr.photos.search"
  val tags = "scala"

  val url = s"http://api.flickr.com/services/rest/?method=$method&api_key=$apiKey&tags=$tags"

  scala.io.Source.fromURL(url).getLines().foreach(println)
}
