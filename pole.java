

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class pole extends JPanel{

	private Image shapka;
	private Image fon;
	public int x = 400;
	private static int slogn;
	
	private podar[] gamePodar;
	private Image end_game;
	public Timer timerUpdate;
	public Timer timerDraw;
	
	public pole (int slogn) {
		
		this.slogn = slogn;
		
		try {
			shapka = ImageIO.read(new File ("C:\\Users\\IArchakov\\workspace\\shapka.png"));
		} catch (IOException ex) {}
		
		try {
			fon = ImageIO.read(new File ("C:\\Users\\IArchakov\\workspace\\fon.png"));
		} catch (IOException ex) {}
		
		try {
			end_game = ImageIO.read(new File ("C:\\Users\\IArchakov\\workspace\\end_game.png"));
		} catch (IOException ex) {}
		
		gamePodar = new podar[slogn];
		for (int i = 0; i < gamePodar.length; i++) {
			try {
				gamePodar[i] = new podar (ImageIO.read(new File ("C:\\Users\\IArchakov\\workspace\\podar.png")));
			} catch (IOException ex) {}
			
		}
		
		timerUpdate = new Timer (3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateStart();
			}
		});
		timerUpdate.start();
		
		timerDraw = new Timer (50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		timerDraw.start();
	}
	
	public void paintComponent (Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, null);
		gr.drawImage(shapka, x, 465, null);
		
		for (int i = 0; i < gamePodar.length; i++) {
			gamePodar[i].draw(gr);
			if ((gamePodar[i].y + gamePodar[i].img.getHeight(null)) >= 470)
			if (Math.abs(gamePodar[i].x - x) > 75) {
				gr.drawImage(end_game, 300, 300, null);
				timerDraw.stop();
				timerUpdate.stop();
				break;
			}else gamePodar[i].act = false;
		}
	}	
	
	private void updateStart() {
		
		for (int i = 0; i < gamePodar.length; i++) {
			if (!gamePodar[i].act) {
				gamePodar[i].start();
				break;
			} 
			
		}
	
	}
}