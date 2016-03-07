// Scala code has to be in an object or a class
object MyModule {
  // abs is a pure function takes an integer and returns an integer
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n,1)
  }

  def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }

  // This is a higher order function
  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  /** Example 2.3: monomorphic */
  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n+1)

    loop(0)
  }

  /** Example 2.4: polymorphic */
  def findFirst1[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      // if function p matches the current element, return its index in the array
      else if (p(as(n))) n
      else loop(n+1)

    loop(0)
  }

  /** partial1 example
    * Takes function of two arguments and partially applies it.
    * If we have A and a function that needs both A and B to produce C,
    * we can get a function that just needs B to produce C.
    */

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = {
    (b: B) => f(a,b)
  }

  // Unit is equivalent to "void" in Java
  // This is a "procedure" or impure function.
  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
  println(formatFactorial(7))
}

// import MyModule.abs imports just the "abs" member
// import MyModule._ imports all of an object's nonprivate
// members into scope
import MyModule._
abs(-42)
factorial(3)