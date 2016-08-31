package com.jcranky.flickr

import com.typesafe.config.Config

class FlickrClient(apiKey: String) {
  // TODO: implement stuff !
}

object FlickrClient {
  def fromConfig(config: Config): FlickrClient = {
    val apiKey = config.getString("flickr.api.key")

    new FlickrClient(apiKey)
  }
}
