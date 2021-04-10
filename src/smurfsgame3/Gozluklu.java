/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smurfsgame3;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author icell
 */
public class Gozluklu {
    private int tileX,tileY;
    private Image gozluklu;
    private int puan;
    public Gozluklu() {
        ImageIcon img = new ImageIcon("C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\GozlukluKucuk.png");
        gozluklu=img.getImage();
       
        tileX=6;
        tileY=5;
        
    }
    public Image getGozluklu(){
        return gozluklu;
    }
 
    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
    
    public void move(int dx,int dy){
        
        tileX+=dx;
        tileY+=dy;
        
    }
    
}