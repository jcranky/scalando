package com.jcranky.flickr

import com.jcranky.flickr.HttpClient.{GetError, GetResponse}
import org.specs2.mutable.Specification

/**
  * This is more an integration test then unit test, because it hits a real http server.
  */
class HttpClientSpec extends Specification {
  "the http client" should {
    "respond with a body" in {
      new HttpClient().get("https://httpbin.org/get") must beRight[GetResponse]
    }

    "respond with an error" in {
      new HttpClient().get("bla-bla") must beLeft[GetError]
    }
  }
}
