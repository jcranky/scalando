package com.jcranky.scalando.cap11

object XML extends App {
  val fotos =
    <fotos>
      <foto>uma foto</foto>
      <foto>outra foto</foto>
    </fotos>

  val fotosTxts = fotos \ "foto"
  val textosFotos = (fotos \ "foto").map(_.text)
}
