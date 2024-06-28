package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static int WIDTH = 480, HEIGHT = 480;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void tick() {
		
	} //metodo responsável pela lógica
	
	public void render () {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs ==null) {
			this.createBufferStrategy(3);
			return;
		} //otimiza a parte gráfica
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.red); //cor do retângulo
		g.fillRect(10, 10, 100, 100);
		
		bs.show();
	} //método responsável pela renderização
	
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Mini Clone Zelda");
		frame.pack();
		
		frame.setLocationRelativeTo(null); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true); 
		
		new Thread(game).start();
	}
	
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		} 
		
	} 

}
