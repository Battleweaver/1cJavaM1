
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class podar {
	public Image img;
	public int x;
	public int y;
	public Boolean act;
	Timer timerUpdate;
	
	public podar (Image img) {
		
		timerUpdate = new Timer (500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vniz();
			}
		});
		
		this.img = img;
		act = false;
	}
	
	public void start() {
		timerUpdate.start();
		y = 0;
		x = (int)(Math.random()*700);
		act = true;
	}
	
	public void vniz() {
		if (act) {
			y +=6;
			
		}
		if ((y + img.getHeight(null)) >= 470 ) {
			timerUpdate.stop();
		}
	}
	
	public void draw (Graphics gr) {
		if (act) {
			gr.drawImage(img, x, y, null);
		}
	}
}