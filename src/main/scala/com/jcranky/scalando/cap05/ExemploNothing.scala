package com.jcranky.scalando.cap05

object ExemploNothing extends App {
  val listaVazia = List[Nothing]()
  val lista: List[String] = listaVazia
  val lista2: List[String] = List.empty
}
