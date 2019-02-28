package com.filipponi.flipcoin

case class State(games: Int, win: Int, lost: Int)

sealed trait Coin

case object Head extends Coin
case object Tail extends Coin

sealed trait Outcome

case object Win
case object Lose
