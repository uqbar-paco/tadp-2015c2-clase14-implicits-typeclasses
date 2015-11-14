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
      List(eva, adan).sorted mustEqual List(adan, eva)
    }

  }

}
