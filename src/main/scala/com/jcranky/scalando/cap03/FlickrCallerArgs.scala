package com.jcranky.scalando.cap03

object  FlickrCallerArgs extends App {
//  def buscaFotos(tag: String, userId: String) = ???
  def buscaFotos(tag: String = "", userId: String = "") = ???

  // possíveis formas de uso do método acima:
  buscaFotos("scala")
  buscaFotos(userId = "userid")
  buscaFotos("scala", userId = "userid")

  class FlickrCaller(api: String = "")
  val caller = new FlickrCaller()
}
