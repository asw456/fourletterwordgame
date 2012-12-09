fourletterwordgame
==================

This was a friendly little competition to see who could solve the four-letter-word matchinggame ni the least number of guesses, averaged over 1000 Monte Carlo simulations.

The game -
I choose a secret four letter word at random from the Scrabble dictionary. You try and guess my word. I tell you the number of letters in common (order is irrelevant). You choose a better word based on this information, and so on. Less attempts is better.

The competing solutions - 
Matlab and Java. The Matlab solution guesses based on letter frequencies in the remaining solution space. The Java solution guesses based on maximising the expected number of words eliminated.

Cool tech - 
The Java solution uses 8 threads in parallel to run the simulations. I plan on adding AWS EC2 support for any number of threads soon.

Results - 
Java:   mean  9.904     std dev  2.889
Matlab: mean  10.06     std dev  3.122

Improvements - 
use multi-letter combination frequencies, a multi-step elimination expectation or just minimise the expected path length directory (probably intractable computationally).



