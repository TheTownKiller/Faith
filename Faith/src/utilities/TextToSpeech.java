package utilities;

import marytts.util.data.audio.AudioPlayer;
import marytts.*;
import marytts.exceptions.*;
import javax.sound.sampled.AudioInputStream;

public class TextToSpeech {
	private MaryInterface marytts;
	

	public TextToSpeech(String voiceName) {
		try {
			marytts = new LocalMaryInterface();
			marytts.setVoice(voiceName);
		} catch (MaryConfigurationException e) {
			System.out.println("MaryTTS Config. Exception");
		}
	}

	public synchronized void say(String text) {
		try {
			AudioPlayer ap = new AudioPlayer();
			AudioInputStream audio = marytts.generateAudio(text);
			ap.setAudio(audio);
			ap.start();
			try {
				ap.join();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception");
			}
		} catch (SynthesisException ex) {
			System.out.println("Synthesis Exception");
		}
	}
}
