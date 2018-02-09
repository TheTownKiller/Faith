package main;

import jframe.BottomPanel;
import jframe.Display;

public class Main  {

	public static void main(String[] args) {
	BottomPanel bottomPanel = new BottomPanel();
	Display faith = new Display();
	faith.createDisplayable(bottomPanel);
	faith.runMedia();
	}
}
