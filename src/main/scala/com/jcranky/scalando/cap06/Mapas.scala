package com.jcranky.scalando.cap06

object Mapas extends App {
  val services = Map(
    ("busca", "flickr.photos.search"),
    ("tamanhos", "flickr.photos.getSizes")
  )

  val services2 = Map(
    "busca" -> "flickr.photos.search",
    "tamanhos" -> "flickr.photos.getSizes"
  )

  println(services == services2)

  val metodoBusca = services("busca")
  val metodoBuscaOpt = services.get("busca")

  val metodoBuscaPadrao = services.getOrElse("busca", "método padrão")

  val novosServices = services + ("untagged" -> "flickr.photos.getUntagged")
  println(novosServices)

  val menosServices = services - "busca"
  println(menosServices)

  val servicesAtualizados = services.updated("busca", "flickr.photos.newSearch")
  println(servicesAtualizados)
}
