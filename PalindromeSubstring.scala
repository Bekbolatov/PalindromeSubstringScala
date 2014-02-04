object MaximalSubstringPalindromeFinder {
  def slowAlgorithm(a: String) : String = {
    a.inits
    .flatMap(_.tails.toList.init)
    .filter(s=>s==(s.reverse))
    .map(s=>(s,s.length))
    .maxBy(_._2)
    ._1
  }
  def fastAlgorithm(a: String) : String = {
    //re-using information
    "Not implemented"
  }
}

object PalindromeSubstring {
  var startTime:Long = 0L
  def resetTimer() {
      startTime = System.currentTimeMillis
  }
  def curTime: Long = System.currentTimeMillis - startTime

  def main(args: Array[String]) {
    if (args.length == 0) {
      println("supply a string as a command-line argument")
    } else {
      val m = MaximalSubstringPalindromeFinder;
      resetTimer()
      val x = m.slowAlgorithm(args(0))
      printf("Answer \"%s\" is found in %d ms for a string of length %d checking each substring\n", x, args(0).length, curTime)
    }
  }  
}
