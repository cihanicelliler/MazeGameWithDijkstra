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
public class Azman {

    private int tileX, tileY;
    private Image azman;

    private int[][] harita = new int[13][11];
    public int[][] yol = new int[100][2];
    int mesafe = 0;

    public Azman() {
        ImageIcon img = new ImageIcon("C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\AzmanKucuk.png");
        azman = img.getImage();
    }
    public void Back(int tileX, int tileY) {
        this.tileX = tileX;
        this.tileY = tileY;

    }

    public Image getAzman() {
        return azman;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void move(int dx, int dy) {

        tileX += dx;
        tileY += dy;

    }

    public void HedefTakip(int AdimSayisi, int HedefX, int HedefY, Map map) {
        for (int adim = 0; adim < AdimSayisi; adim++) {

            for (int x = 0; x < 13; x++) {
                for (int y = 0; y < 11; y++) {
                    harita[x][y] = 900;
                }
            }
            harita[getTileX()][getTileY()] = 0;
            YolBul(getTileX() - 1, getTileY(), 1, 1, map);
            YolBul(getTileX() + 1, getTileY(), 1, 1, map);
            YolBul(getTileX(), getTileY() - 1, 1, 1, map);
            YolBul(getTileX(), getTileY() + 1, 1, 1, map);

            mesafe = harita[HedefX][HedefY];
            yol[mesafe][0] = HedefX;
            yol[mesafe][1] = HedefY;
            for (int i = mesafe - 1; i > -1; i--) {
                if (harita[yol[i + 1][0] + 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] + 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0] - 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] - 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] + 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] + 1;
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] - 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] - 1;
                }
            }

            move(yol[1][0] - getTileX(), yol[1][1] - getTileY());

        }

    }

    public void YolBul(int DegerX, int DegerY, int mesafe, int karakter, Map m) {
        if ((DegerX > -1) && (DegerY > -1) && (DegerX < 12) && (DegerY < 10)) {
            if (karakter == 1) {
                if ((m.getMap(DegerX, DegerY).equals("1")) && (harita[DegerX][DegerY] > mesafe)) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter, m);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter, m);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter, m);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter, m);
                }

            }
            if (karakter == 0) {
                if (harita[DegerX][DegerY] > mesafe) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter, m);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter, m);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter, m);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter, m);
                }

            }

        }

    }
}
