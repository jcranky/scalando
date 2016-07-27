package com.jcranky.scalando.cap09

object Monads extends App {

  def buscaFoto(tag: Option[String]) = {
    val tagText = tag.map("&tags=" + _).getOrElse("")

    val tagTextFor = for {
      t <- tag
    } yield "&tags=" + t

    ""
  }

  val userOpt = Option("jcranky")
  val passOpt = Option("1234")

  def autentica(user: String, pass: String): Option[String] =
    if (user == "jcranky" && pass == "1234") Some("token")
    else None

  val tokenOpt = for {
    user <- userOpt
    pass <- passOpt
    token <- autentica(user, pass)
  } yield token
}
