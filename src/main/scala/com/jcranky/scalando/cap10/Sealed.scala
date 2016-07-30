package com.jcranky.scalando.cap10

object Sealed extends App {
  sealed abstract class Media(val value: String)

  object Fotos extends Media("fotos")
  object Videos extends Media("videos")
  object Todas extends Media("all")
}
