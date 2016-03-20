package com.jcranky.scalando.cap04

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

}
