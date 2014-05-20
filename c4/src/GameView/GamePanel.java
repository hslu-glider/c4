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
public class GamePanel extends JPanel {

    //<editor-fold defaultstate="collapsed" desc="GamePanel Variables">
    private final int[][][] array = new int[7][6][2];
    private static final int absX = 59;
    private static final int absY = 30;
    private static final int width = 60;
    private static final int height = 60;
    private static boolean changed = true;
    private static boolean ismoving = false;
    private int row = 0;
    private int column = 0;
    private int posX = 59;
    private int posY = 30;
    private int newPosY = 30;
    //private Thread th = null;
    //</editor-fold>

    public GamePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        hasChanged();
    }

    //<editor-fold defaultstate="collapsed" desc="JPanel Methods">
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 500);
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        while (!changed) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }
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

            if (isMoving()) {
                g.setColor(Color.red);
                g.fillOval(posX, posY, width, height);
                g.drawOval(posX, posY, width, height);
            }
            //changed = false;
            notifyAll();
        }
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Methods">
    public boolean isMoving() {
        return ismoving;
    }

    @SuppressWarnings("empty-statement")
    public void moveDisc(int x, int y) {
        /*while (isMoving()) {
         try {
         wait();
         } catch (InterruptedException ie) {
         }
         }*/
        row = x;
        column = y;
        posX = 59 + ((row) * 78);
        newPosY = 30 + ((column) * 69);
        hasChanged();
        //notifyAll();
        /*
         //th = null;
         if(th==null){
         th = new Thread(this);
         }
         th.start();
         ismoving=true;*/
    }

    public void movedDisc() {
        while (isMoving()) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }
        insertDisc(row, column, 0);
        posX = absX;
        posY = absY;
        ismoving = false;
        repaint();
        changed = false;
        //notifyAll();
    }

    public boolean endPositionReached() {
        posY = posY + 4;
        return posY >= newPosY;
    }

    private void insertDisc(int x, int y, int player) {
        array[x][y][player] = 1;
    }

    public void startMoving() {

        ismoving = true;
    }

    public synchronized final void hasChanged() {
        changed = true;
        notifyAll();
    }

    public boolean somethingChanged() {
        return changed;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Thread Run">
    /*@Override
     public void run() {
     while (!Thread.currentThread().isInterrupted()) {
     while (posY < newPosY) {
     posY = posY + 4;
     repaint();
     try {
     Thread.sleep(20);
     } catch (InterruptedException ex) {
     }
     }
     ismoving = false;
     movedDisc();
     }
     }*/
    //</editor-fold>
}
