package typeclasses

object MySqlClient {
  def save(
            tabla: String,
            columnas: List[String],
            valores: List[String]) =
    s"$tabla (${columnas.mkString(",")}) values (${valores.mkString(",")})"
}

object RedisClient {
  def save(key: String, value: String) = s"$key=>$value"
}

trait Personaje {
  def nombre: String
}

case class DragonBall(nombre: String, raza: String) extends Personaje

case class Simpsons(nombre: String, pelado: Boolean) extends Personaje

case class Cocomiel(nombre: String) extends Personaje


object Persistencia {


}
