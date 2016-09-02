package com.jcranky.flickr

import com.jcranky.flickr.model.Foto

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}

final class XmlParser extends ResponseParser {
  override def parse(str: String): Seq[Foto] = ???
}

object XmlParser {
  def fromConfig(): XmlParser = new XmlParser()
}
