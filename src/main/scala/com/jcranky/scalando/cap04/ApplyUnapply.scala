package com.jcranky.scalando.cap04

object ApplyUnapply extends App {
  class Foto(val id: Int, val owner: String, val title: String, val farm: Int)

  object Foto {
    def unapply(foto: Foto): Option[(Int, String, String, Int)] = Some((foto.id, foto.owner, foto.title, foto.farm))
    def apply(id: Int, owner: String, title: String, farm: Int) = new Foto(id, owner, title, farm)
  }

  val foto = Foto(1, "jcranky", "foto do jcranky", 7)
//  val foto = Foto.apply(1, "jcranky", "foto do jcranky", 7)

  val foto1 = Foto(1, "jcranky", "foto do jcranky", 7)
  val foto2 = Foto(2, "jcranky", "foto do jcranky", 7)
  val foto3 = Foto(3, "jcranky", "foto do jcranky", 7)

  val fotos = List(foto1, foto2, foto3)
  val fotoUm = fotos(0)
}
