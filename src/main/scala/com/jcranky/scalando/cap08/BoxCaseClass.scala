package com.jcranky.scalando.cap08

object BoxCaseClass extends App {
  import LowerTypeBounds._
  import Invariancia._

  val foto = Foto(1, Set.empty)
  val fotoDetalhada = new FotoDetalhada(1, "jcranky", 123, "scala", Set.empty, "nada")

  println(foto == fotoDetalhada)
}
