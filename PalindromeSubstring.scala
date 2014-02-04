object MaximalSubstringPalindromeFinder {

  def slowAlgorithm(a: String) : String = {
    a.inits.flatMap(_.tails.toList.init).filter(s=>s==(s.reverse))
    .map(s=>(s,s.length)).maxBy(_._2)._1
  }

  def fastAlgorithm(a: String) : String = {
    //implementing Manacher's algorithm, which re-uses a lot of information
    val pn = 2*a.length - 1
    if (pn < 2) return a
    val p = Array.ofDim[Int](pn) //[p(0),a(0)] [p(1),] [p(2),a(1)] [p(3)] [p(4),a(2)] 
    p(0) = 0
    p(1) = if(a(0) == a(1)) 1 else 0
    var maxIndex = 1
    var maxValue = p(1)
    var center = 1
    var edge = 2
    var check = 2
    var anticheck = -1
    for (check <- 2 to pn - 1) {
      anticheck = 2*center - check
      while(anticheck < 0) {
        center += 1
        anticheck = 2*center - check
      }
      edge = center + p(center)
      if(edge - check > p(anticheck)) {
        p(check) = p(anticheck)
      } else {
        center = check
        var rem = edge - check
        if (rem < 0) rem = 0
        var sym = true
        while(sym) {
          if(center + rem + 1 < pn && center - rem - 1 >= 0) {
            if((center + rem + 1) % 2 == 0) {
              if(a((center + rem + 1)/2) == a((center - rem - 1)/2)) {
                rem += 1
              } else {
                sym = false
              }
            } else {
              rem += 1
            }
          } else {
            sym = false
          }
        }
        p(check) = rem
        if (maxValue < rem) {
          maxValue = rem 
          maxIndex = check
        }
      }
    }
    maxValue -= maxValue%2
    a.substring((maxIndex - maxValue)/2, (maxIndex + maxValue)/2+1)
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
      println("For example, try following command:")
      println("scala PalindromeSubstring 98jnibfgfgfgfg453bdgdfgdgdfudf" +
        "gdfgdfgdfgdfgy7565f5frerexrex16559234329545498jhhgdfgfgfg089fg" +
        "fhgfdsasdfghf1234567890232323232dfdfdfererertyuiuytreasdfghjkl" +
        "kjhgfdsaqwertyuioplkjhgfdfghjklpoiuytrewq");
    } else {
      val m = MaximalSubstringPalindromeFinder;
      var x: String = ""
      val output = "Result=%s (%d ms, input length %d, method: %s)\n"

      resetTimer()
      x = m.slowAlgorithm(args(0))
      printf(output, x, curTime, args(0).length, "check each substring")

      resetTimer()
      x = m.fastAlgorithm(args(0))
      printf(output, x, curTime, args(0).length, "Manacher's algorithm")
    }
  }  
}
