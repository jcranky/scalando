package com.jcranky.scalando.cap07

import com.jcranky.scalando.cap06.Foto

object Filter extends App {
  val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
  val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
  val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

  val fotos = List(foto1, foto2, foto3, foto1)

  // lança um NotImplementedError
  // val p: (Foto) => Boolean = ???

  def fotosDoJCranky(foto: Foto) = foto.owner == "jcranky"
  val p: (Foto) => Boolean = fotosDoJCranky

  fotos.filter(fotosDoJCranky)

  println("-" * 50)

  fotos.filter(p)

  println("-" * 50)

  fotos.filter(foto => foto.owner == "jcranky")

  println("-" * 50)

  fotos.filter(_.owner == "jcranky")
}
