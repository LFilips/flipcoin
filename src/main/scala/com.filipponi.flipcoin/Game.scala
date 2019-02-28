package com.filipponi.flipcoin

import scala.util.Random

object Game {

  @scala.annotation.tailrec
  def round(state: State) : Unit = {
    println(s"Which will be the result of the flipping? Choose head or tail")
    val input = scala.io.StdIn.readLine()
    println(s"you choose $input")
    val userCoin = if (input.toLowerCase.contains("head")) Head else Tail
    val result = if(userCoin == nextFlip()) Win else Lose
    result match {
      case Win => {
        println("You Won!")
      }
      case Lose => {
        println("You Lost!")
      }
    }
    round(updateStateWithResult(state,result))
  }

  def updateStateWithResult(state: State, outcome: Outcome): State = {
    val newState = outcome match {
      case Win => state.copy(games = state.games + 1, win = state.win + 1)
      case Lose => state.copy(games = state.games + 1, lost = state.lost + 1)
    }
    println(s"GameLog: $newState")
    newState
  }

  def nextFlip() : Coin = {
    Random.nextInt(2) match {
      case 0 => Head
      case 1 => Tail
    }
  }

}

