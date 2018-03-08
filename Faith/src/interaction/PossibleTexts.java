package interaction;

import java.util.ArrayList;

import jframe.Display;
import phrases.FaithFileReader;

public class PossibleTexts {

	private FaithFileReader reader = new FaithFileReader();
	private ArrayList<String> input = reader.faithReading(languageResources("input", Display.language));
	private ArrayList<String> links = reader.faithReading(languageResources("punctuation", Display.language));

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
				|| (text.contains(input.get(17)) && (text.contains(input.get(18)) || text.contains(input.get(19))) && text.contains(input.get(20)))) {
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
				if (splitString[i].startsWith(links.get(0)) || splitString[i].equals(input.get(5))) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith(input.get(0))) {
						splitString[i] = splitString[i].substring(1);
					}
					splitString[i].replace(input.get(1), "");
					if (splitString[i].equals(input.get(5)) || splitString[i].equals(input.get(25)) || splitString[i].equals(input.get(26))
							|| splitString[i].equals(input.get(31)) || splitString[i].equals(input.get(32))
							|| splitString[i].equals(input.get(38))) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}

			Interaction.webUrl = links.get(7) + searched;
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
			Interaction.webUrl = links.get(8) + searched + links.get(9) + searched;
			return "search";
		}
		if ((text.contains(input.get(33)))) {
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
			Interaction.webUrl = links.get(8) + searched + links.get(9) + searched;
			return "search";
		}
		if ((text.contains(input.get(36)) && text.contains(input.get(37)) && text.contains(input.get(16))
				&& (text.contains(links.get(5)) || text.contains(links.get(6))))
				|| (text.contains(input.get(37)) && text.contains(input.get(38)) && text.contains(input.get(39))
						&& text.contains(input.get(20)))) {
			return "designatorChange";
		}
		if ((text.contains(input.get(40)) || (text.contains(input.get(41)) && text.contains(input.get(42))))) {
			return "thanks";
		}
		if ((text.contains(input.get(43)) || (text.contains(input.get(44)) && text.contains(input.get(16)))
				|| (text.contains(input.get(45)) && text.contains(input.get(46))))) {
			return "loveAttempt";
		}
		if ((text.contains(input.get(47)) || (text.contains(input.get(48))))) {
			return "loveAttempt2";
		}
		if ((text.contains(input.get(49)) && text.contains(input.get(13)) && text.contains(input.get(7)))) {
			return "sayMyName";
		}
		if ((text.contains(input.get(50)) || (text.contains(input.get(14))))) {
			String[] splitString = text.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].startsWith(input.get(51))) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (splitString[i].startsWith(input.get(51)) || splitString[i].equals(input.get(52))) {
						splitString[i] = "";
					}
					if (splitString[i] != "") {
						searched += splitString[i] + " ";
					}
				}
			}
			Interaction.webUrl = links.get(10) + searched;
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
			return "src/resources/language/english/pun&resourc_En.txt";
		} else if ((type == "faith") && (language == "español")) {
			return "src/resources/language/español/Faith_Es.txt";
		} else if ((type == "input") && (language == "español")) {
			return "src/resources/language/español/input_Es.txt";
		} else {
			return "src/resources/language/español/pun&resourc_Es.txt";
		}
	}

}
