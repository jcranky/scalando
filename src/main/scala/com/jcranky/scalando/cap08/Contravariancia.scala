package com.jcranky.scalando.cap08

object Contravariancia extends App {
  import LowerTypeBounds._
  import Invariancia._

  val printaFoto: Foto => Unit = println
  val printaFotoDetalhada: FotoDetalhada => Unit = (foto: Foto) => println(foto)

  // não compila, pois FotoDetalhada não é pai de Foto, o que quebra a contra-variancia da lista de parâmetros
  // val printaFotoImpossivel: Foto => Unit = (fotoDet: FotoDetalhada) => println(fotoDet)
}
