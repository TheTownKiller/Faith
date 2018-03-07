package interaction;

import java.util.ArrayList;

import jframe.Display;
import phrases.FaithFileReader;

public class PossibleTexts {

	private FaithFileReader reader = new FaithFileReader();
	private ArrayList<String> input = reader.faithReading(languageResources("input", Display.language));

	public String getSwitchText(String text) {
		text.replace("'", "");

		if ((text.contains("cual") && text.contains("tu") && text.contains("nombre"))
				|| (text.contains("como") && text.contains("te") && text.contains("llamas"))) {
			return "name";
		}
		if ((text.contains("como") && text.contains("puedo") && text.contains("llamarte"))) {
			return "name2";
		}
		if ((text.contains("no") && text.contains("me") && text.contains("llamo"))
				|| (text.contains("cambiar") && (text.contains("de") || text.contains("el")) && text.contains("nombre"))
				|| (text.contains("cambiame") && (text.contains("de") || text.contains("el"))
						&& text.contains("nombre"))) {
			return "nameChange";
		}
		if ((text.contains("como") && text.contains("me") && text.contains("llamo"))
				|| (text.contains("cual") && text.contains("mi") && text.contains("nombre"))) {
			return "userName";
		}
		if ((text.contains("que") && text.contains("puedo") && (text.contains("preguntarte"))
				|| (text.contains("decirte")))) {
			return "whatCanITellYou";
		}
		if ((text.contains("soy") && text.contains("una") && text.contains("mujer"))
				|| (text.contains("soy") && text.contains("mujer"))) {
			return "ImWoman";
		}
		if ((text.contains("que") && text.contains("eres") || text.contains("quien")) && (text.contains("eres"))) {
			return "presentation";
		}
		if ((text.contains("que es"))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith("¿") || splitString[i].equals("que")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith("¿")) {
						splitString[i] = splitString[i].substring(1);
					}
					splitString[i].replace("//?", "");
					if (splitString[i].equals("que") || splitString[i].equals("es") || splitString[i].equals("un")
							|| splitString[i].equals("una") || splitString[i].equals("la")
							|| splitString[i].equals("el")) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}

			Interaction.webUrl = "https://es.wikipedia.org/wiki/" + searched;
			return "whatIs";
		}
		if ((text.contains("busca")) && (text.contains("en internet") || text.contains("por internet"))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith("busca")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith("busca")) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}
			searched = searched.replaceFirst("en internet", "").replaceFirst("por internet", "");
			Interaction.webUrl = "https://www.google.es/search?source=hp&ei=h3GNWu2HOYOGU6fgm6gI&q=" + searched + "&oq="
					+ searched;
			return "search";
		}
		if ((text.contains("busca"))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith("busca")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith("busca")) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}
			Interaction.webUrl = "https://www.google.es/search?source=hp&ei=h3GNWu2HOYOGU6fgm6gI&q=" + searched + "&oq="
					+ searched;
			return "search";
		}
		if ((text.contains("no") && text.contains("me") && text.contains("llames")
				&& (text.contains("maestro") || text.contains("maestra")))
				|| (text.contains("llamame") && text.contains("por") && text.contains("mi")
						&& text.contains("nombre"))) {
			return "designatorChange";
		}
		if ((text.contains("gracias") || (text.contains("estoy") && text.contains("agradecido")))) {
			return "thanks";
		}
		if ((text.contains("besame") || (text.contains("casate") && text.contains("conmigo"))
				|| (text.contains("dame") && text.contains("un beso")))) {
			return "loveAttempt";
		}
		if ((text.contains("te quiero") || (text.contains("te amo")))) {
			return "loveAttempt2";
		}
		if ((text.contains("di") && text.contains("mi") && text.contains("nombre"))) {
			return "sayMyName";
		}
		if ((text.contains("como llegar a"))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith("llegar")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith("llegar") || splitString[i].equals("a")) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}
			Interaction.webUrl = "https://www.google.es/maps/dir/mi ubicación/" + searched;
			return "howToGetTo";
		}
		return null;
	}

	public String languageResources(String type, String language) {
		if ((type == "faith") && (language == "english")) {
			return "src/resources/language/english/Faith_En.txt";
		} else if ((type == "input") && (language == "english")) {
			return "src/resources/language/english/input_En.txt";
		} else if ((type == "punctuation") && (language == "english")) {
			return "src/resources/language/english/punctuation&Designator.txt";
		} else if ((type == "faith") && (language == "español")) {
			return "src/resources/language/español/Faith_Es.txt";
		} else if ((type == "input") && (language == "español")) {
			return "src/resources/language/español/input_Es.txt";
		} else {
			return "src/resources/language/español/puntuacion&Designador.txt";
		}
	}

}
