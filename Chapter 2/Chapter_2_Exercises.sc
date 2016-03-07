object Fibonacci {

  /** Exercise 2.1 */
  def fib(n: Int): Int = {
    def go(n: Int): Int =
      if (n == 0) 0
      else if (n == 1) 1
      else go(n - 1) + go(n - 2)

    go(n)
  }

  def formatFib(n: Int) = {
    val msg = "The %d Fibonacci number is %d."
    msg.format(n, fib(n))
  }
}

import Fibonacci._
fib(3)
formatFib(3)

object PolymorphicFunctions {

  /** Exercise 2.2
    * Check whether an Array[A] is sorted according to the given comparison function
    */

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    def loop(n: Int): Boolean =
      if (as.isEmpty) false
      else if (ordered(as(n-1), as(n))) true
      else false

    loop(1)
  }

  /** Exercise 2.3:
    * Let's take a look at another example, currying, which converts a function
    * f of two arguments into a function of one argument that partially applies f.
    *
    * def curry[A,B,C](f: (A,B) => C): A => (B=>C)
    */

  def curry[A,B,C](f: (A,B) => C): A => B => C =
    (a: A) => (b: B) => f(a,b)

  /** Exercise 2.4
    * Implement uncurry, which reverses the transformation of curry.
    * Note that since => associates to the right, A => (B => C) can be
    * written as A => B => C.
    *
    * def uncurry[A,B,C](f: A => B => C): (A, B) => C
    */

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  /** Exercise 2.5
    * Implement the higher-order function that composes two functions
    *
    * def compose[A,B,C](f: B => C, g: A => B) : A => C
    */

  def compose[A,B,C](f: B => C, g: A => B) : A => C =
    (a: A) => f(g(a))
}

import PolymorphicFunctions._
isSorted(Array(0,1,2,3), (x: Int, y: Int) => x < y)