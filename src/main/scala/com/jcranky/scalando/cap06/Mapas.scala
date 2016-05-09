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

}
