package com.jcranky.scalando.cap06

object Sets extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = Set(foto1, foto2, foto3, foto1)

  fotos.foreach(println)

  println("-"*30)

  val foto4 = new Foto("id4", "jcranky", 1, "ainda mais uma foto do jcranky")
  val novasFotos = fotos + foto4

  novasFotos.foreach(println)

  println("-"*30)

  val fotosIguais = fotos + foto1
  val resultado = fotosIguais == fotos

  println(resultado)

  println("-"*30)

  val menosFotos = fotos - foto1
  menosFotos.foreach(println)
}
