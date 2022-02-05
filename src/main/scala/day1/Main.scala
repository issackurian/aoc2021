package day1

import scala.io.Source

val inFile = "day1/input.txt"
val inputLines = Source.fromResource(inFile).getLines.map(_.toInt).toList

def countIncreases[T](sumFunc: T => Int)(items: List[T]): Int = {
  val (numIncreases, _) = items.foldLeft[(Int, Option[T])](0, None) {
    case ((numInx, None), curr) => (numInx, Option(curr))
    case ((numInx, Some(prev)), curr) =>
      val prevSum = sumFunc(prev)
      val currSum = sumFunc(curr)
      if (currSum > prevSum) (numInx + 1, Option(curr)) else (numInx, Option(curr))
  }
  numIncreases
}

@main def part1: Unit = 
  println(s"Number of measurements: ${inputLines.size}")
  val numIncreases = countIncreases[Int](identity)(inputLines)
  println(s"Number of increases: $numIncreases")

@main def part2: Unit =
  println(s"Number of measurements: ${inputLines.size}")
  val grped = inputLines.sliding(3).toList
  val numIncreases = countIncreases[List[Int]](_.sum)(grped)
  println(s"Number of increases: $numIncreases")
