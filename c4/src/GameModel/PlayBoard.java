/*
 *  C4 - Connect Four
 *  Copyright (C) 2014 by Ervin Mazlagic, Jan Vonmoos, Alain Studhalter,
 *  Michael Müller, Lukas Luthiger
 * 
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package GameModel;

import java.awt.event.ActionEvent;
import GameView.GameBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JanV Vonmoos
 */
public class PlayBoard implements GameRulez {

    private static final int xaxes = 7;
    private static final int yaxes = 6;
    private Chip[][] playBoard;
    private boolean currentuser = true;
    private GameBoard gameboard;

    List<ModelListener> listeners = new ArrayList<ModelListener>();

    public PlayBoard() {
        playBoard = new Chip[yaxes][xaxes];
    }

    public PlayBoard(GameBoard gameboard) {
        playBoard = new Chip[yaxes][xaxes];
        this.gameboard = gameboard;
    }

    public PlayBoard(Chip playBoard[][], GameBoard gameboard) {
        this.playBoard = playBoard;
        this.gameboard = gameboard;
    }

    public void addListener(ModelListener toAdd) {
        listeners.add(toAdd);
    }

    @Override
    public boolean didIWin() {
        int[] winnset = new int[8];
        int n = 0;

        for (Chip[] s : playBoard) {

            for (Chip val : s) {
                if (val != null) {
                    if (val.getWinnstone()) {
                        if (n < 8) {
                            winnset[n] = val.getx();
                            n++;
                            winnset[n] = val.gety();
                            n++;
                        }
                        for (ModelListener hl : listeners) {
                            hl.winnIsSet();
                        }

                    }
                }
            }
        }

        if (n > 0) {
            gameboard.showWinChips(winnset);
            return true;
        }
        return false;
    }

    @Override
    public Chip[][] getBoard() {
        return playBoard;
    }

    @Override
    public Chip getSlot(int row, int col) {
        return playBoard[row][col];
    }

    @Override
    public boolean isLegalInsert(int col) {
        if (0 <= col && col < 7) {
            if (getSlot(0, col) == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearboard() {
        playBoard = new Chip[yaxes][xaxes];
        for (ModelListener hl : listeners) {
            hl.boardHasChanged(coppy2dArray());
        }
    }

    @Override
    public boolean isMyTurn() {
        return currentuser;
    }

    @Override
    public boolean insertChip(int player, int x) {
        int y = 0;
        if (isLegalInsert(x)) {
            for (int n = 1; n < 6; n++) {
                if (playBoard[n][x] == null) {
                    y++;
                }
            }
            playBoard[y][x] = new Chip(player, x, y, playBoard);
            
            while(gameboard.checkRunning()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            gameboard.insertDisc(x, y, currentuser);

            for (ModelListener hl : listeners) {
                hl.boardHasChanged(coppy2dArray());
            }

            switchPlayer();
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void switchPlayer() {

        if (currentuser) {
            currentuser = false;
        } else {
            currentuser = true;
        }

    }

    private Chip[][] coppy2dArray() {
        Chip[][] cppb = new Chip[yaxes][xaxes];
        int a = 0;

        for (Chip[] c1 : playBoard) {
            cppb[a] = c1;
            a++;
        }
        return cppb;
    }
}
