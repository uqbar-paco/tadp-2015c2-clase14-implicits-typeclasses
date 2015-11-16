package typeclasses

import impls.Persona
import org.specs2.mutable.Specification

class OrdenTest extends Specification {

  "Ordenar" should {

    val adan = Persona("Adan")
    val eva = Persona("Eva")

    "puedo ordenar una lista de ints" in {
      List(3, 1, 2).sorted mustEqual List(1, 2, 3)
    }

    "puedo ordenar una lista de Personas" in {
      implicit object PersonaOrder extends Ordering[Persona] {
        override def compare(x: Persona, y: Persona): Int =
          x.nombre.compareTo(y.nombre)
      }
      List(eva, adan).sorted mustEqual List(adan, eva)
    }

    "puedo usar el orden" in {
      def comparar[A:Ordering](x: A, y: A) =
        implicitly[Ordering[A]].lt(x,y)

      def compararConOperadores[A:Ordering]
      (x: A, y: A) = {
        val a = implicitly[Ordering[A]]
        import a.mkOrderingOps
        x.<(y)
      }
      compararConOperadores(1, 2) must beTrue
    }

  }

}
