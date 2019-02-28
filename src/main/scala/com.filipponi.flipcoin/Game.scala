package com.filipponi.flipcoin

import scala.util.Random

object Game {

  def loop() = {

    val state = State(0,0,0)
    println(s"Which will be the result of the flipping? Choose head or tail")
    val input = scala.io.StdIn.readLine()
    println(s"you choose $input")
    val userCoin = if (input.toLowerCase.contains("head")) Head else Tail
    val result = if(userCoin == nextFlip()) Win else Lose

  }

  def nextFlip() : Coin = {
    Random.nextInt(2) match {
      case 0 => Head
      case 1 => Tail
    }
  }

}

