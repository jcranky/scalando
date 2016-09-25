package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

import scala.xml.XML

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}

// TODO: model error codes (https://www.flickr.com/services/api/flickr.photos.search.html)
// TODO: probably should have generic Response models, to be used by the specific parser's implementations

final class XmlFlickrParser extends ResponseParser {
  import ResponseParser._

  // TOOD: proper error handling in the parsing below
  override def parse(xmlStr: String): Seq[Foto] =
    (XML.loadString(xmlStr) \\ "photo").map { photoXml =>
      Foto(
        (photoXml \ "@id").text,
        (photoXml \ "@owner").text,
        (photoXml \ "@secret").text,
        (photoXml \ "@server").text,
        (photoXml \ "@farm").text.toInt,
        (photoXml \ "@title").text,
        flickrBoolean((photoXml \ "@ispublic").text),
        flickrBoolean((photoXml \ "@isfriend").text),
        flickrBoolean((photoXml \ "@isfamily").text)
      )
    }
}

final class JsonFlickrParser extends ResponseParser {
  /**
    * Implementing this is left as an exercise for the reader.
    */
  override def parse(str: String): Seq[Foto] = ???
}

object ResponseParser {
  // TODO: write a test for this guy
  def flickrBoolean(rawAttribute: String): Boolean =
    rawAttribute.toInt match {
      case 1 => true
      case _ => false
    }

  def fromConfig(config: Config): ResponseParser = {
    val parser = config.getString("flickr.api.parser")
    parser match {
      case "xml" => new XmlFlickrParser()
      case "json" => new JsonFlickrParser()
      // the config could be wrongly set by the user, so we default here to use the xml parser
      case _ => new XmlFlickrParser()
    }
  }
}
