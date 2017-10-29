package lab1_lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class LifeGame extends JFrame implements ActionListener{

	private static JMenuItem start = new JMenuItem("Start Timer");//游戏开始
	private static JMenuItem stop = new JMenuItem("Stop Timer");//游戏结束
	private static JMenuItem random = new JMenuItem("Random Map");//选择随机地图模式
	private static JMenuItem init = new JMenuItem("Init Map");//选择初始设置地图模式
	private static GameMap gamemap = new GameMap();
	Timer timer;
	private static LifeGame lifegame;
	LifeGame(){ 
		
        this.setSize(606,660);  
        this.setTitle("Lab1_GOF_宋钰瑾&彭玉全");  
        this.add(gamemap);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
        //增加了控制面板 控制计时器
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu control = new JMenu("Control");
        menu.add(control);
        control.add(start);
        control.add(stop);
        JMenu options = new JMenu("Options");
        menu.add(options);
        options.add(random);
        options.add(init);
        this.setVisible(true);  
        
        //添加监听
        start.addActionListener(this);
        stop.addActionListener(this);
        init.addActionListener(this);
        random.addActionListener(this);
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lifegame = new LifeGame();  
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start) {
			 timer = new Timer(600, new ActionListener() {  
	                @Override  
	                public void actionPerformed(ActionEvent e) {  
	                    gamemap.reset_cell_status();  
	                    repaint();  
	                }  
	            });  
	           // 开启计时器  
	           timer.start(); 
	           stop.setEnabled(true);
	           start.setEnabled(false);
		}
		if(e.getSource() == stop) {
	   		timer.stop();
    		start.setEnabled(true);
            stop.setEnabled(false);
			
		}
		if(e.getSource() == init) {
			gamemap.initMap();
			repaint();  
			init.setEnabled(false);
			random.setEnabled(true);
		}
		if(e.getSource() == random) {
			gamemap.randomMap();
			repaint();  
			random.setEnabled(false);
			init.setEnabled(true);
		}
	}
	
	

}
