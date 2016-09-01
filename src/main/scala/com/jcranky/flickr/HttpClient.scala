package com.jcranky.flickr

class HttpClient

object HttpClient {
  def fromConfig(): HttpClient = new HttpClient()
}
