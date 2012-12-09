package fourletterwordgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyScript {


	public static void main(String[] args) {
		
		try {
		
		List<String> dictionary = (ReadFile
				.readWithCsvListReader("I:\\dictionary\\python\\4letterdictionary.csv"));
		
		List<Integer> pathLengths = new ArrayList<Integer>();
		
		List<Integer> syncPathLengths = Collections.synchronizedList(pathLengths);
		
		ThreadCalc threadCalc1 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc2 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc3 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc4 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc5 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc6 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc7 = new ThreadCalc(dictionary, syncPathLengths);
		ThreadCalc threadCalc8 = new ThreadCalc(dictionary, syncPathLengths);
		threadCalc1.start();
		threadCalc2.start();
		threadCalc3.start();
		threadCalc4.start();
		threadCalc5.start();
		threadCalc6.start();
		threadCalc7.start();
		threadCalc8.start();
		threadCalc1.join();
		threadCalc2.join();
		threadCalc3.join();
		threadCalc4.join();
		threadCalc5.join();
		threadCalc6.join();
		threadCalc7.join();
		threadCalc8.join();
			
		System.out.println("main: " + pathLengths);
			
		double sum = 0;
		for (Integer i : pathLengths){
			sum = sum + i;
		}
		
		double average = sum/1000;
		System.out.println("average is " + average);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
