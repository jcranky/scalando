package com.jcranky.scalando.cap10

object DiamanteSuper extends App {
  trait LogBase {
    def log(msg: String): Unit
  }

  // remova os "abstract" abaixo se quiser ver a mensagem de erro relativa a overrides abstratos

  trait LogArquivo extends LogBase {
    abstract override def log(msg: String): Unit = {
      super.log(msg)
      println(s"logando $msg no arquivo")
    }
  }

  trait LogConsole extends LogBase {
    abstract override def log(msg: String): Unit = {
      super.log(msg)
      println(s"logando $msg no console")
    }
  }

  class EmptyLogger extends LogBase {
    override def log(msg: String): Unit = {}
  }

//  val logger2 = new LogConsole with LogArquivo

  val logger = new EmptyLogger with LogConsole with LogArquivo
  logger.log("Olá Scaladores!")
}
