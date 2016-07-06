package com.jcranky.scalando.cap07

object FoldReduce extends App {
  val numeros = List(1,2,3,4,5)
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

}
