package day2

import scala.io.Source

val inFile = "day2/input.txt"
val inputLines = Source.fromResource(inFile).getLines.toList

case class Coordinates(x: Int, y: Int)

@main def part1: Unit =
  val start = Coordinates(0, 0)
  println(s"Number of moves: ${inputLines.size}")
  val end = inputLines.foldLeft(start) { (pos, move) =>
    move.split(" ") match {
      case Array("forward", numSpaces) => pos.copy(x = pos.x + numSpaces.toInt)
      case Array("down", numSpaces) => pos.copy(y = pos.y + numSpaces.toInt)
      case Array("up", numSpaces) => pos.copy(y = pos.y - numSpaces.toInt)
    }
  }

  println(s"End: $end - area: ${end.x * end.y}")
