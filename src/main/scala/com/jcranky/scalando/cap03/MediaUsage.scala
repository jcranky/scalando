package com.jcranky.scalando.cap03

object MediaUsage extends App {
  // não compila, pois Media é um object
  // val m = new Media()

  println(Media.fotos)
  println(Media.videos)
  println(Media.todas)
}
