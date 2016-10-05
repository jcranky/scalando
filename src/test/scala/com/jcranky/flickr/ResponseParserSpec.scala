package com.jcranky.flickr

import org.specs2.mutable.Specification

class ResponseParserSpec extends Specification {
  "ResponseParser.flickrBoolean" should {
    "return true for 1" in {
      ResponseParser.flickrBoolean("1") ==== true
    }

    "return false for 0" in {
      ResponseParser.flickrBoolean("0") ==== false
    }

    "return false for 3" in {
      ResponseParser.flickrBoolean("3") ==== false
    }
  }
}
