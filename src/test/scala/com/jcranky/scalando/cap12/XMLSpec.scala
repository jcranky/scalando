package com.jcranky.scalando.cap12

import com.jcranky.scalando.cap11.{Foto, XMLParser}
import org.specs2.mutable.Specification

class XMLSpec extends Specification {
  "the xml parser" should {
    "turn the xml into the model class" in {
      val fotosXml =
        <rsp stat="ok">
          <photos>
            <photo id="123" owner="jcranky" server="6" title="jcranky test"></photo>
          </photos>
        </rsp>

      new XMLParser().parse(fotosXml.toString()) must_== Seq(
        Foto(123, "jcranky", 6, "jcranky test"))
    }
  }
}
