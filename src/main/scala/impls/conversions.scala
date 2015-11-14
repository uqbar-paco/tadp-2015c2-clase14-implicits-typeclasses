package impls

case class Persona(nombre: String, padre: Option[Persona] = None, madre: Option[Persona] = None) {
  def procrearCon(persona: Persona) = Persona(nombre + " jr.", Some(this), Some(persona))
}

object Persona {
  implicit def strToPersona(str: String) = Persona(str)

  implicit class PersonaOps(persona: Persona) {
    def saludaImplicito(end: String) = Conversions.saluda(persona) + end
  }
}

object Conversions {

  def saluda(persona: Persona) = s"Hola ${persona.nombre}"

  implicit def personaQueSaluda(persona: Persona) = new {
    def saluda = Conversions.saluda(persona)
  }

  implicit val personaQueSaludaPosta = (persona: Persona) => new {
    def saludaPosta(end: String) = s"HOLA ${persona.nombre}$end"
  }

  implicit class saludaIndiferente(persona: Persona) {
    def saluda = "meh"
  }

}
