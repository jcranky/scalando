package com.jcranky.scalando.cap06

object Tuplas extends App {
  val dadosFoto = ("jcranky", "reunião dos scaladores")
  println(s"owner: ${dadosFoto._1} - title: ${dadosFoto._2}")

  val dadosFoto2 = (123, "reunião dos scaladores")
  println(s"id: ${dadosFoto2._1} - title: ${dadosFoto2._2}")

  val dadosFoto3 = (123, "jcranky", "reunião dos scaladores")
  println(s"id: ${dadosFoto3._1} - owner: ${dadosFoto3._2} - title: ${dadosFoto3._3}")

  val dadosFoto4 = (123, "reunião dos scaladores")
  val (id, title) = dadosFoto4

  println(s"id: $id")
  println(s"title: $title")

  val (id2, title2) = (123, "reunião dos scaladores")

  println(s"id: $id2")
  println(s"title: $title2")
}
