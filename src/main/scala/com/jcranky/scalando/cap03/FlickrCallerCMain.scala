package com.jcranky.scalando.cap03

class FlickrCallerCVal(val apiKey: String)

object FlickrCallerCMain extends App {
  val caller = new FlickrCallerCVal("apikey")
  println(caller.apiKey)
}
