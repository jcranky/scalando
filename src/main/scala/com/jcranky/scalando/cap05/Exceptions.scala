package com.jcranky.scalando.cap05

import java.io.IOException

import scala.util.control.NonFatal

object Exceptions extends App {
  def buscaFotos(tag: Option[String]) = throw new NotImplementedError()

  try {
    buscaFotos(Some("scala"))
  } catch {
    case t: Throwable => println(s"exceção ao tentar buscar fotos: ${t.getMessage}")
  }

  try {
    buscaFotos(Some("scala"))
  } catch {
    case e: IOException => println("exceção de IO ao tentar buscar fotos")
    case e: Exception => println("exceção indefinida ao tentar buscar fotos")
    case _ => println("alguma outra exceção")
  }

  try {
    buscaFotos(Some("scala"))
  } catch {
    case e: IOException => println("exceção de IO ao tentar buscar fotos")
    case e: Exception => println("exceção indefinida ao tentar buscar fotos")
    case NonFatal(t) => println("alguma outra exceção segura")
  }
}
