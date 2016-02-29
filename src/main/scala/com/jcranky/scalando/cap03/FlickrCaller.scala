package com.jcranky.scalando.cap03

import com.jcranky.scalando.cap02.Foto

class FlickrCaller {
  val apiKey = "sua-api-key"

  // sem chaves, implementação com apenas uma linha
  def buscaFotosUmaLinha(tag: String): Seq[Foto] = ???

  def buscaFotos(tag: String): Seq[Foto] = {
    // algoritmo (complexo?) de acesso ao Flickr aqui
    ???
  }

  // usando return, evite!
  def buscaFotosReturn(tag: String): Seq[Foto] = {
    // algoritmo (complexo?) de acesso ao Flickr aqui
    return ???
  }
}
