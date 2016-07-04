package com.jcranky.scalando.cap07

object FlatMap extends App {
  case class Foto(id: String, owner: String, server: Int, title: String, tags: Option[List[String]])

  def buscaFotos(tag: Option[String]): List[Foto] = {
    // lista hard-coded para testes
    val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky", Some(List("scala")))
    val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky", None)
    val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky", Some(List("scala", "jvm")))

    List(foto1, foto2, foto3)
  }

  val tags = List("scala", "java", "typesafe")

  val fotos = tags.map(tag => buscaFotos(Some(tag)))
  println(fotos)

  val fotosCompactadas = tags.flatMap(tag => buscaFotos(Some(tag)))
  println(fotosCompactadas)
}
