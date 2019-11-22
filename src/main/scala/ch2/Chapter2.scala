object Chapter2 {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def f(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else f(n - 1, n * acc)

    f(n, 1)
  }

  def fib(n: Int): Int = {
    @annotation.tailrec
    def f(index: Int, target: Int, oldAcc: Int, newAcc: Int): Int = {
      if (index == target) {
        oldAcc
      }
      else {
        f(index + 1, target, newAcc, oldAcc + newAcc)
      }
    }

    f(0, n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    val lastIndex = as.length - 1

    @annotation.tailrec
    def loop(n: Int): Boolean =
      if (n >= lastIndex) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)

    loop(0)
  }

  def partial1[A,B,C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)

  def curry[A,B,C](f: (A, B) => C): A => B => C =
    a => b => f(a, b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def formatResult(name: String, n: Int, f: Int => Int): String =
    "The %s of %d is %d".format(name, n, f(n))

  def main(args: Array[String]): Unit =
    println(formatResult("absolute value", -42, abs))
}
