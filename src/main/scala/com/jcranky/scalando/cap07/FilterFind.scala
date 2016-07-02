package com.jcranky.scalando.cap07

import com.jcranky.scalando.cap06.Foto

object FilterFind extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = List(foto1, foto2, foto3, foto1)

  def fotoJCranky(foto: Foto) = foto.owner == "jcranky"
  val fotosDoJCranky = fotos.filter(fotoJCranky)
//  val fotosDoJCranky = fotos filter fotoJCranky

  println(fotosDoJCranky)

  println("-" * 50)

  def fotoDe(owner: String, foto: Foto) = foto.owner == owner
  val fotosDoJCranky2 = fotos.filter(fotoDe("jcranky", _))
  println(fotosDoJCranky2)

  val fotoDoJCrankyOpt = fotos find fotoJCranky
  println(fotoDoJCrankyOpt)

  println("-" * 50)

  val fotosDoJCranky3 = fotos.filter(_.owner == "jcranky")
  val fotoDoJCrankyOpt2 = fotos.find(_.owner == "jcranky")

  println(fotosDoJCranky3)
  println(fotoDoJCrankyOpt2)
}
