package day1_1

import scala.io.Source

@main def run: Unit = 
  val inFile = "/home/issac/Learn/aoc2021/src/main/resources/day1_1/input.txt"
  val inputLines = Source.fromFile(inFile).getLines.toList

  println(s"Number of measurements: ${inputLines.size}")
  val (numIncreases, _) = inputLines.map(_.toInt).foldLeft[(Int, Option[Int])]((0, None)) {
    case ((numInx, None), curr) =>
      (numInx, Some(curr))
    case ((numInx, Some(prev)), curr) => if (curr > prev) (numInx + 1, Some(curr)) else (numInx, Some(curr))
  }
  println(s"Number of increases: $numIncreases")
