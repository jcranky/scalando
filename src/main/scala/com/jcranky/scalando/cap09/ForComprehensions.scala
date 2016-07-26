package com.jcranky.scalando.cap09

object ForComprehensions extends App {
  val caller = new FlickrCaller()
  val tags = Set("scala", "java", "jvm")

  // foreachs

  tags.foreach { tag =>
    val fotos = caller.buscaFotos(tag)
    fotos foreach println
  }

  println("-" * 50)

  for {
    tag <- tags
    foto <- caller.buscaFotos(tag)
  } println (foto)

  // maps e flatMaps
  println
  println("-" * 50)

  val fotosMapeadas = tags.flatMap(tag => caller.buscaFotos(tag).map(_.title))
  fotosMapeadas foreach println

  println("-" * 50)

  val fotosMapeadasFor = for {
    tag <- tags
    foto <- caller.buscaFotos(tag)
  } yield foto.title
  fotosMapeadasFor foreach println

  // filter
  println
  println("-" * 50)

  val nomesFiltrados = tags.filter(_.startsWith("j"))
    .flatMap(tag => caller.buscaFotos(tag).map(_.title))
  nomesFiltrados foreach println

  println("-" * 50)

  val nomesFiltradosFor = for {
    tag <- tags if tag.startsWith("j")
    foto <- caller.buscaFotos(tag)
  } yield foto.title
  nomesFiltradosFor foreach println
}
