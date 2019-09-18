package implicittest

object ImplicitParametersTest {
  case class Delimiters(left: String, right: String)
  def quote(what: String)(implicit delims: Delimiters) = delims.left + what + delims.right

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) =if(order(a)<b) a else b

  def testing()= {
    println(quote("Bonjour le monde")(Delimiters("«", "»")))
    implicit val quoteDelimiters = Delimiters("<<<", ">>>")
    println(quote("Bonjour le monde"))
  }
  def testing2() = {
    println(smaller(40, 2))
    println(smaller("Hello", "World"))
  }
}
