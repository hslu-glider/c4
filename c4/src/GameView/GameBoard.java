/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author studhaal
 */
public class GameBoard {

    private static JLabel lbl_Player1;
    private static JLabel lbl_Player2;
    private static JLabel lbl_Versus;
    private static JLabel lbl_Turn;
    private static JButton btn_Row1;
    private static JButton btn_Row2;
    private static JButton btn_Row3;
    private static JButton btn_Row4;
    private static JButton btn_Row5;
    private static JButton btn_Row6;
    private static JButton btn_Row7;
    private static JButton btn_Close;
    private static GamePanel gamePanel;

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("C4");
        lbl_Player1 = new javax.swing.JLabel();
        lbl_Player2 = new javax.swing.JLabel();
        lbl_Versus = new javax.swing.JLabel();
        lbl_Turn = new javax.swing.JLabel();
        btn_Row1 = new javax.swing.JButton();
        btn_Row2 = new javax.swing.JButton();
        btn_Row3 = new javax.swing.JButton();
        btn_Row4 = new javax.swing.JButton();
        btn_Row5 = new javax.swing.JButton();
        btn_Row6 = new javax.swing.JButton();
        btn_Row7 = new javax.swing.JButton();
        btn_Close = new javax.swing.JButton();
        gamePanel = new GamePanel();

        lbl_Player1.setText("Player1");
        lbl_Player1.setForeground(Color.red);
        lbl_Player2.setText("Player2");
        lbl_Player2.setForeground(Color.blue);
        lbl_Versus.setText("vs");
        lbl_Turn.setText("It's your turn");

        btn_Close.setText("Close");

        btn_Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_CloseActionPerformed();
            }

        });

        btn_Row1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row1ActionPerformed();
            }
        });

        btn_Row2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row2ActionPerformed();
            }
        });

        btn_Row3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row3ActionPerformed();
            }
        });

        btn_Row4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row4ActionPerformed();
            }
        });

        btn_Row5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row5ActionPerformed();
            }
        });

        btn_Row6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row6ActionPerformed();
            }
        });

        btn_Row7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_Row7ActionPerformed();
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Row1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        gamePanelLayout.setVerticalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gamePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Row1)
                                .addComponent(btn_Row2)
                                .addComponent(btn_Row3)
                                .addComponent(btn_Row4)
                                .addComponent(btn_Row5)
                                .addComponent(btn_Row6)
                                .addComponent(btn_Row7))
                        .addContainerGap(560, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_Player1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_Versus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_Player2)
                                        .addGap(130, 130, 130)
                                        .addComponent(lbl_Turn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_Close)))
                        .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_Player1)
                                .addComponent(lbl_Versus)
                                .addComponent(lbl_Player2)
                                .addComponent(lbl_Turn))
                        .addGap(18, 18, 18)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Close)
                        .addContainerGap())
        );

        frame.setSize(600, 600);
        frame.setResizable(false);

        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

    }

    private static void insertDisc(int row, int column) {
        gamePanel.moveDisc(row, column);
    }

    //<editor-fold defaultstate="collapsed" desc="Events">
    private static void btn_CloseActionPerformed() {
        System.exit(0);
    }

    private static void btn_Row1ActionPerformed() {
        insertDisc(0, 5);
    }

    private static void btn_Row2ActionPerformed() {
        insertDisc(1, 5);
    }

    private static void btn_Row3ActionPerformed() {
        insertDisc(2, 5);
    }

    private static void btn_Row4ActionPerformed() {
        insertDisc(3, 5);
    }

    private static void btn_Row5ActionPerformed() {
        insertDisc(4, 5);
    }

    private static void btn_Row6ActionPerformed() {
        insertDisc(5, 5);
    }

    private static void btn_Row7ActionPerformed() {
        insertDisc(6, 5);
    }
    //</editor-fold>
}
