package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import interaction.Interaction;
import jframe.BottomPanel;
import jframe.Display;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Main {

	public static void main(String[] args) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		try {
			BufferedReader fb = new BufferedReader(new FileReader("C:/Users/Emman/git/Faith/Faith/Faith_saveData"));
			Interaction.userName = fb.readLine();
			Interaction.designator = fb.readLine();
			Interaction.stage = fb.readLine().charAt(0);
			fb.close();
			Interaction.firstTime = false;
			BottomPanel bottomPanel = new BottomPanel();
			Display faith = new Display();
			faith.createDisplayable(bottomPanel);
			faith.runMedia();
			
		} catch (FileNotFoundException e) {
			BottomPanel bottomPanel = new BottomPanel();
			Display faith = new Display();
			faith.createDisplayable(bottomPanel);
			faith.runMedia();
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
