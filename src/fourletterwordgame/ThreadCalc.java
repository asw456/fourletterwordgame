package fourletterwordgame;

import java.util.List;
import java.util.Random;

public class ThreadCalc extends Thread {

	private List<Integer> pathLengths;
	private List<String> dictionary;

	public ThreadCalc(List<String> dictionary, List<Integer> pathLengths) {
		this.pathLengths = pathLengths;
		this.dictionary = dictionary;
	}

	public void run() {

		MyUtilities myUtilities = new MyUtilities();
		List<String> newDictionary;

		for (int i = 0; i < 125; ++i) {

			String theWord = dictionary.get(new Random().nextInt(dictionary
					.size() - 0 + 1) + 0);
			
			String bestWord = myUtilities.calculateBestWord(dictionary);
			newDictionary = myUtilities.newDictionary(bestWord,
					myUtilities.howManyLettersMatch(theWord, bestWord),
					dictionary);

			//int counter = 1;
			//String bestWord = myUtilities.calculateBestWord(newDictionary);
			//newDictionary = myUtilities.newDictionary(bestWord,
			//		myUtilities.howManyLettersMatch(theWord, bestWord),
		    //	newDictionary);

			int counter = 0;
			while (myUtilities.howManyLettersMatch(theWord, bestWord) != 4
					&& newDictionary.size() != 1) {

				counter = counter + 1;
				bestWord = myUtilities.calculateBestWord(newDictionary);
				newDictionary = myUtilities.newDictionary(bestWord,
						myUtilities.howManyLettersMatch(theWord, bestWord),
						newDictionary);
			}

			int wordsLeft = newDictionary.size() - 1;
			int attempts = counter + wordsLeft;
			pathLengths.add(attempts);
		}
	}
}
