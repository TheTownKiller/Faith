package jframe;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import interaccion.Animation;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Display extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6196105094874829542L;

	Image image = new ImageIcon(this.getClass().getResource("/resources/CursorIcon.png")).getImage();
	Image icon = new ImageIcon(this.getClass().getResource("/resources/FaithIcon.png")).getImage();
	Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(10,10), "faith");
	Animation animation = new Animation();
	JPanel topPanel = new JPanel(new BorderLayout());
	JSplitPane mainSplit;
	Canvas canvas = new Canvas();
	MediaPlayerFactory mpf;
	EmbeddedMediaPlayer emp;
	
	
	public void createDisplayable(BottomPanel bottomPanel) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
			
		bottomPanel.setBackground(Color.BLACK);
		mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		
		mainSplit.setDividerLocation(850);
		mainSplit.setDividerSize(0);
		mainSplit.setResizeWeight(1);

		topPanel.add(canvas);
		
		
		mpf = new MediaPlayerFactory();
		emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(this));
		emp.setVideoSurface(mpf.newVideoSurface(canvas));
		
		setSize(2000, 1000);
		setLocationRelativeTo(null);
		add(mainSplit);
		setIconImage(icon);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setCursor(cursor);
		setTitle("Faith");
	}
	
	public void runMedia() {
		emp.prepareMedia(animation.getAnimation());
		emp.play();
	}
}
