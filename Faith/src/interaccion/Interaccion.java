package interaccion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import frases.FaithFileReader;
import jframe.BottomPanel;
import jframe.Display;

public class Interaccion {
	private FaithFileReader reader = new FaithFileReader();
	private PossibleTexts text = new PossibleTexts();
	private ArrayList<String> frases = reader.lecturaFaith();
	private boolean activado = false;
	private boolean hasHelped = false;
	private boolean alreadyTold = false;
	public static String webUrl;
	public static char stage = 'a';
	public String Dialogo = firstTimeTalk();
	public static String designator = "maestro";
	public static String nombreUsuario = "";
	public static boolean firstTime = true;

	public void Dialogo() {
		if ((stage == 'a') && (BottomPanel.getMensajeUsuario().length() == 0)) {
			Dialogo = frases.get(6);
		} else if (stage == 'a') {
			activado = true;
			asignarNombre(BottomPanel.getMensajeUsuario());
			Dialogo = frases.get(3) + " " + nombreUsuario.toUpperCase().charAt(0)
					+ nombreUsuario.substring(1, nombreUsuario.length()) + "?";
			stage = 'b';
			activado = false;
			return;
		} else if (stage == 'b') {
			String decision = decision(BottomPanel.getMensajeUsuario());

			if (decision == "SI") {
				Dialogo = frases.get(2) + " " + nombreUsuario + frases.get(9);
				stage = 'c';
			} else if (decision == "NO") {
				Dialogo = frases.get(7);
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
				hasHelped = true;
				if (randomizer > 5) {
					Dialogo = frases.get(5);
					break;
				} else {
					Dialogo = frases.get(12);
					break;
				}
			case "nombre2":
				hasHelped = true;
				Dialogo = frases.get(11) + designator + "!";
				break;
			case "nombreUsuario":
				hasHelped = true;
				if (randomizer > 5) {
					Dialogo = frases.get(10) + nombreUsuario + ".";
					break;
				} else {
					Dialogo = frases.get(13) + nombreUsuario + ".";
					break;
				}
			case "quePuedoDecirte":
				hasHelped = true;
				Dialogo = frases.get(14) + designator + "!";
				break;
			case "soyMujer":
				hasHelped = true;
				if (designator == "maestra") {
					Dialogo = frases.get(15) + designator + ".";
					break;
				} else if (designator == "maestro") {
					designator = "maestra";
					alreadyTold = true;
					Dialogo = frases.get(16) + designator + ".";
					break;
				} else {
					if (alreadyTold) {
						Dialogo = frases.get(29) + designator + "!";
						break;
					} else {
						Dialogo = frases.get(17) + designator + "!";
						alreadyTold = true;
						break;
					}
				}
			case "designatorChange":
				hasHelped = true;
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
				hasHelped = true;
				Dialogo = frases.get(4);
				break;
			case "busqueda":
				hasHelped = true;
				Dialogo = frases.get(22) + designator + ".";
				Display.isSearching = true;
				break;
			case "gracias":
				if (randomizer > 5) {
					if (hasHelped) {
						Dialogo = frases.get(25) + designator + "!";
						hasHelped = false;
					} else {
						Dialogo = frases.get(27) + designator + "!";
					}
					break;
				} else {
					if (hasHelped) {
						Dialogo = frases.get(26) + designator + "!";
						hasHelped = false;
					} else {
						Dialogo = frases.get(28);
					}
					break;
				}
			case "loveattempt":
				if (randomizer > 5) {
					Dialogo = frases.get(30);
				} else {
					Dialogo = frases.get(31) + designator + ".";
				}
				break;
			case "loveattempt2":
				if (randomizer > 5) {
					Dialogo = frases.get(32);
				} else {
					Dialogo = frases.get(33) + designator + ".";
				}
				break;
			case "nameChange":
				hasHelped = true;
				if (randomizer > 5) {
					Dialogo = frases.get(34);
				} else {
					Dialogo = frases.get(35);
				}
				stage = 'a';
				break;
			case "sayMyName":
				hasHelped = true;
				Dialogo = frases.get(36) + nombreUsuario + ".";
				break;
			case "queEs":
				hasHelped = true;
				Dialogo = frases.get(37);
				Display.isSearching = true;
				break;
			case "comoLlegar":
				hasHelped = true;
				Dialogo = frases.get(40) + designator + ".";
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
		} else if (stage == 'e') {
			int randomizer = (int) (Math.random() * 10);

			if (randomizer > 5) {
				Dialogo = frases.get(23);
			} else {
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

	public void dataSaver() {
		BufferedWriter writer = null;
		if(nombreUsuario == "") {
			return;
		}
		try {
			File saveData = new File("Faith_saveData");
			writer = new BufferedWriter(new FileWriter(saveData));
			writer.write(nombreUsuario);
			writer.newLine();
			writer.write(designator);
			writer.newLine();
			writer.write("c");
		} catch (Exception e) {
			System.out.println("Write Exception");
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Writer on close exception");
			}

		}
	}

	public String firstTimeTalk() {
		String resultado;
		int randomizer = (int) (Math.random() * 10);
		if (firstTime) {
			resultado = frases.get(0) + frases.get(1) + designator + "?";
		} else {
			if (randomizer > 5) {
				resultado = frases.get(38) + designator + ".";
			}else {
				resultado = frases.get(39) + nombreUsuario + ".";
			}
		}
		return resultado;
	}
}