package com.jcranky.flickr

import com.typesafe.config.ConfigFactory

object Main extends App {
  val config = ConfigFactory.load()
  val flickrClient = FlickrClient.fromConfig(config)

  flickrClient.buscaFotos(List("scala")).foreach(println)
}
