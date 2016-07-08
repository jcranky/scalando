package com.jcranky.scalando.cap07

object FoldReduce extends App {

  case class Foto(id: String, owner: String, server: Int, title: String, tags: Option[List[String]])

  val numeros = List(1, 2, 3, 4, 5)
  val soma = numeros.reduceLeft((acumulado, x) => acumulado + x)
  println(s"soma= $soma")

  println("-" * 50)

  def somar(x: Int, y: Int) = x + y

  val somaManual = somar(somar(somar(somar(1, 2), 3), 4), 5)
  println(s"soma manual= $somaManual")

  println("-" * 50)

  val somaPronta = List(1, 2, 3, 4, 5).sum
  println(s"soma pronta= $somaPronta")

  // não compila pois Strings não são "somáveis"
  // val somaInvalida = List("um", "dois", "três", "quatro", "cinco").sum


  println("-" * 50)

  val foto1 = new Foto("id1", "jcranky", 1,
    "uma foto do jcranky", Some(List("livro", "scala")))
  val foto2 = new Foto("id2", "jcranky", 1,
    "outra foto do jcranky", Some(List("scala", "jcranky")))
  val foto3 = new Foto("id3", "jcranky", 1,
    "mais uma foto do jcranky", Some(List("livro", "jcranky")))

  val fotos = List(foto1, foto2, foto3)

  val tags = fotos.foldLeft(Set.empty[String])(
    (tags, foto) => foto.tags.map(tags ++ _).getOrElse(tags)
  )
  println(tags)
}
