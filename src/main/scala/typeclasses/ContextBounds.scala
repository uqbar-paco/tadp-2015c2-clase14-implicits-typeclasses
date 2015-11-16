package typeclasses

object ContextBounds {

  trait Saludador[T] {
    def saluda(t: T): String
  }

  def saludo[A](a: A)(implicit x: Saludador[A]) =
    x.saluda(a)

  def otra[A: Saludador](a: A) =
    saludo(a)

}