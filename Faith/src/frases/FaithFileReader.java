package frases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FaithFileReader {

	public ArrayList<String> lecturaFaith() {
		ArrayList<String> resultado = new ArrayList<String>();
		try {
			BufferedReader fb = new BufferedReader(new FileReader("src/frases/Faith.txt"));
			String line;
			while ((line = fb.readLine()) != null) {
				resultado.add(line);
			}
			fb.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no Encontrado");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return resultado;

	}

}
