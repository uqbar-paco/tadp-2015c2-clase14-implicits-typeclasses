package impls

import org.specs2.mutable.Specification

class ParametersTest extends Specification {

  "Implicits Conversions" should {

    val adan = Persona("Adan")
    val eva = Persona("Eva")

    "saluda con duda implicita" in {
      import Parameters.duda
      Parameters.saluda(adan) mustEqual "Hola Adan?"
    }

    "convertir un string a Persona" in {
      import Parameters.admiracion
      Parameters.saluda(adan) mustEqual "Hola Adan!"
    }

    "adan puede procrear con un string" in {
      val config = new Config {
        def fin = " :)"
      }
      Parameters.saluda(adan)(config) mustEqual "Hola Adan :)"

      def chainDeImplicits(persona: Persona)(implicit config: Config) =
        Parameters.saluda(persona)

      implicit val feliz = config
      chainDeImplicits(adan) mustEqual "Hola Adan :)"
    }

  }

}
