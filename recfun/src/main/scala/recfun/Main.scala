package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
        if ( c == 0 ||  c == r ) 1
        else pascal(c-1,r-1) + pascal(c,r-1)
    }
  //https://gist.github.com/ngocdaothanh/3764694
  /**
   * Exercise 2  判断括号是否匹配 第一思路就是用栈 (入栈 (pop 为什么要用递归了?
   */
    def balance(chars: List[Char]): Boolean = {

      def balanced(chars: List[Char], open: Int): Boolean =
        if (chars.isEmpty) open == 0
        else if (chars.head == '(') balanced(chars.tail,open+1)
        else if (chars.head == ')') open>0 && balanced(chars.tail,open-1)
        else balanced(chars.tail,open)
      balanced(chars,0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def countInner(coins: List[Int]): Int = {
        var t = 0
        var sum = 0
        //我擦到底怎么消除上面的 t sum 本地变量
        //错误的都要记录下来 对于后来回忆思路的求解过程很重要
        //最关键的是下面的一步
        if ( money%coins.head==0 ) sum = 1
        while ( t*coins.head < money ){
          sum += countChange(money-t*coins.head,coins.tail)
          t=t+1
        }
        sum
      }

      if ( coins.isEmpty ) 0
      else if ( coins.length == 1 ) {
        //if (money == coins.head)  1
        if ( money%coins.head==0) 1
        else 0
      } else countInner(coins)
        //var head = coins.head
        //var tail = coins.tail
//        var t = 0
//        var sum = 0
//        //错误的都要记录下来 对于后来回忆思路的求解过程很重要
//        //最关键的是下面的一步
//        if ( money%coins.head==0 ) sum = 1
//        while ( t*coins.head < money ){
//            sum += countChange(money-t*coins.head,coins.tail)
//            t=t+1
//        }
 //       sum


    }
  }
