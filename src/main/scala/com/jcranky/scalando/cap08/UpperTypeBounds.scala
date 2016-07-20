package com.jcranky.scalando.cap08

object UpperTypeBounds extends App {
  import LowerTypeBounds._

  def printaFotos(medias: Set[Media]) = medias.foreach(println)
  def printaFotos2[T <: Media](medias: Set[T]) = medias.foreach(println)

  val setDeFotos = Set(Foto(1, Set.empty))

  // não compila pois Set[Foto] não é Set[Media]
  // printaFotos(setDeFotos)

  printaFotos2(setDeFotos)
}
