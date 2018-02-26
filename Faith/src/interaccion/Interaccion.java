package interaccion;

import java.util.ArrayList;

import frases.FaithFileReader;
import jframe.BottomPanel;
import jframe.Display;

public class Interaccion {
	FaithFileReader reader = new FaithFileReader();
	String nombreUsuario;
	PossibleTexts text = new PossibleTexts();
	ArrayList<String> frases = reader.lecturaFaith();
	String designator = "maestro";
	public String Dialogo = frases.get(0) + frases.get(1) + designator + "?";
	boolean activado = true;
	public static String webUrl;
	public static char stage = 'a';

	public void Dialogo() {
		if ((stage == 'a') && (BottomPanel.getMensajeUsuario().length() == 0)) {
			Dialogo = frases.get(6);
		} else if (stage == 'a') {
			asignarNombre(BottomPanel.getMensajeUsuario());
			Dialogo = frases.get(3) + " " + nombreUsuario.toUpperCase().charAt(0)
					+ nombreUsuario.substring(1, nombreUsuario.length()) + "?";
			stage = 'b';
			return;
		} else if (stage == 'b') {
			String decision = decision(BottomPanel.getMensajeUsuario());

			if (decision == "SI") {
				Dialogo = frases.get(2) + " " + nombreUsuario + frases.get(9);
				stage = 'c';
			} else if (decision == "NO") {
				Dialogo = frases.get(7);
				activado = true;
				stage = 'a';
			} else if (decision == "REPEAT") {
				Dialogo = frases.get(8);
				stage = 'b';
			}
		} else if (stage == 'c') {

			String textoLibre = text.getTextoLibre(BottomPanel.getMensajeUsuario());
			int randomizer = (int) (Math.random() * 10);

			switch (textoLibre) {

			case "nombre":
				if (randomizer > 5) {
					Dialogo = frases.get(5);
					break;
				} else {
					Dialogo = frases.get(12);
					break;
				}
			case "nombre2":
				Dialogo = frases.get(11) + designator + "!";
				break;
			case "nombreUsuario":
				if (randomizer > 5) {
					Dialogo = frases.get(10) + nombreUsuario + ".";
					break;
				} else {
					Dialogo = frases.get(13) + nombreUsuario + ".";
					break;
				}
			case "quePuedoDecirte":
				Dialogo = frases.get(14) + designator + "!";
				break;
			case "soyMujer":
				if (designator == "maestra") {
					Dialogo = frases.get(15) + designator + ".";
					break;
				} else if (designator == "maestro") {
					designator = "maestra";
					Dialogo = frases.get(16) + designator + ".";
					break;
				} else {
					Dialogo = frases.get(17) + designator + "!";
					break;
				}
			case "designatorChange":
				if (randomizer > 5) {
					Dialogo = "¿" + nombreUsuario + frases.get(18);
					stage = 'd';
					break;
				} else {
					Dialogo = "¿" + nombreUsuario + frases.get(21);
					stage = 'd';
					break;
				}

			case "presentation":
				Dialogo = frases.get(4);
				break;
			case "busqueda":
				
				Dialogo = frases.get(22) + designator + ".";
				Display.isSearching = true;
				break;
			}
		} else if (stage == 'd') {
			String decision = decision(BottomPanel.getMensajeUsuario());

			if (decision == "SI") {
				designator = nombreUsuario;
				Dialogo = frases.get(19) + designator + ".";
				stage = 'c';
			} else if (decision == "NO") {
				Dialogo = frases.get(20) + designator + ".";
				stage = 'c';
			} else if (decision == "REPEAT") {
				Dialogo = frases.get(8);
				stage = 'd';
			}
		}
		else if (stage == 'e') {
			int randomizer = (int) (Math.random() * 10);
			
			if(randomizer > 5) {
				Dialogo = frases.get(23);
			}else {
				Dialogo = frases.get(24);
			}
			stage = 'c';
		}
	}

	public String getDialogo() {
		return Dialogo;
	}

	public String decision(String texto) {
		if (texto.contains("si") || texto.contains("claro" + "si") || texto.contains("afirmativo")) {
			return "SI";
		} else if (texto.contains("no") || texto.contains("negativo")) {
			return "NO";
		} else {
			return "REPEAT";
		}
	}

	public void asignarNombre(String texto) {
		if (activado) {
			nombreUsuario = texto.toUpperCase().charAt(0) + texto.substring(1, texto.length());
			activado = false;
		}
	}

	public String getType() {
		if (Dialogo.length() >= 25) {
			return "LONG";
		} else if (Dialogo.length() >= 20) {
			return "MEDIUM";
		} else
			return "SHORT";
	}
}