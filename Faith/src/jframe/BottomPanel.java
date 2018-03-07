package jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import interaction.Interaction;
import utilities.TextToSpeech;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305478594970318760L;

	private JTextField textField;
	private Interaction interaction = new Interaction();
	public static String userMessage;
	public static int compactLetter = 55;
	private ArrayList<String> memory = new ArrayList<String>();
	private int count = memory.size();

	public BottomPanel() {
		textField = new JTextField(20);
		textField.setFont(textField.getFont().deriveFont(20f));
		textField.setForeground(Color.BLACK);
		TextToSpeech tts = new TextToSpeech("cmu-slt-hsmm");
		KeyAdapter keyListener = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ENTER) {
					BottomPanel.userMessage = textField.getText();
					memory.add(textField.getText());
					interaction.dialogue();
					Display.hasPlayed = false;
					textField.setText("");
					textField.grabFocus();
					count = memory.size();
					tts.say(interaction.getDialogue());
				}
				if (key == KeyEvent.VK_UP) {
					if (memory.size() != 0) {
						if (count != 0) {
							count -= 1;
						}
						textField.setText(memory.get(count));
					}
				}
				if (key == KeyEvent.VK_DOWN) {
					if (memory.size() != 0) {
						if (count != memory.size() - 1) {
							count += 1;
						}
						textField.setText(memory.get(count));
					}
				}
			}
		};
		textField.addKeyListener(keyListener);
		this.add(textField);

		JButton speakButton = new JButton(" Hablar! ");
		speakButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actEv) {
				BottomPanel.userMessage = textField.getText();
				memory.add(textField.getText());
				interaction.dialogue();
				Display.hasPlayed = false;
				textField.setText("");
				textField.grabFocus();
				count = memory.size();
			}
		});
		this.add(speakButton);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setColor(Color.WHITE);
		g.setFont(font);
		if (Display.afterRun) {
			interaction.dialogue();
			Display.afterRun = false;
			Display.hasPlayed = false;
		}
		if (interaction.getDialogue().length() > compactLetter) {
			String[] split = interaction.getDialogue().split(" ");
			String DrawUp = "";
			String DrawDown = "";
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				count += split[i].length();
				if (count >= (compactLetter - 10)) {
					DrawDown += split[i] + " ";
				} else {
					DrawUp += split[i] + " ";
				}
			}
			g.drawString(DrawUp, 50, 30);
			g.drawString(DrawDown, 50, 55);
		} else {
			g.drawString(interaction.getDialogue(), 50, 30);
		}
		repaint();

	}

	public static String getUserMessage() {
		return (BottomPanel.userMessage.toLowerCase());
	}
}
