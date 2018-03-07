package interaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import jframe.BottomPanel;
import jframe.Display;
import phrases.FaithFileReader;

public class Interaction {
	private static FaithFileReader reader = new FaithFileReader();
	private static PossibleTexts text = new PossibleTexts();
	private ArrayList<String> phrases = reader.faithReading(text.languageResources("faith", Display.language));
	private static ArrayList<String> punctuationMarks = reader.faithReading(text.languageResources("punctuation", Display.language));
	private ArrayList<String> input = reader.faithReading(text.languageResources("input", Display.language));
	private boolean activated = false;
	private boolean hasHelped = false;
	private boolean alreadyTold = false;
	public static String webUrl;
	public static char stage = 'a';
	public String dialogue = firstTimeTalk();
	public static String designator = punctuationMarks.get(5);
	public static String userName = "";
	public static boolean firstTime = true;

	public void dialogue() {
		if ((stage == 'a') && (BottomPanel.getUserMessage().length() == 0)) {
			dialogue = phrases.get(6);
		} else if (stage == 'a') {
			activated = true;
			assignName(BottomPanel.getUserMessage());
			dialogue = phrases.get(3) + userName.toUpperCase().charAt(0)
					+ userName.substring(1, userName.length()) + punctuationMarks.get(1);
			stage = 'b';
			activated = false;
		} else if (stage == 'b') {
			String choice = choice(BottomPanel.getUserMessage());

			if (choice == "YES") {
				dialogue = phrases.get(2) + userName + phrases.get(9);
				stage = 'c';
			} else if (choice == "NO") {
				dialogue = phrases.get(7);
				stage = 'a';
			} else if (choice == "REPEAT") {
				dialogue = phrases.get(8);
				stage = 'b';
			}
		} else if (stage == 'c') {

			String switchType = text.getSwitchText(BottomPanel.getUserMessage());
			int randomizer = (int) (Math.random() * 10);

			switch (switchType) {

			case "name":
				hasHelped = true;
				if (randomizer > 5) {
					dialogue = phrases.get(5);
					break;
				} else {
					dialogue = phrases.get(12);
					break;
				}
			case "name2":
				hasHelped = true;
				dialogue = phrases.get(11) + designator + punctuationMarks.get(3);
				break;
			case "userName":
				hasHelped = true;
				if (randomizer > 5) {
					dialogue = phrases.get(10) + userName + punctuationMarks.get(4);
					break;
				} else {
					dialogue = phrases.get(13) + userName + punctuationMarks.get(4);
					break;
				}
			case "whatCanITellYou":
				hasHelped = true;
				dialogue = phrases.get(14) + designator + punctuationMarks.get(3);
				break;
			case "ImWoman":
				hasHelped = true;
				if (designator == punctuationMarks.get(6)) {
					dialogue = phrases.get(15) + designator + punctuationMarks.get(4);
					break;
				} else if (designator == punctuationMarks.get(5)) {
					designator = punctuationMarks.get(6);
					alreadyTold = true;
					dialogue = phrases.get(16) + designator + punctuationMarks.get(4);
					break;
				} else {
					if (alreadyTold) {
						dialogue = phrases.get(29) + designator + punctuationMarks.get(3);
						break;
					} else {
						dialogue = phrases.get(17) + designator + punctuationMarks.get(3);
						alreadyTold = true;
						break;
					}
				}
			case "designatorChange":
				hasHelped = true;
				if (randomizer > 5) {
					dialogue = punctuationMarks.get(0) + userName + phrases.get(18);
					stage = 'd';
					break;
				} else {
					dialogue = punctuationMarks.get(0) + userName + phrases.get(21);
					stage = 'd';
					break;
				}
			case "presentation":
				hasHelped = true;
				dialogue = phrases.get(4);
				break;
			case "search":
				hasHelped = true;
				dialogue = phrases.get(22) + designator + punctuationMarks.get(4);
				Display.isSearching = true;
				break;
			case "thanks":
				if (randomizer > 5) {
					if (hasHelped) {
						dialogue = phrases.get(25) + designator + punctuationMarks.get(3);
						hasHelped = false;
					} else {
						dialogue = phrases.get(27) + designator + punctuationMarks.get(3);
					}
					break;
				} else {
					if (hasHelped) {
						dialogue = phrases.get(26) + designator + punctuationMarks.get(3);
						hasHelped = false;
					} else {
						dialogue = phrases.get(28);
					}
					break;
				}
			case "loveAttempt":
				if (randomizer > 5) {
					dialogue = phrases.get(30);
				} else {
					dialogue = phrases.get(31) + designator + punctuationMarks.get(4);
				}
				break;
			case "loveAttempt2":
				if (randomizer > 5) {
					dialogue = phrases.get(32);
				} else {
					dialogue = phrases.get(33) + designator + punctuationMarks.get(4);
				}
				break;
			case "nameChange":
				hasHelped = true;
				if (randomizer > 5) {
					dialogue = phrases.get(34);
				} else {
					dialogue = phrases.get(35);
				}
				stage = 'a';
				break;
			case "sayMyName":
				hasHelped = true;
				dialogue = phrases.get(36) + userName + punctuationMarks.get(4);
				break;
			case "whatIs":
				hasHelped = true;
				dialogue = phrases.get(37);
				Display.isSearching = true;
				break;
			case "howToGetTo":
				hasHelped = true;
				dialogue = phrases.get(40) + designator + punctuationMarks.get(4);
				Display.isSearching = true;
				break;

			}
		} else if (stage == 'd') {

			String choice = choice(BottomPanel.getUserMessage());

			if (choice == "YES") {
				designator = userName;
				dialogue = phrases.get(19) + designator + punctuationMarks.get(4);
				stage = 'c';
			} else if (choice == "NO") {
				dialogue = phrases.get(20) + designator + punctuationMarks.get(4);
				stage = 'c';
			} else if (choice == "REPEAT") {
				dialogue = phrases.get(8);
				stage = 'd';
			}
		} else if (stage == 'e') {
			int randomizer = (int) (Math.random() * 10);

			if (randomizer > 5) {
				dialogue = phrases.get(23);
			} else {
				dialogue = phrases.get(24);
			}
			stage = 'c';
		}
	}

