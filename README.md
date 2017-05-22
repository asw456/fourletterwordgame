fourletterwordgame
==================

**Master mind**: challengers guess which *n-*letter word the master is thinking of by querying *n-*letter words and receiving an integer number of letter matches in response.

This was a friendly sibling competition to see who could solve the *n-*letter-word matching game for *n = 4* in the least number of guesses.

The game: The master chooses a secret *n-*letter word at random from the Scrabble dictionary. *n* is known by all challengers. The challengers try and guess the Master's word. After a query word is put to the Master by the challenger, the Master responds with the number of letters in common. The challenger updates his mental model and chooses a better word based on this information, and so on. Less attempts to guess the word in full is better.

Competing solutions: Brother 1: Matlab. Brother 2: Java.  The Matlab solution guesses based on letter frequencies in the remaining solution space. The (obviously superior) Java solution guesses based on maximising the expected number of words eliminated after two iterations.

Results:

Java:   mean  9.904     std dev  2.889

Matlab: mean  10.06     std dev  3.122

The Java solution is parallel and by increasing the number of threads or processing time the expected path length can be minimised directly. Currently it steps through 2 iterations using 8 threads and takes ~2 hours in 4 threads on a Sandy Bridge i7.

Incorporating a guess at the prior for the Master's p(word) is an exercise left to the reader.
