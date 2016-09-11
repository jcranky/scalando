package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}

// TODO: create a 'fromConfig' in the object ResponseParser that uses config information to choose Xml vs. Json parsing
// TODO: model error codes (https://www.flickr.com/services/api/flickr.photos.search.html)
// TODO: probably should have generic Response models, to be used by the specific parser's implementations

final class XmlFlickrParser extends ResponseParser {
  override def parse(str: String): Seq[Foto] = Nil
}

object XmlFlickrParser {
  def fromConfig(config: Config): XmlFlickrParser = new XmlFlickrParser()
}
