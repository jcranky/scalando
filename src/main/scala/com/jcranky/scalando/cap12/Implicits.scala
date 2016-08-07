package com.jcranky.scalando.cap12

import com.jcranky.scalando.cap11.Foto

object Implicits extends App {
  "99".toInt

  implicit def toPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)

  Foto(1234, "jcranky", 1234, "Foto 1").print
}

class PrintableFoto(foto: Foto) {
  def print = println(s"printando foto [$foto]...")
}
