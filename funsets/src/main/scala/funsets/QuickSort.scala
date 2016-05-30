package funsets

/**
  * Created by jinyangyang on 5/30/16 8:59 PM.
  */
object QuickSort extends App{

  var list = List(1,2,3)::4::List(4,5,6)

  println(list)
//  println((List(1,2,3):+4)+List(4,5,6))
//List(List(1, 2, 3), 4, 4, 5, 6)
//怪不得我下面的报错
//  def quickSort(list :List[Int] ):List[Int] = {
//    if ( list.isEmpty || list.length ==1 ) list
//    else quickSort(list.filter(x => x<= list.head))::(list.head)::quickSort(list.filter(x =>x>list.head))
//  }

//    def quickSort(list :List[Int] ):List[Int] = {
//      if ( list.isEmpty || list.length ==1 ) list
//      else quickSort(list.filter(x => x<= list.head)):+.(list.head):+.quickSort(list.filter(x =>x>list.head))
//    }

      def quickSort(list :List[Int] ):List[Int] = {
        println(list)
        if ( list.isEmpty || list.length ==1 ) list
        else quickSort(list.filter(x => x< list.head)):::list.head::quickSort(list.filter(x =>x>list.head))
      }

      println(quickSort(List(3,1,67,34,78,12)))


}
