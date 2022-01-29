package day1

import scala.io.Source

val inFile = "/home/issac/Learn/aoc2021/src/main/resources/day1/input.txt"
val inputLines = Source.fromFile(inFile).getLines.map(_.toInt).toList

@main def part1: Unit = 
  println(s"Number of measurements: ${inputLines.size}")
  val (numIncreases, _) = inputLines.foldLeft[(Int, Option[Int])]((0, None)) {
    case ((numInx, None), curr) =>
      (numInx, Some(curr))
    case ((numInx, Some(prev)), curr) => if (curr > prev) (numInx + 1, Some(curr)) else (numInx, Some(curr))
  }
  println(s"Number of increases: $numIncreases")

@main def part2: Unit =
  println(s"Number of measurements: ${inputLines.size}")
  val grped = inputLines.sliding(3).toList
  val (numIncreases, _) = grped.foldLeft[(Int, List[Int])]((0, Nil)) {
    case ((numInx, Nil), curr) => (numInx, curr)
    case ((numInx, prev), curr) =>
      val prevSum = prev.sum
      val currSum = curr.sum
      if (currSum > prevSum) (numInx + 1, curr) else (numInx, curr)
  }
  println(s"Number of increases: $numIncreases")
