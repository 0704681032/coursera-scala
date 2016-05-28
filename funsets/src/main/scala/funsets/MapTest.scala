package funsets

import scala.io.Source

/**
  * Created by jinyangyang on 5/28/16 8:16 PM.
  */
object MapTest extends App{
  val mnemonics = Map(
    2 -> "ABC", 3 -> "DEF", 4 -> "GHI", 5 -> "JKL", 6 -> "MNO", 7 -> "PQRS", 8 -> "TUV", 9 -> "WXYZ")

  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
  //> in  : scala.io.BufferedSource = non-empty iterator

  val words = in.getLines.toList filter(w => w forall(chr => chr.isLetter))

  var c2number = for ( (number,code) <- mnemonics ;s <- code )  yield (s,number)
  println(c2number)

  def transfer(str:String):String = {
    (str.toUpperCase map c2number) mkString ""
  }
  //var num2List:Map[String,List[String]] = words groupBy transfer

  var num2List:Map[String,Seq[String]] = words groupBy transfer withDefaultValue  Seq()


  /** Return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] ={
    if (number.isEmpty) Set(List())
    else
      { for {
        split <- 1 to number.length
        // find out what first word must be
        word <- num2List(number take split)
        // take first split characters for the number
        // apply wordsForNum (get all words that have this number)
        // let word range over that
        rest <- encode(number drop split)
      } yield word :: rest
      } toSet
  }                                               //> encode: (number: String)Set[List[String]]
  // first word followed by the rest

  encode("7225247386")                            //> res3: Set[List[String]] = Set()

  // present as complete phrases
  def translate(number: String): Set[String] =
    encode(number). map(_ mkString " ")           //> translate: (number: String)Set[String]

  translate("7225247386")
}
