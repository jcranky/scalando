package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

import scala.xml.XML

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}

// TODO: create a 'fromConfig' in the object ResponseParser that uses config information to choose Xml vs. Json parsing
// TODO: model error codes (https://www.flickr.com/services/api/flickr.photos.search.html)
// TODO: probably should have generic Response models, to be used by the specific parser's implementations

final class XmlFlickrParser extends ResponseParser {

  import XmlFlickrParser._

  // TOOD: proper erro handling in the parsing below
  override def parse(xmlStr: String): Seq[Foto] =
    (XML.loadString(xmlStr) \\ "photo").map { photoXml =>
      Foto(
        (photoXml \ "@id").text,
        (photoXml \ "@owner").text,
        (photoXml \ "@secret").text,
        (photoXml \ "@server").text,
        (photoXml \ "@farm").text.toInt,
        (photoXml \ "@title").text,
        calcBoolean((photoXml \ "@ispublic").text),
        calcBoolean((photoXml \ "@isfriend").text),
        calcBoolean((photoXml \ "@isfamily").text)
      )
    }
}

object XmlFlickrParser {
  // TODO: write a test for this guy
  def calcBoolean(rawAttribute: String): Boolean =
    rawAttribute.toInt match {
      case 1 => true
      case _ => false
    }

  def fromConfig(config: Config): XmlFlickrParser = new XmlFlickrParser()
}
