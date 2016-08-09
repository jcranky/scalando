package com.jcranky.scalando.cap12

import com.jcranky.scalando.cap11.Foto

object ConflitoImplicits extends App {
  implicit def toPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)
  implicit def newPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)

  // descomente para ver o erro de compilação com implicits ambíguos
  // Foto("foto1", "jcranky", 1234, "Foto 1", None).print
}
