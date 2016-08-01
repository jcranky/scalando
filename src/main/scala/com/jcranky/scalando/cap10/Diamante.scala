package com.jcranky.scalando.cap10

object Diamante extends App {
  trait LogBase {
    def log(msg: String): Unit
  }

  trait LogArquivo extends LogBase {
    override def log(msg: String) = println(s"logando $msg no arquivo")
  }

  trait LogConsole extends LogBase {
    override def log(msg: String) = println(s"logando $msg no console")
  }

  new LogArquivo{}.log("olá trait!")

  val logger = new LogArquivo with LogConsole
  logger.log("importante!")

  val logger2 = new LogConsole with LogArquivo
  logger2.log("importante!")

}
