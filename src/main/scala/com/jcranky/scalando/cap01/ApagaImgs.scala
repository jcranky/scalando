package com.jcranky.scalando.cap01

import _root_.java.io.File

// para executar as instruções abaixo como um script scala basta colocá-las na
// raiz do arquivo, ao invés de dentro do object
object ApagaImgs extends App {
  val arquivos = new File(".").listFiles
  val extensoesImgs = List(".jpg", ".jpeg", ".gif", ".png")

  def ehImagem(nomeArq: String) = extensoesImgs.exists(nomeArq.endsWith(_))

  arquivos.filter(arq => ehImagem(arq.getName)).foreach(_.delete)
}
