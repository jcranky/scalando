package com.jcranky.scalando.cap04

import com.jcranky.scalando.cap04.ObjectMedia.{Fotos, Media, Videos}

object PatternMatching extends App {
  val FOTOS = 1
  val VIDEOS = 2
  val TODAS = 3

  val midia = 1
  midia match {
    case FOTOS => println("processando fotos")
    case VIDEOS => println("processando videos")
    case _ => println("processando qualquer outra coisa")
  }

  // expressão
  val texto = midia match {
    case FOTOS => "processando fotos"
    case VIDEOS => "processando videos"
    case _ => "processando qualquer outra coisa"
  }
  println(texto)

  // inferência de tipos
  val resultado = midia match {
    case FOTOS => "processando fotos"
    case VIDEOS => "processando videos"
    case _ => -1
  }
  println(resultado)

  // com case objects
  val midiaObject: Media = Fotos
  val textoObject = midiaObject match {
    case Fotos => "processando fotos"
    case Videos => "processando videos"
    case _ => "processando qualquer outra coisa"
  }
  println(textoObject)

  // extraindo valores de case classes
  case class Foto(id: Int, owner: String, title: String, farm: Int)
  val foto = Foto(1, "jcranky", "Scala Rulez", 1)
  val teste = foto match {
    case Foto(_, "jcranky", _, _) => true
    case _ => false
  }
  println(teste)

  // condições de guarda
  val teste2 = foto match {
    case Foto(_, "jcranky", _, farm) if farm == 7 => true
    case _ => false
  }
  println(teste2)
}
