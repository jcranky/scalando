package com.jcranky.scalando.cap04

object CaseMedia extends App {
  case class Media(value: String)

  val fotos = Media("fotos")
  val videos = Media("videos")
  val all = Media("all")

  fotos == new Media("fotos")    // true
  videos == new Media("videos")  // true
  fotos == videos                // false

  println(videos)
}
