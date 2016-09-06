package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.ConfigFactory
import org.specs2.mutable.Specification

import scala.io.Source

class XmlFlickerParserSpec extends Specification {
  val config = ConfigFactory.load("test/resources/app-test.conf")

  "the response parser" should {
    "get a list of photos" in {
      val parser = XmlFlickrParser.fromConfig(config)
      val response = Source.fromFile("test/resources/flickr/responses/photos-list.xml").getLines().mkString("\n")

      val parsed = parser.parse(response)

      // TODO: fill with the list of actually expected photos
      parsed should containTheSameElementsAs(List.empty[Foto])
    }
  }
}
