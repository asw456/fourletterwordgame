package fourletterwordgame;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

public class ReadFile {

	public static List<String> readWithCsvListReader(String csvFilename) {

		try{
		
		ICsvListReader listReader = null;

		listReader = new CsvListReader(new FileReader(csvFilename),
				CsvPreference.STANDARD_PREFERENCE);

		List<String> wordList;
		List<String> wordListString = new ArrayList<String>();
		while ((wordList = listReader.read()) != null) {
			wordListString.add(wordList.get(0));
		}

		listReader.close();
		return wordListString;
		
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}