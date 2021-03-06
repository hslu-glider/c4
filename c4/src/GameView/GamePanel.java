/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author studhaal
 */
public class GamePanel extends JPanel implements Runnable {

    //<editor-fold defaultstate="collapsed" desc="GamePanel Variables">
    private final int[][][] array = new int[7][6][2];
    private int[] winnerchips = new int[8];
    private static final int absX = 59;
    private static final int absY = 30;
    private static final int width = 60;
    private static final int height = 60;
    private static boolean ismoving = false;
    private static boolean gameended = false;
    private static boolean player = true;
    private int row = 0;
    private int column = 0;
    private int posX = 59;
    private int posY = 30;
    private int newPosY = 30;
    private Thread th = null;
    //</editor-fold>

    public GamePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    //<editor-fold defaultstate="collapsed" desc="JPanel Methods">
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 500);
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                for (int p = 0; p < 2; p++) {
                    if (p == 0) {
                        g2D.setColor(Color.red);
                    } else {
                        g2D.setColor(Color.blue);
                    }
                    if (array[r][c][p] == 1) {
                        g2D.fillOval(absX + (r * 78), absY + (c * 69), width, height);
                        g2D.drawOval(absX + (r * 78), absY + (c * 69), width, height);
                    }
                }
            }

        }
        if (isMoving()) {
            if (player) {
                g2D.setColor(Color.red);
            } else {
                g2D.setColor(Color.blue);
            }
            g2D.fillOval(posX, posY, width, height);
            g2D.drawOval(posX, posY, width, height);
        }
        if (gameended) {
            g2D.setColor(Color.black);
            for (int i = 0; i < 8; i = i + 2) {
                g2D.setStroke(new BasicStroke(10F));
                g2D.drawOval(absX + (winnerchips[i] * 78), absY + (winnerchips[i + 1] * 69), width, height);
            }
            player=false;
           
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public boolean isMoving() {
        return ismoving;
    }

    public void moveDisc(int x, int y, boolean player) {
        this.player = player;
        row = x;
        column = y;
        posX = 59 + ((row) * 78);
        newPosY = 30 + ((column) * 69);

        //somethingChanged(true);
        //notifyAll();
        //th = null;
    }

    public void movedDisc() {
        if (player) {
            insertDisc(row, column, 0);
        } else {
            insertDisc(row, column, 1);
        }
        posX = absX;
        posY = absY;
        th.interrupt();
        while (th != null) {
            th = null;
        }
        ismoving = false;
    }

    public void moveToEndPosition() {
        if (posY < newPosY) {
            posY = posY + 4;
        } else {
            movedDisc();
        }
    }

    private void insertDisc(int x, int y, int player) {
        array[x][y][player] = 1;
    }

    public void startMoving() {
        ismoving = true;
        if (th == null) {
            th = new Thread(this);
        }
        th.start();
    }

    public boolean thRunning() {
        if (th != null) {
            return th.isAlive();
        } else {
            return false;
        }
    }

    public void drawWinner(int[] winnerchips) {
        this.winnerchips = winnerchips;
        gameended = true;
        this.repaint();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Thread Run">
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            //if (gamePanel.hasChanged()) {
            while (isMoving()) {
                moveToEndPosition();
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ie) {
                }
            }
            repaint();
            //}
        }
    }
    //</editor-fold>
}
