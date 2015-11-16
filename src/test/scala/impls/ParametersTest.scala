package impls

import org.specs2.mutable.Specification

import scala.util.Try

class ParametersTest extends Specification {

  "Implicits Parameters" should {

    val adan = Persona("Adan")
    val eva = Persona("Eva")


    object Opt {
      implicit def detectorNull[A](a: A) = a == null
      def apply[A](a: A)(implicit detector: A => Boolean = ((a:A) =>a == null)): Option[A] =
        if (detector(a)) None else Some(a)
    }

    "saluda con duda implicita" in {
      import Opt.detectorNull
      Opt(33)

      import Parameters.duda
      Parameters.saluda(adan) mustEqual "Hola Adan?"
    }

    "saluda con sorpresa" in {
      import Parameters.admiracion
      Parameters.saluda(adan) mustEqual "Hola Adan!"
    }

    "saluda custom" in {
      val config = new Config {
        def fin = " :)"
      }
      Parameters.saluda(adan)(config) mustEqual "Hola Adan :)"

      def chainDeImplicits(persona: Persona)(implicit config: Config) = {
        Parameters.saluda(persona)
      }

      implicit val feliz = config
      chainDeImplicits(adan) mustEqual "Hola Adan :)"
    }



  }

}
