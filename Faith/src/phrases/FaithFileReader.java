package phrases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FaithFileReader {

	public ArrayList<String> faithReading(String url) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			BufferedReader fb = new BufferedReader(new FileReader(url));
			String line;
			while ((line = fb.readLine()) != null) {
				result.add(line);
			}
			fb.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return result;

	}

}
