package fourletterwordgame;

import java.util.ArrayList;
import java.util.List;

public class MyUtilities {
	
	public String calculateBestWord(List<String> dictionary){
		
		String bestWord = null;
		double number = 0;
		double newNumber = 0;
		for (String dictionaryWord : dictionary){
			bestWord = dictionaryWord;
			newNumber = this.expectedWordsEliminated(dictionaryWord,dictionary);
			if (newNumber > number){
				number = newNumber;
				bestWord = dictionaryWord;
			}
		}
		return bestWord;
	}
	
	
	public int howManyLettersMatch(String word1, String word2) {
		int c = 0;
		StringBuilder temp;
		for (int i = 0; i <= 3; ++i) {
			for (int j = 0; j <= 3; ++j) {
				if ((int)word1.charAt(i) == (int)word2.charAt(j)) {
					temp = new StringBuilder(word1);
					word1 = temp.replace(i, i+1, "1").toString();
					temp = new StringBuilder(word2);
					word2 = temp.replace(j, j+1, "2").toString();
					++c;
				}
			}
		}
		return c;
	}
	
	public double probabilityOfGettingANumber(String word, int number, List<String> dictionary){
		double sum = 0;
		for (String dictionaryWord : dictionary){
			if (howManyLettersMatch(word, dictionaryWord) == number){
				++sum;
			}	
		}
		return sum/dictionary.size();
	}
	
	public List<String> newDictionary(String word, int number, List<String> dictionary){
		List<String> newDictionary = new ArrayList<String>();
		for (String dictionaryWord : dictionary){
			if (howManyLettersMatch(word, dictionaryWord) == number){
				newDictionary.add(dictionaryWord);
			}
		}
		return newDictionary;
	}
	
	public double expectedWordsEliminated(String word, List<String> dictionary){
		double expectedNumber = 0;
		for (int i = 0; i < 5; ++i){
			expectedNumber = expectedNumber + probabilityOfGettingANumber(word, i, dictionary)*(dictionary.size() - newDictionary(word, i, dictionary).size());
		}
		return expectedNumber;
	}
}
