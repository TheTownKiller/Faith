package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import interaccion.Interaccion;
import jframe.BottomPanel;
import jframe.Display;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Main {

	public static void main(String[] args) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Users/Emman/Desktop/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		try {
			BufferedReader fb = new BufferedReader(new FileReader("C:/Users/Emman/git/Faith/Faith/Faith_saveData"));
			Interaccion.nombreUsuario = fb.readLine();
			Interaccion.designator = fb.readLine();
			Interaccion.stage = fb.readLine().charAt(0);
			fb.close();
			Interaccion.firstTime = false;
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
