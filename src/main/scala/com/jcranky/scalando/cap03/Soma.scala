package com.jcranky.scalando.cap03

object Soma extends App {

  def soma(x: Int, y: Int) = x + y

  // retorno explícito
  def somaExplicita(x: Int, y: Int): Int = x + y

  // alterando o tipo de retorno "sem querer"
  def somaAlterada(x: Int, y: Int) = x + y + 1.0
}
