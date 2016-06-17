package com.jcranky.scalando.cap06

object Arrays extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = Array(foto1, foto2, foto3)

  println(fotos)

  println(fotos(0))
}
