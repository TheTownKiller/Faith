package interaction;

import java.util.ArrayList;

import jframe.Display;
import phrases.FaithFileReader;

public class PossibleTexts {

	private FaithFileReader reader = new FaithFileReader();
	private ArrayList<String> input = reader.faithReading(languageResources("input", Display.language));

	public String getSwitchText(String text) {
		text = text.replace("'", "");
		
		if ((text.contains(input.get(5)) && text.contains(input.get(6)) && text.contains(input.get(7)))
				|| (text.contains(input.get(8)) && text.contains(input.get(9)) && text.contains(input.get(10)))) {
			return "name";
		}
		if ((text.contains(input.get(8)) && text.contains(input.get(11)) && text.contains(input.get(12)))) {
			return "name2";
		}
		if ((text.contains(input.get(36)) && text.contains(input.get(37)) && text.contains(input.get(16)))
				|| (text.contains(input.get(15)) && (text.contains(input.get(13)) || text.contains(input.get(32))) && text.contains(input.get(7)))
				|| (text.contains(input.get(17)) && (text.contains(input.get(18)) || text.contains(input.get(19)))
						&& text.contains(input.get(20)))) {
			return "nameChange";
		}
		if ((text.contains(input.get(5)) && text.contains(input.get(13)) && text.contains(input.get(7)))
				|| (text.contains(input.get(8)) && text.contains(input.get(21)) && text.contains(input.get(10)))) {
			return "userName";
		}
		if ((text.contains(input.get(5)) && text.contains(input.get(11)) && (text.contains(input.get(22)))
				|| (text.contains(input.get(23))))) {
			return "whatCanITellYou";
		}
		if ((text.contains(input.get(24)) && text.contains(input.get(26)) && text.contains(input.get(27)))
				|| (text.contains(input.get(24)) && text.contains(input.get(28)))) {
			return "ImWoman";
		}
		if (((text.contains(input.get(5)) && text.contains(input.get(9))) || (text.contains(input.get(29))) && (text.contains(input.get(9))))) {
			return "presentation";
		}
		if ((text.contains(input.get(30)))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith(input.get(54)) || splitString[i].equals(input.get(5))) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith(input.get(54))) {
						splitString[i] = splitString[i].substring(1);
					}
					splitString[i].replace(input.get(55), "");
					if (splitString[i].equals(input.get(5)) || splitString[i].equals(input.get(53)) || splitString[i].equals(input.get(26))
							|| splitString[i].equals(input.get(31)) || splitString[i].equals(input.get(32))
							|| splitString[i].equals(input.get(38))) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}

			Interaction.webUrl = input.get(56) + searched;
			return "whatIs";
		}
		if ((text.contains(input.get(33))) && (text.contains(input.get(35)) || text.contains(input.get(34)))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith(input.get(33))) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith(input.get(33))) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}
			searched = searched.replaceFirst(input.get(35), "").replaceFirst(input.get(34), "");
			Interaction.webUrl = input.get(57) + searched + input.get(58)
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
