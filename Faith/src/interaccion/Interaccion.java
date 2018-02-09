package interaccion;

import java.util.ArrayList;

import frases.FaithFileReader;
import jframe.BottomPanel;

public class Interaccion {
	FaithFileReader reader = new FaithFileReader();
	String nombreUsuario;
	ArrayList<String> frases = reader.lecturaFaith();
	public String Dialogo = frases.get(0) + " " + frases.get(1);
	boolean activado = true;
	char stage = 'a';

	public void Dialogo() {
		if ((stage == 'a') && (BottomPanel.getMensajeUsuario().length() == 0)) {
			Dialogo = frases.get(6);
		} else if (stage == 'a'){
			asignarNombre(BottomPanel.getMensajeUsuario());
			Dialogo = frases.get(3) + " " + nombreUsuario.toUpperCase().charAt(0)
					+ nombreUsuario.substring(1, nombreUsuario.length()) + "?";
			stage = 'b';
			return;
		}else if (stage == 'b') {
			String decision = decision(BottomPanel.getMensajeUsuario());
			
			if (decision == "SI") {
				Dialogo = frases.get(2) + " " + nombreUsuario + "!";
				stage = 'c';
			}
			else if (decision == "NO") {
				Dialogo = frases.get(7);
				activado =true;
				stage = 'a';
			}else if (decision == "REPEAT") {
				Dialogo = frases.get(8);
				stage = 'b';
			}
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
		if(Dialogo.length() >= 25) {
			return "LONG";
		}else if(Dialogo.length() >= 20) {
			return "MEDIUM";
		}else
		return "SHORT";		
	}
}