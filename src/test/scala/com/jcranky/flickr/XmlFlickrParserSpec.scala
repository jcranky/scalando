package com.jcranky.flickr

import com.jcranky.flickr.model.Foto
import com.typesafe.config.ConfigFactory
import org.specs2.mutable.Specification

import scala.io.Source

class XmlFlickrParserSpec extends Specification {
  val config = ConfigFactory.load("test/resources/app-test.conf")

  "the response parser" should {
    "get a list of photos" in {
      val parser = new XmlFlickrParser()
      val response = Source.fromFile("src/test/resources/flickr/responses/photos-list.xml").getLines().mkString("\n")

      val parsed = parser.parse(response)

      parsed should containTheSameElementsAs(List(
        Foto("29195658220", "28437914@N03", "cfe85ac898", "8457", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195655410", "28437914@N03", "c4e6935947", "8353", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195651850", "28437914@N03", "51449e97fc", "8845", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195648660", "28437914@N03", "2529785ac8", "8537", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("28862292093", "28437914@N03", "0097cc7e69", "8521", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195634910", "28437914@N03", "a4959f2252", "8009", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195632880", "28437914@N03", "ac48c82796", "8289", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195630990", "28437914@N03", "e8077623c9", "8300", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195629640", "28437914@N03", "0b5dcba3b7", "7536", 8, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195627610", "28437914@N03", "cbd39378ef", "7561", 8, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195624830", "28437914@N03", "2e4182f583", "8283", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("28862264913", "28437914@N03", "20b5061be3", "8830", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("28862261533", "28437914@N03", "b847eb1e9f", "8426", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("28862258423", "28437914@N03", "342002b429", "8438", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195617710", "28437914@N03", "30857f493b", "7461", 8, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195614540", "28437914@N03", "08b335036e", "8537", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195611040", "28437914@N03", "173b37d510", "8371", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195605970", "28437914@N03", "9607915a90", "8538", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false),
        Foto("29195600910", "28437914@N03", "7c21f55703", "8197", 9, "MITO_SettembreMusica2016_Inaugurazione_Milano_high", true, false, false)
      ))
    }
  }
}
