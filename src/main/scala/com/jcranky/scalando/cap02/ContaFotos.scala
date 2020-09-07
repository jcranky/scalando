package com.jcranky.scalando.cap02

class Foto(val id: Long, val owner: String, val title: String, val farm: Int)

object ContaFotos extends App {
  val resultadoServico =
    """
      |<rsp stat="ok">
      |<photos page="1" pages="666" perpage="100" total="66585">
      |  <photo id="25046413926" owner="119192561@N02" secret="d5764b727f" server="1535"
      |         farm="2" title="Scala" ispublic="1" isfriend="0" isfamily="0"/>
      |  <photo id="24702428649" owner="130046925@N04" secret="53c63a4475" server="1467"
      |         farm="2" title="NY" ispublic="1" isfriend="0" isfamily="0"/>
      |  <photo id="24305307114" owner="76999786@N02" secret="af03afc09d" server="1613"
      |         farm="2" title="Future starts slow" ispublic="1" isfriend="0" isfamily="0"/>
      |  <photo id="25029759906" owner="124408581@N06" secret="fea9e2a565" server="1607"
      |         farm="2" title="Elizabeth Dress &amp; Shoes_003" ispublic="1" isfriend="0"
      |         isfamily="0"/>
      |  <photo id="24938009862" owner="124408581@N06" secret="9a55753645" server="1554"
      |         farm="2" title="Elizabeth Dress &amp; Shoes_004" ispublic="1" isfriend="0"
      |         isfamily="0"/>
      |  <photo id="24328322599" owner="79920649@N07" secret="1407ca8449" server="1453"
      |         farm="2" title="Lonely Robot London Scala 201215" ispublic="1" isfriend="0"
      |         isfamily="0"/>
      |</photos>
      |</rsp>
    """.stripMargin

  // dados fixos apenas para teste, parseamento do XML é feito em um capítulo futuro
  def parseiaResultado(resultado: String): List[Foto] = List(
    new Foto(25046413926L, "119192561@N02", "Scala", 2),
    new Foto(24702428649L, "130046925@N04", "NY", 2),
    new Foto(24305307114L, "76999786@N02", "Future starts slow", 2),
    new Foto(25029759906L, "124408581@N06", "Elizabeth Dress &amp; Shoes_003", 2),
    new Foto(24938009862L, "124408581@N06", "Elizabeth Dress &amp; Shoes_004", 2),
    new Foto(24328322599L, "124408581@N06", "Lonely Robot London Scala 201215", 7)
  )

  val fotos = parseiaResultado(resultadoServico)
  val countFotosFarm2 = fotos.count(foto => foto.farm == 2)

  println(s"count: $countFotosFarm2")
}
