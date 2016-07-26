package com.jcranky.scalando.cap09

case class Foto(id: Int, title: String, tags: Set[String])

class FlickrCaller {
  // retorna uma lista fixa de fotos, apenas para testes
  def buscaFotos(tag: String): Seq[Foto] = {
    Seq(
      Foto(1, "minha foto", Set("scala", "jvm")),
      Foto(1, "outra foto", Set("scala", "java")),
      Foto(1, "foto dele", Set("java")),
      Foto(1, "alguma foto", Set("java", "jvm"))
    )
  }
}
