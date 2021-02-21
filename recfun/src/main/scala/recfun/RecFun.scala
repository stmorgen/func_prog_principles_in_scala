package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if(c == 0 || c == r) 1 else pascal(c,r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balance(chars: List[Char], open: Int) : Boolean = {

      if(open < 0)
        false
      else if(chars.isEmpty) {
        open == 0
      } else {
        if(chars.head == '(') balance(chars.tail, open+1)
        else if(chars.head == ')') balance(chars.tail, open-1)
        else balance(chars.tail, open)
      }
    }

    balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def countChange(remMoney: Int, remCoins: List[Int]): Int = {
      if(remCoins.isEmpty) {
        0
      } else if(remMoney == 0) {
        1
      } else if(remMoney < 0) {
        0
      }
      else
        countChange(remMoney - remCoins.head, remCoins) + countChange(remMoney, remCoins.tail)
    }
    countChange(money, coins)
  }
}
