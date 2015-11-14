package typeclasses

import impls.Persona
import org.specs2.mutable.Specification

class ContextBoundsTest extends Specification {

  "Implicits Conversions" should {

    val adan = Persona("Adan")

    "puedo saludar con context" in {
      ContextBounds.saludo(adan) mustEqual "Hola Adan"
    }

  }

}
