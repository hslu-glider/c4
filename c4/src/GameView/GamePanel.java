/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author studhaal
 */
public class GamePanel extends JPanel implements Runnable{

    private int[][][] array = new int[7][6][2];
    private static final int absX = 59;
    private static final int absY = 30;
    private static final int width = 60;
    private static final int height = 60;
    private static boolean inserting = false;
    private int row = 0;
    private int column =0;
    private int posX = 59;
    private int posY = 30;
    private int newPosY = 30;
    private Thread th = null;

    public GamePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        //Testdaten
        /*
        array[0][0][0] = 1;
        array[1][0][0] = 1;
        array[2][0][0] = 1;
        array[3][0][0] = 1;
        array[4][0][0] = 1;
        array[5][0][0] = 1;
        array[6][0][0] = 1;
        array[0][1][1] = 1;
        array[0][2][1] = 1;
        array[0][3][1] = 1;
        */
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 500);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                for (int p = 0; p < 2; p++) {
                    if (p == 0) {
                        g.setColor(Color.red);
                    } else {
                        g.setColor(Color.blue);
                    }
                    if (array[r][c][p] == 1) {
                        g.fillOval(absX + (r * 78), absY + (c * 69), width, height);
                        g.drawOval(absX + (r * 78), absY + (c * 69), width, height);
                    }
                }
            }
        }
        if (inserting) {
            g.setColor(Color.red);
            g.fillOval(posX, posY, width, height);
            g.drawOval(posX, posY, width, height);
        }
    }

    public synchronized void moveDisc(int x, int y){
        row=x;
        column=y;
        posX = 59 + ((row) * 78);
        newPosY = 30+((column)*69);
        //th = null;
        if(th==null){
            th = new Thread(this);
        }
        th.start();
        inserting=true;
    }
    
    private synchronized void movedDisc(){
        th.interrupt();
        th=null;
        insertDisc(row,column,0);
        posX=absX;
        posY=absY;
        
    }
    
    private void insertDisc(int x, int y, int player){
        array[x][y][player]=1;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            while(posY < newPosY){
                posY=posY+2;
                repaint();
                try{
                    Thread.sleep(20);
                }catch(InterruptedException ex){
                }
            }
            inserting = false;
            movedDisc();
        }
    }
}
