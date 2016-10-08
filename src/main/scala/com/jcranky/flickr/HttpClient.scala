package com.jcranky.flickr

import scala.util.control.NonFatal

/**
  * A very simple Http client, that only do GET requests.
  */
class HttpClient {
  import HttpClient._

  def get(url: String): Either[GetError, GetResponse] = try {
    val body = scala.io.Source.fromURL(url).getLines().mkString("\n")

    // the Source API doesn't allow us to inspect the actual code returned by the server
    Right(GetResponse(200, body))

  } catch {
    case NonFatal(e) => Left(GetError(e.getMessage))
  }
}

object HttpClient {
  case class GetError(msg: String)
  case class GetResponse(code: Int, body: String)

  def fromConfig(): HttpClient = new HttpClient()
}
