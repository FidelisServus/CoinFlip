package com.crossedcoding.coinflip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer
{
	public void AudioPlayer(String sound)
	{
	    try
	    {
		    AudioInputStream audioInputStream = 
			    AudioSystem.getAudioInputStream(
			    getClass().getResource(sound));
			    Clip clip = AudioSystem.getClip();
			    clip.open(audioInputStream);
			    clip.start();
	    }
	    catch (Exception localException) {}
	}
  
	public SoundPlayer(String sound)
	{
		AudioPlayer(sound);
	}
}
