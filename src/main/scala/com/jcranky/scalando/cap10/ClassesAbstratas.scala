package com.jcranky.scalando.cap10

import com.jcranky.scalando.cap09.Foto

object ClassesAbstratas extends App {

  abstract class ResponseParser {
    def parse(str: String): Set[Foto]
  }

  class XMLParser extends ResponseParser {
    def parse(str: String): Set[Foto] = ???
  }

  class JsonParser extends ResponseParser {
    def parse(str: String): Set[Foto] = ???
  }
}
