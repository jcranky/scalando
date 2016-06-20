package com.jcranky.scalando.cap07

import com.jcranky.scalando.cap06.Foto

object ForEach extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = List(foto1, foto2, foto3, foto1)

  fotos.foreach(println)

  println("-" * 50)

  fotos.foreach(f => println(f))

  println("-" * 50)

  fotos.foreach(println(_))
}
