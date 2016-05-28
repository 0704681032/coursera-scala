package funsets

/**
  * Created by jinyangyang on 5/28/16 7:58 PM.
  */
object Insert extends  App {

  def inser(x: Int, ints: List[Int]): List[Int] = ints match {
    case Nil => List(x)
    case (y::xs) => {
      if ( x < y ) x::ints
      else y::inser(x,xs)
    }
  }

  def insertSort(l:List[Int]): List[Int] = l match {
    case Nil => Nil
    case List(x) => List(x)
    case (x::xs) => inser(x,insertSort(xs))
  }

  println( insertSort(List(3,1,67,34,78,12)) )

}
