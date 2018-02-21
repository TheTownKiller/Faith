package main;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import jframe.BottomPanel;
import jframe.Display;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Main  {

	public static void main(String[] args) {
	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Users/Emman/Desktop/VideoLAN/VLC");
	Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
	BottomPanel bottomPanel = new BottomPanel();
	Display faith = new Display();
	faith.createDisplayable(bottomPanel);
	faith.runMedia();
	
	}
}
