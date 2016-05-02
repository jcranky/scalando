package com.jcranky.scalando.cap06

object Lists extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = List(foto1, foto2, foto3, foto1)
  fotos.foreach(println)

  println(fotos(1))

  val fotos2 = foto1 :: foto2 :: foto3 :: foto1 :: Nil
  val fotos3 = Nil.::(foto1).::(foto3).::(foto2).::(foto1)

  val fotos4 = fotos :+ foto2
  val fotos5 = foto2 +: fotos

  fotos match {
    case head :: tail => println(head)
    case _ =>
  }

  fotos match {
    case head :: Nil => println(head)   // ::
    case Nil =>
  }

  def printaLista(lista: List[Foto]): Unit = {
    lista match {
      case head :: Nil =>
        println(head)         // ::

      case head :: tail =>    // ::
        println(head)
        printaLista(tail)

      case Nil =>
    }
  }

  printaLista(fotos)
}
