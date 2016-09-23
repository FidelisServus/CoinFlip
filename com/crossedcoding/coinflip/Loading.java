package com.crossedcoding.coinflip;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Loading
{
  private JFrame LoadingFrame;
  private JTextField Credits;
  private static int progres;
  
  public Loading()
  {
    loadGui(null);
  }
  
  public void loadGui(String register)
  {
    try
    {
      this.LoadingFrame = new JFrame();
      
      this.LoadingFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
      this.LoadingFrame.setForeground(Color.RED);
      this.LoadingFrame.setFont(new Font("Lucida Sans Unicode", 0, 18));
      this.LoadingFrame.setTitle("JAVA");
      this.LoadingFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Images/FSlogo.png")));
      this.LoadingFrame.setSize(400, 400);
      this.LoadingFrame.setLocationRelativeTo(null);
      
      this.Credits = new JTextField();
      this.Credits.setFont(new Font("Tahoma", 0, 15));
      this.Credits.setEditable(false);
      this.Credits.setText("Coin Flip Version 1.3 By FidelisServus");
      this.LoadingFrame.getContentPane().add(this.Credits, "North");
      this.Credits.setColumns(10);
      
      JProgressBar progressBar = new JProgressBar();
      progressBar.setSize(this.LoadingFrame.getWidth(), 590);
      progressBar.setMinimum(0);
      progressBar.setMaximum(100);
      progressBar.setStringPainted(true);
      this.LoadingFrame.getContentPane().add(progressBar);
      
      this.LoadingFrame.getContentPane().add(progressBar, "South");
      
      JLabel label = new JLabel("Loading . . .");
      label.setHorizontalAlignment(0);
      
      label.setLabelFor(this.LoadingFrame);
      label.setFont(new Font("Rockwell", 0, 25));
      this.LoadingFrame.getContentPane().add(label, "Center");
      this.LoadingFrame.setVisible(true);
      for (progres = progressBar.getMinimum(); progres <= progressBar.getMaximum(); progres += 1)
      {
        Thread.sleep(20L);
        progressBar.setValue(progres);
      }
      Thread.sleep(200L);
      
      this.LoadingFrame.setVisible(false);
    }
    catch (Exception localException) {}
  }
}
