package com.jcranky.scalando.cap06

object Conclusao extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = Set(foto1, foto2, foto3, foto1)

  val foto4 = new Foto("id4", "jcranky", 1, "ainda mais uma foto do jcranky")
  val novasFotos = fotos + foto4

  println(fotos == novasFotos)
}
