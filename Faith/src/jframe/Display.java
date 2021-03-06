package jframe;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import interaction.Interaction;
import interaction.UrlAssignator;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import utilities.WebSearch;

public class Display extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6196105094874829542L;

	Image image = new ImageIcon(this.getClass().getResource("/resources/CursorIcon.png")).getImage();
	Image icon = new ImageIcon(this.getClass().getResource("/resources/FaithIcon.png")).getImage();
	Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(10, 10), "faith");
	UrlAssignator urlAssignator = new UrlAssignator();
	JPanel topPanel = new JPanel(new BorderLayout());
	JSplitPane mainSplit;
	Interaction interaction = new Interaction();
	Canvas canvas = new Canvas();
	MediaPlayerFactory mpf = new MediaPlayerFactory();
	EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(this));
	public static boolean hasPlayed = false;
	public static boolean isSearching = false;
	public static int height;
	public static int width;
	public static boolean endSearch = false;
	public static boolean afterRun = false;
	public static boolean firstSearch = true;
	public static String language = "english";

	public void createDisplayable(BottomPanel bottomPanel) {

		Dimension bottomPanelDimension = new Dimension(0, 65);
		Dimension dimension = new Dimension(1000, 100);

		bottomPanel.setBackground(Color.BLACK);
		bottomPanel.setMinimumSize(bottomPanelDimension);

		mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		mainSplit.setDividerSize(0);
		mainSplit.setResizeWeight(1);

		emp.setVideoSurface(mpf.newVideoSurface(canvas));

		topPanel.add(canvas);

		setMinimumSize(dimension);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pack();
		setLocationRelativeTo(null);
		add(mainSplit);
		setIconImage(icon);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setCursor(cursor);
		setTitle("Faith");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				interaction.dataSaver();
			}
		});

		restoreDefaults();

	}

	private void restoreDefaults() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mainSplit.setDividerLocation((mainSplit.getSize().height * 90) / 100);
			}
		});
	}

	public void runMedia() {

		while (true) {
			if (isSearching && firstSearch) {
				emp.playMedia(urlAssignator.getUrl());
				try {
					Thread.sleep(100);
					Thread.sleep(emp.getLength() - 150);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException");
				}
				emp.pause();
				switchVisible();
				Thread webSearcher = new Thread() {
					@Override
					public void run() {
						WebSearch.launch(WebSearch.class);
					}
				};
				webSearcher.start();
				hasPlayed = true;
				isSearching = false;
			}
			if (isSearching && (firstSearch == false)) {
				emp.playMedia(urlAssignator.getUrl());
				try {
					Thread.sleep(100);
					Thread.sleep(emp.getLength() - 150);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException");
				}
				emp.pause();
				switchVisible();
				synchronized (WebSearch.scene) {
					WebSearch.scene.notifyAll();
				}
				hasPlayed = true;
				isSearching = false;
			}
			if (endSearch) {
				Interaction.stage = 'e';
				afterRun = true;
				switchVisible();
				endSearch = false;
			} else {
				if (hasPlayed == false) {
					emp.playMedia(urlAssignator.getUrl());
					try {
						Thread.sleep(100);
						Thread.sleep(emp.getLength() - 150);
					} catch (InterruptedException e) {
						System.out.println("InterruptedException");
					}
					hasPlayed = true;
					emp.pause();
				}
				try {
					Thread.sleep(50);
					height = this.getHeight();
					width = this.getWidth();
					textResize();
					canvas.validate();
					canvas.repaint();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException");
				}
			}
		}
	}

	public void switchVisible() {
		if (isVisible()) {
			setVisible(false);
		} else {
			setVisible(true);
		}

	}

	public void textResize() {
		if (width < 1500) {
			BottomPanel.compactLetter = 30;
		} else {
			BottomPanel.compactLetter = 50;
		}
	}

}
