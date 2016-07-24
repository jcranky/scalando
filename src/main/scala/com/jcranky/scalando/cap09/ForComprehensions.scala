package com.jcranky.scalando.cap09

import com.jcranky.scalando.cap03.FlickrCaller

object ForComprehensions extends App {
  // TODO: trocar por um FlickrCaller local que retorne Fotos stub
  val caller = new FlickrCaller()
  val tags = Set("scala", "java", "jvm")

  tags.foreach { tag =>
    val fotos = caller.buscaFotos(tag)
    fotos foreach println
  }

  for {
    tag <- tags
    foto <- caller.buscaFotos(tag)
  } println (foto)
}
