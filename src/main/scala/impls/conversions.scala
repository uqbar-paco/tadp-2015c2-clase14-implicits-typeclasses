package impls

case class Persona(
                    nombre: String,
                   padre: Option[Persona] = None,
                    madre: Option[Persona] = None) {
  def procrearCon(persona: Persona) =
    Persona(nombre + " jr.", Some(this), Some(persona))
}

object Persona {
  implicit def strToPersona(str: String) = Persona(str)
}

case class PersonaDecorator(p: Persona) {
  def saluda = Conversions.saluda(p)
}

object Conversions {

  def saluda(persona: Persona) = s"Hola ${persona.nombre}"

  implicit def personaToPersonaDecorator(persona: Persona) =
    PersonaDecorator(persona)

  implicit lazy val ppp = (per: Persona) => PersonaDecorator(per)

  implicit class personaToPersonaQueSaluda(persona: Persona) {
    def saluda = s"Hola ${persona.nombre}"
    def size = 32
    def cambiarNombre(str: String) = persona.copy(nombre = str)
  }



}
