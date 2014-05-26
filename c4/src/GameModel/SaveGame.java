/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        data = new Chip[6][7];
        player = 1;                     // player ist standartmaessig auf "menschlicher Spieler" gesetzt       
    }
    
    /**
     * Methode die den Speichervorgang auslöst, sie ruft die Methode "createFile()" auf
     * @param data - 2D-Array des Typs Chip
     * @param player - Integer
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
     * @return Gibt ein 2D-Array des Typs Chip zurück
     * @throws IOException 
     */
    public Chip[][] loadGame() throws IOException
    {
        return readFile();
    }
    
    /**
     * Methode zum laden des Spielers
     * @return Gibt einen Integerwert zurück
     * @throws IOException 
     */
    public int loadPlayer() throws IOException
    {
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
        
        for(int x = 0; x != 7; x++)
        {
            for(int y = 0; y != 6; y++)
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
     * @return Integer
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
     * @return Gibt ein 2D-Array des Typs Chip zurück
     * @throws IOException 
     */
    private Chip[][] readFile() throws IOException
    {
        FileReader fr = new FileReader("saveGame.txt");
        BufferedReader br = new BufferedReader(fr);
        
        br.readLine(); // Ueberspringt erste Zeile im File (Player-Zeile)
        
        for(int x = 0; x != 7; x++)
        {
            int y = 0;
            String column = br.readLine();
            StringTokenizer token = new StringTokenizer(column, ";");
        
            while (token.hasMoreTokens()) {
                data[y][x] = new Chip(Integer.parseInt(token.nextToken()), x, y, data);
                y++;
            }
        }
        br.close();
        
        return data;
    }  
}
