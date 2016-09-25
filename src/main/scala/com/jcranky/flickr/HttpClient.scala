package com.jcranky.flickr

/**
  * A very simple Http client, that only do GET requests.
  */
class HttpClient {
  // TODO: change this to return a Either[SomeError, Response], with response code and body
  // TODO: write a test for guy?
  def get(url: String): String =
    scala.io.Source.fromURL(url).getLines().mkString("\n")
}

object HttpClient {
  def fromConfig(): HttpClient = new HttpClient()
}
