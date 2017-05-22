fourletterwordgame
==================

Mastermind: challengers guess which N letter word the master is thinking of by querying N letter words and receiving an integer number of letter matches in response.

This was a friendly little sibling competition to see who could solve the N-letter-word matching game for N = 4 in the least number of guesses.

The game: The master chooses a secret N letter word at random from the Scrabble dictionary. The challengers try and guess the Master's word. After a query word is put to the Master by the challenger, the Master responds with the number of letters in common (order is irrelevant). The challenger updates his mental model and chooses a better word based on this information, and so on. Less attempts to guess the word in full is better.

Competing solutions: Brother 1: Matlab. Brother 2: Java.  The Matlab solution guesses based on letter frequencies in the remaining solution space. The (obviously superior) Java solution guesses based on maximising the expected number of words eliminated after two iterations.

Results -

Java:   mean  9.904     std dev  2.889
Matlab: mean  10.06     std dev  3.122

The Java solution is parallel and by increasing the number of threads or processing time the expected path length can be minimised directly. Currently it uses 8 threads and takes ~2 hours in 4 threads on Sandy Bridge i7.

Incorporating the Master's P(word) prior is an exercise left to the reader.
