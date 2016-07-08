package com.jcranky.scalando.cap08

object TiposParametrizados extends App {
  case class Foto(id: String, owner: String, server: Int, title: String)

  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = Set(foto1, foto2, foto3)
  val fotosExplicito: Set[Foto] = Set(foto1, foto2, foto3)

  // não compila pois uma string não é uma foto
  // val fotos: Set[Foto] = Set(foto1, foto2, foto3, "foto em string?")

  val fotosGenericas = Set(foto1, foto2, foto3, "foto em string?")

  val listaVazia = List.empty
  val listaStringVazia = List.empty[String]
}
