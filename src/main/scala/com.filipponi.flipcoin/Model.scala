package com.filipponi.flipcoin

case class State(games: Int, win: Int, lost: Int)

object State {
  def initialState(): State = {
    State(0,0,0)
  }
}

sealed trait Coin

case object Head extends Coin
case object Tail extends Coin

sealed trait Outcome

case object Win extends Outcome
case object Lose extends Outcome