	public String getDialogue() {
		return dialogue;
	}

	public String choice(String text) {
		if (text.contains(input.get(0)) || text.contains(input.get(1)) || text.contains(input.get(2))) {
			return "YES";
		} else if (text.contains(input.get(3)) || text.contains(input.get(4))) {
			return "NO";
		} else {
			return "REPEAT";
		}
	}

	public void assignName(String text) {
		if (activated) {
			userName = text.toUpperCase().charAt(0) + text.substring(1, text.length());
			activated = false;
		}
	}

	public String getType() {
		if (dialogue.length() >= 25) {
			return "LONG";
		} else if (dialogue.length() >= 20) {
			return "MEDIUM";
		} else
			return "SHORT";
	}

	public void dataSaver() {
		BufferedWriter writer = null;
		if(userName == "") {
			return;
		}
		try {
			File saveData = new File("Faith_saveData");
			writer = new BufferedWriter(new FileWriter(saveData));
			writer.write(userName);
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
				System.out.println("Writer on close Exception");
			}

		}
	}

	public String firstTimeTalk() {
		String result;
		int randomizer = (int) (Math.random() * 10);
		if (firstTime) {
			result = phrases.get(0) + phrases.get(1) + designator + punctuationMarks.get(1);
		} else {
			if (randomizer > 5) {
				result = phrases.get(38) + designator + punctuationMarks.get(4);
			}else {
				result = phrases.get(39) + userName + punctuationMarks.get(4);
			}
		}
		return result;
	}
}