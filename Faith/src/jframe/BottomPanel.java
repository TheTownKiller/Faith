package jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interaccion.Interaccion;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305478594970318760L;

	JTextField textField;
	public static String mensajeUsuario;
	Interaccion interaccion = new Interaccion();
	Display display = new Display();

	public BottomPanel() {
		textField = new JTextField(20);
		textField.setFont(textField.getFont().deriveFont(20f));
		textField.setForeground(Color.BLACK);
		KeyAdapter keyListener = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {	
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ENTER) {
					BottomPanel.mensajeUsuario = textField.getText();
					interaccion.Dialogo();
					Display.hasPlayed = false;
					textField.setText("");
					textField.grabFocus();
			}
			
		}
	};
		textField.addKeyListener(keyListener);
		this.add(textField);
		
		JButton buttonHablar = new JButton(" Hablar! ");
		buttonHablar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent Ejecucion) {
				BottomPanel.mensajeUsuario = textField.getText();
				interaccion.Dialogo();
				Display.hasPlayed = false;
				textField.setText("");
				textField.grabFocus();
			}
		});
		this.add(buttonHablar);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setColor(Color.WHITE);
		g.setFont(font);
		if(Display.afterRun){
			interaccion.Dialogo();
			Display.afterRun = false;
			Display.hasPlayed = false;
		}if(interaccion.getDialogo().length() > 55) {
			String[]split = interaccion.getDialogo().split(" ");
			String DrawUp = "";
			String DrawDown = "";
			int contador = 0;
			for(int i = 0; i<split.length; i++) {
				contador += split[i].length();
				if(contador >= 45) {
					DrawDown += split[i] + " ";
				}else {
					DrawUp += split[i] + " ";
				}
			}
			g.drawString(DrawUp, 50, 30);
			g.drawString(DrawDown, 50, 50);
		}else {
		g.drawString(interaccion.getDialogo(), 50, 30);
		}
		repaint();

	}

	public static String getMensajeUsuario() {
		return (BottomPanel.mensajeUsuario.toLowerCase());
	}

}
