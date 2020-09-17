package com.jcranky.scalando.cap08

object Covariancia extends App {
  import LowerTypeBounds._
  import Invariancia.FotoDetalhada

  val fotos = List(new Foto(1, Set.empty))
  val fotosDetalhadas = List(
    new FotoDetalhada(2, "jcranky", 321, "scalax2", Set.empty, "detalhes da foto")
  )

  def printaFotos(fotos: List[Foto]): Unit = fotos foreach println

  printaFotos(fotos)
  printaFotos(fotosDetalhadas)
}
