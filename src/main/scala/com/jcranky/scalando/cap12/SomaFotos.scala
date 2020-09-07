package com.jcranky.scalando.cap12

object SomaFotos extends App {
  case class Foto(id: Long, owner: String, server: Int, title: String)

  object Foto {
    implicit object FotoNumeric extends FotoNumeric
  }

  class FotoNumeric extends Numeric[Foto] {
    override def plus(fotoX: Foto, fotoY: Foto): Foto =
      fotoY.copy(title = fotoX.title + fotoY.title)
    override def fromInt(x: Int): Foto =
      new Foto(x, "unknown", 0, "unknown")

    override def minus(x: Foto, y: Foto): Foto = x
    override def toDouble(x: Foto): Double = x.id.toDouble
    override def toFloat(x: Foto): Float = x.id.toFloat
    override def toInt(x: Foto): Int = x.id.toInt
    override def negate(x: Foto): Foto = x
    override def toLong(x: Foto): Long = x.id
    override def times(x: Foto, y: Foto): Foto = x
    override def compare(x: Foto, y: Foto): Int = 0
    override def parseString(str: String): Option[Foto] = None
  }

  val fotos = List(
    Foto(123, "jcranky", 1234, "Foto 1"),
    Foto(124, "jcranky", 4321, "Foto 2")
  )

  println("Somando fotos: " + fotos.sum)
}
