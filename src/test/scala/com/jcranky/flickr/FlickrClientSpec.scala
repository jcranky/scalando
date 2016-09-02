package com.jcranky.flickr

import com.typesafe.config.{ConfigException, ConfigFactory}
import org.specs2.mutable.Specification

class FlickrClientSpec extends Specification {
  "FlickrClient.fromConfig" should {
    "work with valid configuration" in {
      val client = FlickrClient.fromConfig(ConfigFactory.load("app-test.conf"))
      client !=== null
    }

    "fail if some configuration is missing" in {
      FlickrClient.fromConfig(ConfigFactory.load("wrong.conf")) should throwAn[ConfigException]
    }
  }

  "FlickrClient.buscaFotos" should {
    "ask the httpclient for the photos and pass the response to the response parser" in {
      pending
    }
  }
}
