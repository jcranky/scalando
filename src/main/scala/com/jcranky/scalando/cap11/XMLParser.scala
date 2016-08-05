package com.jcranky.scalando.cap11

case class Foto(id: Long, owner: String, server: Int, title: String)

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}

class XMLParser extends ResponseParser {
  import scala.xml.XML

  override def parse(str: String): Seq[Foto] = {
    val xmlResp = XML.loadString(str)

    xmlResp \\ "photo" map { p =>
      Foto(
        (p \ "@id" text).toLong,
        p \ "@owner" text,
        (p \ "@server" text).toInt,
        p \ "@title" text)
    }
  }
}
