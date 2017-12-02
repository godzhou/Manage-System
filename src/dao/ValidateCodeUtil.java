package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCodeUtil {
	private String validate = "";
	private BufferedImage img;
	
	private static char[] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

	private ValidateCodeUtil(){
		createValidate();
	}
	
	public static ValidateCodeUtil Instance(){
		return new ValidateCodeUtil();
	}
	
	public String getString(){
		return this.validate;
	}
	
	public BufferedImage getImage(){
		return this.img;
	}
	
	private void createValidate(){
		Random random = new Random();
		int width = 80,height = 30;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		
		g.setColor(getRandomColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		g.setColor(getRandomColor(160,200));
		
		for(int i=0;i<155;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x1+x, y+y1);
		}
		
		for(int i = 0;i < 4; i++){
			String rand = String.valueOf(chars[random.nextInt(chars.length)]);
			validate +=rand;
			g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));
			g.drawString(rand, 17 * i + random.nextInt(7), 16 + random.nextInt(6));
			
		}
		g.dispose();
		this.img = image;
	}
	
	private Color getRandomColor(int min,int max){
		Random random = new Random();
		if(min > 255)
			min = 255;
		if(max > 255)
			max = 255;
		
		int r = min + random.nextInt(max - min);
		int g = min + random.nextInt(max - min);
		int b = min + random.nextInt(max - min);
		
		return new Color(r,b,g);
	}
}
