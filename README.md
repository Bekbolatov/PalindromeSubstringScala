PalindromeSubstringScala
========================

Two algorithms are provided:

1. One is using a slower approach - basically a brute-force try of every substring:
O(n<sup>2</sup>) in string comparison operations, which are typically O(n), making a total of O(n<sup>3</sup>).

2. Another approach is to re-use as much information as possible: Manacher's algorightm.
Here we are traversing the candidate palindrome centers once, using symmetry and knowledge
about previously expanded palindromes (code should be self-explanatory) - 
achieves linear time on average. 
Worst-case situation is when the string is made out of same character: aaaaaaaaa...
Here algorithm would have to expand to maximum at each center, making it O(n<sup>2</sup>).

Check out the result on a string of about 200 characters:

```
scala -classpath build/libs/PalindromeSubstringScala.jar PalindromeSubstring 98jnibfgfgfgfg453bdgdfgdgdfudfgdfgdfgdfgdfgy7565f5frerexrex16559234329545498jhhgdfgfgfg089fgfhgfdsasdfghf1234567890232323232dfdfdfererertyuiuytreasdfghjklkjhgfdsaqwertyuioplkjhgfdfghjklpoiuytrewq
Result=qwertyuioplkjhgfdfghjklpoiuytrewq (314393 us, input length 195, method: check each substring)
Result=qwertyuioplkjhgfdfghjklpoiuytrewq (252 us, input length 195, method: Manacher's algorithm)

```

Notice 314ms vs 0.25ms running times - this is averaged over 20 runs.
Of course, a lot of other things might affect performance here, like data structures 
and functions/expressions chosen and gc activity.


