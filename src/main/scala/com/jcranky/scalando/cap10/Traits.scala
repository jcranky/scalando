package com.jcranky.scalando.cap10

import com.jcranky.scalando.cap09.Foto

object Traits extends App {
  trait ResponseParser {
    def parse(str: String): Set[Foto]
  }

  // loga direito via println, um pouco simplista
  trait LoggerSimples {
    def log(msg: String): Unit = println(msg)
  }


  trait Logger {
    def log(msg: String): Unit
  }
  trait ConsoleLogger extends Logger {
    def log(msg: String): Unit = println(msg)
  }



  abstract class XmlParser extends ResponseParser with Logger {
    def parse(str: String): Set[Foto] = ???
  }

  abstract class JsonParser extends ResponseParser with Logger with Ordered[JsonParser] {
    def parse(str: String): Set[Foto] = ???
    def compare(that: JsonParser): Int = ???
  }


  val parser = new JsonParser with ConsoleLogger
}
