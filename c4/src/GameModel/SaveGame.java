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

/**
 *
 * @author LuLu
 */
import java.io.*;
import java.util.*;

public class SaveGame {

    Chip[][] data;
    int player;
            
    /**
     * Konstruktor für die Klasse SaveGame, erzeugt ein 2D-Array des Typs Chip und setzt den player auf "menschlicher Spieler"
     * @throws IOException 
     */
    public SaveGame() throws IOException
    {
        data = new Chip[7][6];
        player = 1;                     // player ist standartmaessig auf "menschlicher Spieler" gesetzt       
    }
    
    /**
     * Methode welche den Speilstand (2D-Array) und den Spieler am Zug (Integer) übernimmt und den Speichervorgang auslöst.
     * @param data - Chip[][]
     * @param player - int
     * @throws IOException 
     */
    public void saveGame(Chip[][] data, int player) throws IOException
    {
        this.data = data;
        this.player = player;
        createFile();
    }
    
    /**
     * Methode zum Laden des Arrays
     * @return Chip[][]
     * @throws IOException 
     */
    public Chip[][] loadGame() throws IOException
    {
        return readFile();
    }
    
    /**
     * Methode zum laden des Spielers
     * @return int 
     * @throws IOException 
     */
    public int loadPlayer() throws IOException
    {
        System.out.println(readPlayer());
        return readPlayer();
    }
    
    
   /**
    * Methode die eine Textdatei erzeugt und den Inhalt des 2D-Arrays und den Spieler speichert
    * @throws IOException 
    */
    private void createFile() throws IOException
    {
        FileWriter fw = new FileWriter("saveGame.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        if(player == 1)
        {
            bw.write("1");
            bw.newLine();
        }else{
            bw.write("2");
            bw.newLine();
        }
        
        for(int y = 0; y != 7; y++)
        {
            for(int x = 0; x != 6; x++)
            {
                if(data[y][x].getOwner() == 1){
                    bw.write("1");
                } else if (data[y][x].getOwner() == 2) {
                    bw.write("2");
                } else {
                    bw.write("0");
                }
                bw.write(";");
            }
            bw.newLine();
        }
               
        bw.close();
    }
    
    /**
     * Methode die den Spieler der am Zug ist zurück gibt
     * @return int
     * @throws IOException 
     */
    private int readPlayer() throws IOException
    {
        FileReader fr = new FileReader("saveGame.txt");
        BufferedReader br = new BufferedReader(fr);
        
       
        player = Integer.parseInt(br.readLine());
        br.close();
        
        return player;
    }    
    
    /**
     * Methode die die Daten aus der Textdatei in ein 2D-Array schreibt
     * @return Chip[][]
     * @throws IOException 
     */
    private Chip[][] readFile() throws IOException
    {
        FileReader fr = new FileReader("saveGame.txt");
        BufferedReader br = new BufferedReader(fr);
        
        br.readLine(); // Ueberspringt erste Zeile im File (Player-Zeile)
        
        for(int y = 0; y != 6; y++)
        {
            int x = 0;
            String column = br.readLine();
            StringTokenizer token = new StringTokenizer(column, ";");
        
            while (token.hasMoreTokens()) {
                data[y][x] = new Chip(Integer.parseInt(token.nextToken()), x, y, data);
                x++;
            }
        }
        br.close();
        
        return data;
    }  
}
