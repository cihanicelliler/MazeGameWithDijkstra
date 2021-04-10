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
public class Puan {

    private int ax;
    private int ay;
    private int ax2;
    private int ay2;
    private int ax3;
    private int ay3;
    private int ax4;
    private int ay4;
    private int ax5;
    private int ay5;
    private int mantarax;
    private int mantaray;

    private Image puan;
    private Image mantarPuan;

    public Puan() {
        ImageIcon altin = new ImageIcon("C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\altin.png");
        ImageIcon mantar = new ImageIcon("C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\Mantar.png");
        puan = altin.getImage();
        mantarPuan = mantar.getImage();
        ax = 1;
        ay = 1;
        ax2 = 1;
        ay2 = 1;
        ax3 = 1;
        ay3 = 1;
        ax4 = 1;
        ay4 = 1;
        ax5 = 1;
        ay5 = 1;
        mantarax = 1;
        mantaray = 1;
    }

    public Image getPuan() {
        return puan;
    }

    public Image getMantarPuan() {
        return mantarPuan;
    }

    public int getAx() {
        return ax;
    }

    public int getAy() {
        return ay;
    }

    public int getmantarAx() {
        return mantarax;
    }

    public int getmantarAy() {
        return mantaray;
    }

    public void xyMantarAl(int dx, int dy) {
        mantarax = dx;
        mantaray = dy;
    }

    public void xyAl(int dx, int dy) {
        ax = dx;
        ay = dy;
    }

    public int getAx2() {
        return ax2;
    }

    public int getAy2() {
        return ay2;
    }

    public void xyAl2(int dx, int dy) {
        ax2 = dx;
        ay2 = dy;
    }

    public int getAx3() {
        return ax3;
    }

    public int getAy3() {
        return ay3;
    }

    public void xyAl3(int dx, int dy) {
        ax3 = dx;
        ay3 = dy;
    }

    public int getAx4() {
        return ax4;
    }

    public int getAy4() {
        return ay4;
    }

    public void xyAl4(int dx, int dy) {
        ax4 = dx;
        ay4 = dy;
    }

    public int getAx5() {
        return ax5;
    }

    public int getAy5() {
        return ay5;
    }

    public void xyAl5(int dx, int dy) {
        ax5 = dx;
        ay5 = dy;
    }

}
