package funsets

object Main extends App {

  import FunSets._

  //println(contains(singletonSet(1), 1))

  test()

  test1()

  testZip()


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
}
