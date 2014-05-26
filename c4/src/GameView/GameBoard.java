/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

/**
 *
 * @author studhaal
 */
public class GameBoard {

    public GameBoard(ActionListener control) {
        createAndShowGUI();
        btnVsComputerActionPerformed();
        this.control = control;
        myTurn = true;
    }

    //<editor-fold defaultstate="collapsed" desc="gameBoard Variables">
    private static JFrame gameBoard;
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
    private static ActionListener control;
    private static boolean myTurn;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="mainMenu Variables">
    private static JFrame mainMenu;
    private static JButton btnLoad;
    private static JButton btnStart;
    private static JButton btnVsComputer;
    private static JButton btnVsPlayer;
    private static JPanel buttonPanel;
    private static JScrollPane jScrollPane1;
    private static JPanel listPanel;
    private static JList listPlayers;
    //</editor-fold>

    private void createAndShowGUI() {
        //<editor-fold defaultstate="collapsed" desc="Frame gameBoard">
        gameBoard = new JFrame("C4 - Game Board");
        lbl_Player1 = new JLabel();
        lbl_Player2 = new JLabel();
        lbl_Versus = new JLabel();
        lbl_Turn = new JLabel();
        btn_Row1 = new JButton();
        btn_Row2 = new JButton();
        btn_Row3 = new JButton();
        btn_Row4 = new JButton();
        btn_Row5 = new JButton();
        btn_Row6 = new JButton();
        btn_Row7 = new JButton();
        btn_Close = new JButton();
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
        btn_Row1.setActionCommand("0");
        btn_Row1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row1ActionPerformed();
            }
        });

        btn_Row2.setActionCommand("1");
        btn_Row2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row2ActionPerformed();
            }
        });

        btn_Row3.setActionCommand("2");
        btn_Row3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row3ActionPerformed();
            }
        });

        btn_Row4.setActionCommand("3");
        btn_Row4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row4ActionPerformed();
            }
        });

        btn_Row5.setActionCommand("4");
        btn_Row5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row5ActionPerformed();
            }
        });

        btn_Row6.setActionCommand("5");
        btn_Row6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row6ActionPerformed();
            }
        });

        btn_Row7.setActionCommand("6");
        btn_Row7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendActionToControl(evt);
                btn_Row7ActionPerformed();
            }
        });

        GroupLayout gamePanelLayout = new GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
                gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Row1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Row7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        gamePanelLayout.setVerticalGroup(
                gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gamePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Row1)
                                .addComponent(btn_Row2)
                                .addComponent(btn_Row3)
                                .addComponent(btn_Row4)
                                .addComponent(btn_Row5)
                                .addComponent(btn_Row6)
                                .addComponent(btn_Row7))
                        .addContainerGap(560, Short.MAX_VALUE))
        );

        GroupLayout layoutgameBoard = new GroupLayout(gameBoard.getContentPane());
        gameBoard.getContentPane().setLayout(layoutgameBoard);
        layoutgameBoard.setHorizontalGroup(
                layoutgameBoard.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layoutgameBoard.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layoutgameBoard.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layoutgameBoard.createSequentialGroup()
                                        .addComponent(lbl_Player1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_Versus)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_Player2)
                                        .addGap(130, 130, 130)
                                        .addComponent(lbl_Turn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, layoutgameBoard.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_Close)))
                        .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, layoutgameBoard.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layoutgameBoard.setVerticalGroup(
                layoutgameBoard.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layoutgameBoard.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layoutgameBoard.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_Player1)
                                .addComponent(lbl_Versus)
                                .addComponent(lbl_Player2)
                                .addComponent(lbl_Turn))
                        .addGap(18, 18, 18)
                        .addComponent(gamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Close)
                        .addContainerGap())
        );

        gameBoard.setSize(600, 600);
        gameBoard.setResizable(false);

        gameBoard.add(gamePanel);
        gameBoard.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //<editor-fold defaultstate="collapsed" desc="gameBoard Window Listener">
        gameBoard.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                btn_CloseActionPerformed();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowOpened(WindowEvent e) {
            }
        });
        //</editor-fold>
        //gameBoard.pack();
        gameBoard.setVisible(false);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Frame mainMenu">
        mainMenu = new JFrame("C4 - Main Menu");
        buttonPanel = new JPanel();
        btnVsComputer = new JButton();
        btnVsPlayer = new JButton();
        btnLoad = new JButton();
        btnStart = new JButton();
        listPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        listPlayers = new JList();

        btnVsComputer.setText("vs Computer");
        btnVsComputer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnVsComputerActionPerformed();
            }
        });

        btnVsPlayer.setText("vs Player");
        btnVsPlayer.setActionCommand("SearchPlayer");
        btnVsPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnVsPlayerActionPerformed();
                control.actionPerformed(evt);
            }
        });

        btnLoad.setText("Load Game");
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnLoadActionPerformed();
                control.actionPerformed(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.setActionCommand("GameStart");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnStartActionPerformed();
            }
        });

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setTitle("C4 - Main Menu");
        mainMenu.setPreferredSize(new Dimension(400, 400));
        mainMenu.setResizable(false);

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVsComputer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVsPlayer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVsComputer)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVsPlayer)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoad)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStart)
                        .addContainerGap())
        );

        listPlayers.setModel(new AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        listPlayers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listPlayers);

        GroupLayout listPanelLayout = new GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(listPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(listPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                        .addContainerGap())
        );

        GroupLayout layoutmainMenu = new GroupLayout(mainMenu.getContentPane());
        mainMenu.getContentPane().setLayout(layoutmainMenu);
        layoutmainMenu.setHorizontalGroup(
                layoutmainMenu.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layoutmainMenu.createSequentialGroup()
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(listPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layoutmainMenu.setVerticalGroup(
                layoutmainMenu.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainMenu.pack();
        mainMenu.setVisible(true);
        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc="Events">
    private static void btn_CloseActionPerformed() {
        gameBoard.setVisible(false);
        mainMenu.setVisible(true);
    }

    private void btn_Row1ActionPerformed() {
        //insertDisc(0, 5);
    }

    private void btn_Row2ActionPerformed() {
        //insertDisc(1, 5);
    }

    private void btn_Row3ActionPerformed() {
        //insertDisc(2, 5);
    }

    private void btn_Row4ActionPerformed() {
        //insertDisc(3, 5);
    }

    private void btn_Row5ActionPerformed() {
        //insertDisc(4, 5);
    }

    private void btn_Row6ActionPerformed() {
        //insertDisc(5, 5);
    }

    private void btn_Row7ActionPerformed() {
        //insertDisc(6, 5);
    }

    private void sendActionToControl(ActionEvent evt) {
        if (!gamePanel.thRunning()) {
            control.actionPerformed(evt);
        }
    }

    private void btnVsComputerActionPerformed() {
        btnVsComputer.setBackground(Color.red);
        btnVsPlayer.setBackground(null);
        btnLoad.setBackground(null);
        LoadComputers();
    }

    private void btnVsPlayerActionPerformed() {
        btnVsComputer.setBackground(null);
        btnVsPlayer.setBackground(Color.red);
        btnLoad.setBackground(null);
        LoadPlayers();
    }

    private void btnLoadActionPerformed() {
        btnVsComputer.setBackground(null);
        btnVsPlayer.setBackground(null);
        btnLoad.setBackground(Color.red);
        LoadGames();
    }

    private void btnStartActionPerformed() {
        mainMenu.setVisible(false);
        gameBoard.setVisible(true);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public void insertDisc(int row, int column, boolean player) {
        if (!gamePanel.thRunning()) {
            gamePanel.moveDisc(row, column, player);
            gamePanel.startMoving();
        }
    }

    public void showWinChips(int[] winnerchips) {
        gamePanel.drawWinner(winnerchips);
    }

    private void LoadComputers() {
        listPlayers.setModel(new AbstractListModel() {
            String[] strings = {"Easy", "Hard"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void LoadPlayers() {
        listPlayers.setModel(new AbstractListModel() {
            String[] strings = {"Player 1", "Player 2", "Player 3"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void LoadGames() {
        listPlayers.setModel(new AbstractListModel() {
            String[] strings = {"SaveGame 1", "SaveGame 2", "SaveGame 3"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });

    }

    public void SwitchPlayer() {
        myTurn = !myTurn;
        lockControls();
    }

    private void lockControls() {
        btn_Row1.setEnabled(myTurn);
        btn_Row2.setEnabled(myTurn);
        btn_Row3.setEnabled(myTurn);
        btn_Row4.setEnabled(myTurn);
        btn_Row5.setEnabled(myTurn);
        btn_Row6.setEnabled(myTurn);
        btn_Row7.setEnabled(myTurn);
    }
    
    public boolean isMoving(){
        return gamePanel.isMoving();
    }
    //</editor-fold>
}
