package com.jcranky.scalando.cap08

object Invariancia extends App {
  import LowerTypeBounds._

  val fotos: Set[Foto] = Set(Foto(1, Set.empty))
  def printaFotos(fotos: Set[Foto]) = fotos foreach println
  printaFotos(fotos)

  ///

  class FotoDetalhada(id: Int, owner: String, server: Int, title: String,
                      tags: Set[String], detalhes: String)
    extends Foto(id, tags)

  val fotosDet =
    Set(new FotoDetalhada(2, "jcranky", 321, "scalax2", Set.empty, "detalhes da foto"))

  // não compila pois Set[FotoDetalhada] não é um Set[Foto]
  // printaFotos(fotosDet)
}
