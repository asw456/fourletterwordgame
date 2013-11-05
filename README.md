fourletterwordgame
==================

This was a friendly little sibling competition to see who could solve the four-letter-word matching game in the least number of guesses, averaged over 1000 Monte Carlo simulations.

The game: I choose a secret four letter word at random from the Scrabble dictionary. You try and guess my word. I tell you the number of letters in common (order is irrelevant). You choose a better word based on this information, and so on. Less attempts is better.

Competing solutions: Brother 1: Matlab. Brother 2: Java (usual weapon is C++/MPI but was looking into Java threading).  The Matlab solution guesses based on letter frequencies in the remaining solution space. The (obviously superior) Java solution guesses based on maximising the expected number of words eliminated in two future steps.

Results -

Java:   mean  9.904     std dev  2.889

Matlab: mean  10.06     std dev  3.122

The Java solution is embarassingly parallel so with MOAR CORES it's possible to look further head, right up to minimizing the expected path length directly. Currently it uses 8 threads and takes ~2 hours on a quad-core hyperthreaded sandy bridge i7.

If this was Kaggle incorporating the P(word) prior would be a good idea as well.
