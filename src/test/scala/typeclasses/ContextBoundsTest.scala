package typeclasses

import impls.Persona
import org.specs2.mutable.Specification
import typeclasses.ContextBounds.Saludador

class ContextBoundsTest extends Specification {

  "Context Bounds" should {

    val adan = Persona("Adan")

    implicit object PersonaSaludador extends Saludador[Persona]{
      override def saluda(t: Persona): String = "Hola " + t.nombre
    }

    "puedo saludar con context" in {
      import ContextBounds._
      saludo(adan)(PersonaSaludador) mustEqual "Hola Adan"
    }

  }

}
