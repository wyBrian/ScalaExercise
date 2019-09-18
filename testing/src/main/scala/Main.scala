object Main extends App  {
  import implicittest.typeClassTest._
  def mean[T](numbers: Seq[T])(implicit number: NumberLike[T]): T = {
    number.divide(numbers.reduce(number.plus), numbers.size)
  }
  println(mean(List[Int](1, 2, 3, 6, 8)))
}
