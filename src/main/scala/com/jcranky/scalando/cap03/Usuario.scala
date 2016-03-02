package com.jcranky.scalando.cap03

object Usuario extends App {
  val usuarioOpt: Option[String] = None

  def usuarioAtual() = usuarioOpt match {
    case Some(usuario) => usuario
    case None => "anônimo"
  }

  def usuarioAtualUniforme = usuarioOpt match {
    case Some(usuario) => usuario
    case None => "anônimo"
  }

  println(s"Usuario: ${usuarioAtual()}")
}
