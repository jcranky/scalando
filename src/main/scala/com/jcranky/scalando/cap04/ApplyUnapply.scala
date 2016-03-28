package com.jcranky.scalando.cap04

object ApplyUnapply extends App {
  class Foto(val id: Int, val owner: String, val title: String, val farm: Int)

  object Foto {
    def unapply(foto: Foto): Option[(Int, String, String, Int)] = Some((foto.id, foto.owner, foto.title, foto.farm))
  }
}
