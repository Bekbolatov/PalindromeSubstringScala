PalindromeSubstringScala
========================

Two algorithms are provided:

1. One is using a slower approach - basically a brute-force try of every substring:
O(n^2) in string comparison operations, which are typically O(n), making a total of O(n^3).

2. Another approach is to re-use as much information as possible: Manacher's algorightm.
Here we are traversing the candidate palindrome centers once, using symmetry and knowledge
about previously expanded palindromes (code should be self-explanatory) - 
achieves linear time on average. 
Worst-case situation is when the string is made out of same character: aaaaaaaaa...
Here algorithm would have to expand to maximum at each center, making it O(n^2).

Check out the benefit:

    scala PalindromeSubstring 98jnibfgfgfgfg453bdgdfgdgdfudfgdfgdfgdfgdfgy7565f5frerexrex16559234329545498jhhgdfgfgfg089fgfhgfdsasdfghf1234567890232323232dfdfdfererertyuiuytreasdfghjklkjhgfdsaqwertyuioplkjhgfdfghjklpoiuytrewq
Result=qwertyuioplkjhgfdfghjklpoiuytrewq (512 ms, input length 195, method: check each substring)
Result=qwertyuioplkjhgfdfghjklpoiuytrewq (5 ms, input length 195, method: Manacher's algorithm)


In future, I might make the second algorithm implementation more Scala idiomatic, more FP


