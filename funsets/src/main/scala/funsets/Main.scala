package funsets

object Main extends App {

  import FunSets._

  //println(contains(singletonSet(1), 1))

//  test()
//
//  test1()
//
//  testZip()




  //until to 这两种方式的差别
  def test(): Unit = {
    var r = (1 to 4) flatMap (i => {
      (1 to i) map (j => (j, i))
    })
    println(r)
  }

  def test1(): Unit = {
    var r = ( 1 to 4).map( i => {
      ( 1 to i) map(j=>(j,i))
    }).flatten
    println(r)
  }

  def testZip(): Unit = {
    var no = List(1,2,3)
    var names = List("jyy","zll","jzy")
    var tuples = no.zip(names)
    println(tuples)
    var res = tuples map(p=>p._1+"-"+p._2)
    println(res)
  }



  def mergeSort(arr:List[Int] ):List[Int] = {
    if ( arr.isEmpty ) throw new Exception()
    else if ( arr.length == 1 ) arr //avoid using return
    else { //刚开始这里没有加 esle 导致上面的arr失败
      var (left,right) = arr splitAt arr.length / 2 //数组分为两部分
      def merge(left:List[Int],right:List[Int]):List[Int]  =  (left,right) match {
        case(Nil,_)=>right
        case(_,Nil)=>left
        case(x::xs,y::ys)=>{
          if ( x < y ) x::merge(xs,right)
          else y::merge(left,ys)
        }
      }
      merge(mergeSort(left),mergeSort(right))
    }
  }

  def mergeSort1[T](arr:List[T] )(lt:(T,T)=>Boolean):List[T] = { //改进上面的版本不支持泛型
    if ( arr.isEmpty ) throw new Exception()
    else if ( arr.length == 1 ) arr //avoid using return
    else { //刚开始这里没有加 esle 导致上面的arr失败
    var (left,right) = arr splitAt arr.length / 2 //数组分为两部分
    def merge(left:List[T],right:List[T]):List[T]  =  (left,right) match {
        case(Nil,_)=>right
        case(_,Nil)=>left
        case(x::xs,y::ys)=>{
          if( lt(x, y)) x::merge(xs,right)
          else y::merge(left,ys)
        }
      }
      merge(mergeSort1(left)(lt),mergeSort1(right)(lt))
    }
  }

  //刚开始没有加Ordering[T] 导致编译不通过
  def mergeSort2[T](arr:List[T] )(order:Ordering[T]):List[T] = { //使用类库内置的类
    if ( arr.isEmpty ) throw new Exception()
    else if ( arr.length == 1 ) arr //avoid using return
    else { //刚开始这里没有加 esle 导致上面的arr失败
    var (left,right) = arr splitAt arr.length / 2 //数组分为两部分
    def merge(left:List[T],right:List[T]):List[T]  =  (left,right) match {
        case(Nil,_)=>right
        case(_,Nil)=>left
        case(x::xs,y::ys)=>{
          if( order.lt(x,y) ) x::merge(xs,right)
          else y::merge(left,ys)
        }
      }
      merge(mergeSort2(left)(order),mergeSort2(right)(order))
    }
  }


  def mergeSort3[T](arr:List[T] )(implicit order:Ordering[T]):List[T] = { //使用类库内置的类 并且使用implicit语法糖
    if ( arr.isEmpty ) throw new Exception()
    else if ( arr.length == 1 ) arr //avoid using return
    else { //刚开始这里没有加 esle 导致上面的arr失败
    var (left,right) = arr splitAt arr.length / 2 //数组分为两部分
    def merge(left:List[T],right:List[T]):List[T]  =  (left,right) match {
        case(Nil,_)=>right
        case(_,Nil)=>left
        case(x::xs,y::ys)=>{
          if( order.lt(x,y) ) x::merge(xs,right)
          else y::merge(left,ys)
        }
      }
      merge(mergeSort3(left),mergeSort3(right))
    }
  }


  println(mergeSort(List(3,1,67,34,78,12)))

  println( mergeSort1(List(3,1,67,34,78,12)) ( (x,y) => x<y ) )

  println( mergeSort2(List(3,1,67,34,78,12))(Ordering.Int) )

  println( mergeSort3(List(3,1,67,34,78,12))(Ordering.Int) )



}
