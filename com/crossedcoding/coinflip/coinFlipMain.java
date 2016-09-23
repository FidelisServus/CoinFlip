package com.crossedcoding.coinflip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class coinFlipMain extends Loading
{
	private static SoundPlayer audioPlayer;
	int soundScore = 1;
	private static JFrame frame;
	private static JFrame coinFrame;
	private static JPanel panel;
	private static JPanel coinPanel;
	private static JButton Yes;
	private static JButton No;
	private static JButton OK;
  
    public coinFlipMain()
    {
    	gui();
    }
  
    public void gui()
    {
	    audioPlayer = new SoundPlayer(null);
	    JTextPane textPane = new JTextPane();
	    final JTextPane coinTextPane = new JTextPane();
	    frame = new JFrame();
    
	    frame.setVisible(true);
	    frame.setSize(400, 400);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(3);
	    frame.setTitle("Coin Flipping");
    
	    textPane.setText("\n\n\n\n\nDo You Want Me To Flip A Coin?");
	    textPane.setFont(new Font("Lucida Sans Unicode", 1, 22));
	    textPane.setEditable(false);
	    frame.getContentPane().add(textPane, "Center");
	    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/images/FSlogo.png")));
    
	    coinFrame = new JFrame();
	    coinFrame.setVisible(false);
	    coinFrame.setSize(150, 100);
	    coinFrame.setLocationRelativeTo(null);
	    coinFrame.setTitle("Coin Flipping");
	    coinTextPane.setFont(new Font("Lucida Sans Unicode", 1, 12));
	    coinTextPane.setEditable(false);
	    coinFrame.getContentPane().add(coinTextPane, "Center");
	    coinFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/images/Coin.png")));
	    coinPanel = new JPanel();
	    coinPanel.setBackground(Color.CYAN);
	    OK = new JButton("OK");
	    coinPanel.add(OK);
	    coinFrame.add(coinPanel, "South");
    
	    final JToggleButton SoundToggle = new JToggleButton("Sound");
	    panel = new JPanel();
	    panel.setBackground(Color.CYAN);
    
	    Yes = new JButton("Yes");
	    Yes.setToolTipText("Click To Flip A Coin");
	    
	    No = new JButton("No");
	    No.setToolTipText("Click To Exit The Program");
    
	    panel.add(Yes);
	    panel.add(No);
	    panel.add(SoundToggle);
    
	    frame.add(panel, "South");
    
	    ActionListener listen = new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		if (coinFlipMain.this.soundScore == 1) {
	    			coinFlipMain.audioPlayer.AudioPlayer("assets/sounds/CoinDrop.wav");
	    		}
	    		boolean coinFlip = new Random().nextBoolean();
	    		coinFlipMain.coinFrame.setVisible(true);
	    		
	    		if (coinFlip) {
	    			coinTextPane.setText("Heads");
	    		} else if (!coinFlip) {
	    			coinTextPane.setText("Tails");
	    		}
	    	}
	    };
	    
	    Yes.addActionListener(listen);
	    Yes.setIcon(new ImageIcon(getClass().getResource("assets/images/yes.png")));
	    Yes.setFont(new Font("Times New Roman", 1, 15));
    
	    ActionListener listenExit = new ActionListener()
	    {
		      public void actionPerformed(ActionEvent event)
		      {
		    	  JOptionPane.showMessageDialog(null, "Closing", "Program Ended", 1);
		    	  System.exit(0);
		      }
	    };
	    
	    No.addActionListener(listenExit);
	    No.setIcon(new ImageIcon(getClass().getResource("assets/images/no.png")));
	    No.setFont(new Font("Times New Roman", 1, 15));
	    
	    ActionListener listenOK = new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		coinFlipMain.coinFrame.setVisible(false);
	    	}
	    };
	    
	    OK.addActionListener(listenOK);
	    OK.setFont(new Font("Times New Roman", 1, 15));
    
	    ActionListener listenSound = new ActionListener()
    	{
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		if (SoundToggle.isSelected()) {
	    			coinFlipMain.this.soundScore = 0;
	    		} else {
	    			coinFlipMain.this.soundScore = 1;
	    		}
	    	}
    	};
    	SoundToggle.addActionListener(listenSound);
    	SoundToggle.setSelectedIcon(new ImageIcon(getClass().getResource("assets/images/soundOFF.png")));
    	SoundToggle.setIcon(new ImageIcon(getClass().getResource("assets/images/soundON.png")));
  }
  
  public static void main(String[] args)
    throws InterruptedException
  {
    new coinFlipMain();
  }
}
