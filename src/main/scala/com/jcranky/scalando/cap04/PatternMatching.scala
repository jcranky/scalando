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
}
