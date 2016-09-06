package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.Config

sealed trait ResponseParser {
  def parse(str: String): Seq[Foto]
}
// TODO: criar um fromConfig no object ResponseParser que usa uma config para escolher Xml vs. Json parsing

final class XmlFlickrParser extends ResponseParser {
  override def parse(str: String): Seq[Foto] = ???
}

object XmlFlickrParser {
  def fromConfig(config: Config): XmlFlickrParser = new XmlFlickrParser()
}
