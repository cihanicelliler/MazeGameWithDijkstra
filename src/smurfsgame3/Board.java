package smurfsgame3;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author icell
 */
public class Board extends JPanel implements ActionListener {

    public String adres = "C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\";
    private Timer timer;
    private int click;
    private int totalPuan = 20;
    String cumle1;
    String cumle2;
    private int HedefX = 0, HedefY = 0;
    private int[][] harita = new int[13][11];
    private int[][] yol = new int[100][2];
    public int end = 0, mesafe = 0, YolCizim = 0;
    private Map m;
    private Tembel tembel;
    private Gozluklu gozluklu;
    private Gargamel gargamel;
    private int gargamelx;
    private int gargamely;
    private int azmanx;
    private int azmany;
    private Azman azman;
    private Image sirine;
    private JButton tembelbtn, sk;
    public Puan puan;
    private int healthh = 6, healthh2 = 3;
    private JLabel lb;
    String[] k1 = {"Karakter:Gargamel,Kapi:A", "Karakter:Gargamel,Kapi:B", "Karakter:Gargamel,Kapi:C", "Karakter:Gargamel,Kapi:D", "Karakter:Gargamel,Kapi:E",};
    String[] k2 = {"Karakter:Azman,Kapi:A", "Karakter:Azman,Kapi:B", "Karakter:Azman,Kapi:C", "Karakter:Azman,Kapi:D", "Karakter:Azman,Kapi:E",};

    public Board() {

        ImageIcon img = new ImageIcon(adres + "\\SirineKucuk.png");
        sirine = img.getImage();

        m = new Map();
        tembel = new Tembel();
        gozluklu = new Gozluklu();
        gargamel = new Gargamel();
        azman = new Azman();
        //storm = new Stormtrooper();
        addKeyListener(new Al());
        addKeyListener(new All());

        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
        puan = new Puan();

        puanTopla();
        ImageIcon tembelbtnpng = new ImageIcon(adres + "\\TembelSirin.png");
        ImageIcon gozluklupng = new ImageIcon(adres + "\\GozlukluSirin.png");

        sk = new JButton("", gozluklupng);

        tembelbtn = new JButton("", tembelbtnpng);
        setLayout(new FlowLayout());
        add(tembelbtn);
        add(sk);
        lb = new JLabel("     Tembel Sirin                                                                                     Gozluklu Sirin     ");
        add(lb);

        tembelbtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override

            public void mouseReleased(MouseEvent e) {

                click = 1;

                removeAll();
            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        sk.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override

            public void mouseReleased(MouseEvent e) {
                click = 0;
                removeAll();
            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

        try {
            File myObj = new File("C:\\Users\\icell\\Documents\\NetBeansProjects\\SmurfsGame3\\src\\harita.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == 0) {
                    cumle1 = data;
                }
                if (i == 1) {
                    cumle2 = data;
                }
                i++;
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if ("Karakter:Gargamel,Kapi:A".equals(cumle1)) {
            gargamel.move(3, 0);
            gargamelx = 3;
            gargamely = 0;
        } else if ("Karakter:Gargamel,Kapi:B".equals(cumle1)) {
            gargamel.move(10, 0);
            gargamelx = 10;
            gargamely = 0;
        } else if ("Karakter:Gargamel,Kapi:C".equals(cumle1)) {
            gargamel.move(0, 5);
            gargamelx = 0;
            gargamely = 5;
        } else if ("Karakter:Gargamel,Kapi:D".equals(cumle1)) {
            gargamel.move(3, 10);
            gargamelx = 3;
            gargamely = 10;
        } else if ("Karakter:Azman,Kapi:A".equals(cumle1)) {
            azman.move(3, 0);
            azmanx = 3;
            azmany = 0;
        } else if ("Karakter:Azman,Kapi:B".equals(cumle1)) {
            azman.move(10, 0);
            azmanx = 10;
            azmany = 0;
        } else if ("Karakter:Azman,Kapi:C".equals(cumle1)) {
            azman.move(0, 5);
            azmanx = 0;
            azmany = 5;
        } else if ("Karakter:Azman,Kapi:D".equals(cumle1)) {
            azman.move(3, 10);
            azmanx = 3;
            azmany = 10;
        }

        if ("Karakter:Gargamel,Kapi:A".equals(cumle2)) {
            gargamel.move(3, 0);
            gargamelx = 3;
            gargamely = 0;
        } else if ("Karakter:Gargamel,Kapi:B".equals(cumle2)) {
            gargamel.move(10, 0);
            gargamelx = 10;
            gargamely = 0;
        } else if ("Karakter:Gargamel,Kapi:C".equals(cumle2)) {
            gargamel.move(0, 5);
            gargamelx = 0;
            gargamely = 5;
        } else if ("Karakter:Gargamel,Kapi:D".equals(cumle2)) {
            gargamel.move(3, 10);
            gargamelx = 3;
            gargamely = 10;
        } else if ("Karakter:Azman,Kapi:A".equals(cumle2)) {
            azman.move(3, 0);
            azmanx = 3;
            azmany = 0;
        } else if ("Karakter:Azman,Kapi:B".equals(cumle2)) {
            azman.move(10, 0);
            azmanx = 10;
            azmany = 0;
        } else if ("Karakter:Azman,Kapi:C".equals(cumle2)) {
            azman.move(0, 5);
            azmanx = 0;
            azmany = 5;
        } else if ("Karakter:Azman,Kapi:D".equals(cumle2)) {
            azman.move(3, 10);
            azmanx = 3;
            azmany = 10;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        if (!tembelbtn.isDisplayable()) {

            g.translate(190, 170);
            {
                for (int row = 0; row < 11; row++) {
                    for (int col = 0; col < 13; col++) {
                        Color color;
                        if (m.getMap(col, row).equals("1")) {
                            g.setColor(Color.white);
                            g.fillRect(30 * col, 30 * row, 30, 30);

                        }
                        if (m.getMap(col, row).equals("0")) {
                            g.setColor(Color.gray);
                            g.fillRect(30 * col, 30 * row, 30, 30);
                        }
                        for (int i = 1; i < gargamel.mesafe; i++) {
                            if (gargamel.yol[i][0] == col && gargamel.yol[i][1] == row) {
                                g.setColor(Color.RED);
                                g.fillRect(30 * col, 30 * row, 30, 30);
                            }
                        }

                        for (int i = 1; i < azman.mesafe; i++) {
                            if (azman.yol[i][0] == col && azman.yol[i][1] == row) {
                                g.setColor(Color.ORANGE);
                                g.fillRect(30 * col, 30 * row, 30, 30);
                            }
                        }

                        g.setColor(Color.BLACK);
                        g.drawRect(30 * col, 30 * row, 30, 30);

                    }
                }
                g.drawImage(puan.getPuan(), puan.getAx() * 30, puan.getAy() * 30, 30, 30, null);
                g.drawImage(puan.getPuan(), puan.getAx2() * 30, puan.getAy2() * 30, 30, 30, null);
                g.drawImage(puan.getPuan(), puan.getAx3() * 30, puan.getAy3() * 30, 30, 30, null);
                g.drawImage(puan.getPuan(), puan.getAx4() * 30, puan.getAy4() * 30, 30, 30, null);
                g.drawImage(puan.getPuan(), puan.getAx5() * 30, puan.getAy5() * 30, 30, 30, null);
                g.drawImage(puan.getMantarPuan(), puan.getmantarAx() * 30, puan.getmantarAy() * 30, 30, 30, null);
            }
            g.drawImage(sirine, 360, 210, this);

        }

        if (click == 1 && !tembelbtn.isDisplayable()) {

            g.drawImage(tembel.getTembel(), (tembel.getTileX() * 30), (tembel.getTileY() * 30), null);
            if ((gargamel.getTileX() == tembel.getTileX() && gargamel.getTileY() == tembel.getTileY())) {
                gargamel.Back(gargamelx, gargamely);
                totalPuan -= 15;
                System.out.println(totalPuan);
            }
            if ((azman.getTileX() == tembel.getTileX() && azman.getTileY() == tembel.getTileY())) {
                azman.Back(azmanx, azmany);
                totalPuan -= 5;
                System.out.println(totalPuan);
            }
            if (totalPuan <= 0) {
                JOptionPane.showMessageDialog(null, "OYUN BİTTİ!", "OYUN BİTTİ!", 2);
            }

        }
        if (click == 1 || click == 0 && !tembelbtn.isDisplayable()) {

            g.drawImage(gargamel.getGargamel(), (gargamel.getTileX() * 30), (gargamel.getTileY() * 30), null);

            g.drawImage(azman.getAzman(), (azman.getTileX() * 30), (azman.getTileY() * 30), null);
        }

        if (click == 0 && !sk.isDisplayable()) {
            g.drawImage(gozluklu.getGozluklu(), (gozluklu.getTileX() * 30), (gozluklu.getTileY() * 30), null);
            if ((gargamel.getTileX() == gozluklu.getTileX() && gargamel.getTileY() == gozluklu.getTileY())) {
                gargamel.Back(gargamelx, gargamely);
                totalPuan -= 15;
                System.out.println(totalPuan);
            }
            if ((azman.getTileX() == gozluklu.getTileX() && azman.getTileY() == gozluklu.getTileY())) {
                azman.Back(azmanx, azmany);
                totalPuan -= 5;
                System.out.println(totalPuan);
            }
            if (totalPuan <= 0) {
                JOptionPane.showMessageDialog(null, "OYUN BİTTİ!", "OYUN BİTTİ!", 2);
            }
        }
    }

    public void puanTopla() {
        java.util.Timer zaman = new java.util.Timer();
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                Random rnd = new Random();
                int x1 = rnd.nextInt(10) + 1;
                int y1 = rnd.nextInt(8) + 1;
                int x2 = rnd.nextInt(10) + 1;
                int y2 = rnd.nextInt(8) + 1;
                int x3 = rnd.nextInt(10) + 1;
                int y3 = rnd.nextInt(8) + 1;
                int x4 = rnd.nextInt(10) + 1;
                int y4 = rnd.nextInt(8) + 1;
                int x5 = rnd.nextInt(10) + 1;
                int y5 = rnd.nextInt(8) + 1;

                if (!m.getMap(x1 + 0, y1 + 0).equals("0")) {
                    puan.xyAl(x1 + 0, y1 + 0);
                }
                if (!m.getMap(x2 + 0, y2 + 0).equals("0")) {
                    puan.xyAl2(x2 + 0, y2 + 0);
                }
                if (!m.getMap(x3 + 0, y3 + 0).equals("0")) {
                    puan.xyAl3(x3 + 0, y3 + 0);
                }
                if (!m.getMap(x4 + 0, y4 + 0).equals("0")) {
                    puan.xyAl4(x4 + 0, y4 + 0);
                }
                if (!m.getMap(x5 + 0, y5 + 0).equals("0")) {
                    puan.xyAl5(x5 + 0, y5 + 0);

                }
            }
        };
        zaman.schedule(gorev, 0, 5000);
        java.util.Timer zaman1 = new java.util.Timer();
        TimerTask gorev1 = new TimerTask() {
            @Override
            public void run() {
                Random rnd = new Random();
                int mantarx = rnd.nextInt(10) + 1;
                int mantary = rnd.nextInt(8) + 1;

                if (!m.getMap(mantarx + 0, mantary + 0).equals("0")) {
                    puan.xyMantarAl(mantarx + 0, mantary + 0);

                }

            }
        };
        zaman1.schedule(gorev1, 0, 7000);
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP && click == 1) {
                if (m.getMap(tembel.getTileX(), tembel.getTileY() - 1).equals("1") && tembel.getTileY() > 0) {
                    tembel.move(0, -1);
                    gargamel.HedefTakip(2, tembel.getTileX(), tembel.getTileY(), m);
                    azman.HedefTakip(1, tembel.getTileX(), tembel.getTileY(), m);
                }
                if ((tembel.getTileX() == puan.getAx() && tembel.getTileY() == puan.getAy()) || (tembel.getTileX() == puan.getAx2() && tembel.getTileY() == puan.getAy2() || (tembel.getTileX() == puan.getAx3() && tembel.getTileY() == puan.getAy3()) || (tembel.getTileX() == puan.getAx4() && tembel.getTileY() == puan.getAy4()) || (tembel.getTileX() == puan.getAx5() && tembel.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (tembel.getTileX() == puan.getmantarAx() && tembel.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 1) {
                if (m.getMap(tembel.getTileX(), tembel.getTileY() + 1).equals("1") && tembel.getTileY() < 11) {
                    tembel.move(0, 1);
                    gargamel.HedefTakip(2, tembel.getTileX(), tembel.getTileY(), m);
                    azman.HedefTakip(1, tembel.getTileX(), tembel.getTileY(), m);
                }
                if ((tembel.getTileX() == puan.getAx() && tembel.getTileY() == puan.getAy()) || (tembel.getTileX() == puan.getAx2() && tembel.getTileY() == puan.getAy2() || (tembel.getTileX() == puan.getAx3() && tembel.getTileY() == puan.getAy3()) || (tembel.getTileX() == puan.getAx4() && tembel.getTileY() == puan.getAy4()) || (tembel.getTileX() == puan.getAx5() && tembel.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (tembel.getTileX() == puan.getmantarAx() && tembel.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 1) {
                if (m.getMap(tembel.getTileX() - 1, tembel.getTileY()).equals("1") && tembel.getTileX() > 0) {
                    tembel.move(-1, 0);
                    gargamel.HedefTakip(2, tembel.getTileX(), tembel.getTileY(), m);
                    azman.HedefTakip(1, tembel.getTileX(), tembel.getTileY(), m);
                }
                if ((tembel.getTileX() == puan.getAx() && tembel.getTileY() == puan.getAy()) || (tembel.getTileX() == puan.getAx2() && tembel.getTileY() == puan.getAy2() || (tembel.getTileX() == puan.getAx3() && tembel.getTileY() == puan.getAy3()) || (tembel.getTileX() == puan.getAx4() && tembel.getTileY() == puan.getAy4()) || (tembel.getTileX() == puan.getAx5() && tembel.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (tembel.getTileX() == puan.getmantarAx() && tembel.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 1) {
                if (m.getMap(tembel.getTileX() + 1, tembel.getTileY()).equals("1") && tembel.getTileX() < 12) {
                    tembel.move(1, 0);
                    gargamel.HedefTakip(2, tembel.getTileX(), tembel.getTileY(), m);
                    azman.HedefTakip(1, tembel.getTileX(), tembel.getTileY(), m);
                }
                if ((tembel.getTileX() == puan.getAx() && tembel.getTileY() == puan.getAy()) || (tembel.getTileX() == puan.getAx2() && tembel.getTileY() == puan.getAy2() || (tembel.getTileX() == puan.getAx3() && tembel.getTileY() == puan.getAy3()) || (tembel.getTileX() == puan.getAx4() && tembel.getTileY() == puan.getAy4()) || (tembel.getTileX() == puan.getAx5() && tembel.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (tembel.getTileX() == puan.getmantarAx() && tembel.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            OyunKontrol();
        }
    }

    public class All extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP && click == 0) {
                if (!m.getMap(gozluklu.getTileX(), gozluklu.getTileY() - 2).equals("0") && gozluklu.getTileY() > 0) {
                    if (!m.getMap(gozluklu.getTileX(), gozluklu.getTileY() - 1).equals("0") && gozluklu.getTileY() > 0) {
                        gozluklu.move(0, -2);
                        gargamel.HedefTakip(2, gozluklu.getTileX(), gozluklu.getTileY(), m);
                        azman.HedefTakip(1, gozluklu.getTileX(), gozluklu.getTileY(), m);
                    }

                }
                if ((gozluklu.getTileX() == puan.getAx() && gozluklu.getTileY() == puan.getAy()) || (gozluklu.getTileX() == puan.getAx2() && gozluklu.getTileY() == puan.getAy2() || (gozluklu.getTileX() == puan.getAx3() && gozluklu.getTileY() == puan.getAy3()) || (gozluklu.getTileX() == puan.getAx4() && gozluklu.getTileY() == puan.getAy4()) || (gozluklu.getTileX() == puan.getAx5() && gozluklu.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (gozluklu.getTileX() == puan.getmantarAx() && gozluklu.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 0) {
                if (!m.getMap(gozluklu.getTileX(), gozluklu.getTileY() + 2).equals("0") && gozluklu.getTileY() < 11) {
                    if (!m.getMap(gozluklu.getTileX(), gozluklu.getTileY() + 1).equals("0") && gozluklu.getTileY() < 11) {
                        gozluklu.move(0, 2);
                        gargamel.HedefTakip(2, gozluklu.getTileX(), gozluklu.getTileY(), m);
                        azman.HedefTakip(1, gozluklu.getTileX(), gozluklu.getTileY(), m);
                    }
                }
                if ((gozluklu.getTileX() == puan.getAx() && gozluklu.getTileY() == puan.getAy()) || (gozluklu.getTileX() == puan.getAx2() && gozluklu.getTileY() == puan.getAy2() || (gozluklu.getTileX() == puan.getAx3() && gozluklu.getTileY() == puan.getAy3()) || (gozluklu.getTileX() == puan.getAx4() && gozluklu.getTileY() == puan.getAy4()) || (gozluklu.getTileX() == puan.getAx5() && gozluklu.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (gozluklu.getTileX() == puan.getmantarAx() && gozluklu.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 0) {
                if (!m.getMap(gozluklu.getTileX() - 2, gozluklu.getTileY()).equals("0") && gozluklu.getTileX() > 0) {
                    if (!m.getMap(gozluklu.getTileX() - 1, gozluklu.getTileY()).equals("0") && gozluklu.getTileX() > 0) {
                        gozluklu.move(-2, 0);
                        gargamel.HedefTakip(2, gozluklu.getTileX(), gozluklu.getTileY(), m);
                        azman.HedefTakip(1, gozluklu.getTileX(), gozluklu.getTileY(), m);
                    }
                }
                if ((gozluklu.getTileX() == puan.getAx() && gozluklu.getTileY() == puan.getAy()) || (gozluklu.getTileX() == puan.getAx2() && gozluklu.getTileY() == puan.getAy2() || (gozluklu.getTileX() == puan.getAx3() && gozluklu.getTileY() == puan.getAy3()) || (gozluklu.getTileX() == puan.getAx4() && gozluklu.getTileY() == puan.getAy4()) || (gozluklu.getTileX() == puan.getAx5() && gozluklu.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (gozluklu.getTileX() == puan.getmantarAx() && gozluklu.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 0) {
                if (!m.getMap(gozluklu.getTileX() + 2, gozluklu.getTileY()).equals("0") && gozluklu.getTileX() < 12) {
                    if (!m.getMap(gozluklu.getTileX() + 1, gozluklu.getTileY()).equals("0") && gozluklu.getTileX() < 12) {
                        gozluklu.move(2, 0);
                        gargamel.HedefTakip(2, gozluklu.getTileX(), gozluklu.getTileY(), m);
                        azman.HedefTakip(1, gozluklu.getTileX(), gozluklu.getTileY(), m);
                    }
                }
                if ((gozluklu.getTileX() == puan.getAx() && gozluklu.getTileY() == puan.getAy()) || (gozluklu.getTileX() == puan.getAx2() && gozluklu.getTileY() == puan.getAy2() || (gozluklu.getTileX() == puan.getAx3() && gozluklu.getTileY() == puan.getAy3()) || (gozluklu.getTileX() == puan.getAx4() && gozluklu.getTileY() == puan.getAy4()) || (gozluklu.getTileX() == puan.getAx5() && gozluklu.getTileY() == puan.getAy5()))) {
                    totalPuan += 5;
                    System.out.println(totalPuan);
                }
                if (gozluklu.getTileX() == puan.getmantarAx() && gozluklu.getTileY() == puan.getmantarAy()) {
                    totalPuan += 50;
                    System.out.println(totalPuan);
                }
            }
            OyunKontrol();
        }
    }

    public void OyunKontrol() {
        if (((tembel.getTileX() == 11) && (tembel.getTileY() == 7)) && (end == 0)) {
            JOptionPane.showMessageDialog(null, "TEBRIKLER! PUAN: " + totalPuan, "TEBRIKLER!", 1);
            end = 1;
        }
        if ((gozluklu.getTileX() == 10 && gozluklu.getTileY() == 7 && end == 0) || (gozluklu.getTileX() == 11 && gozluklu.getTileY() == 7 && end == 0)) {
            JOptionPane.showMessageDialog(null, "TEBRIKLER! PUAN: " + totalPuan, "TEBRIKLER!", 1);
            end = 1;
        }
    }

    public void HedefTakip(int AdimSayisi) {
        for (int adim = 0; adim < AdimSayisi; adim++) {

            for (int x = 0; x < 13; x++) {
                for (int y = 0; y < 11; y++) {
                    harita[x][y] = 900;
                }
            }

            if (click == 0) {
                HedefX = gozluklu.getTileX();
                HedefY = gozluklu.getTileY();
            } else if (click == 1) {
                HedefX = tembel.getTileX();
                HedefY = tembel.getTileY();
            }

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

            gargamel.move(yol[1][0] - gargamel.getTileX(), yol[1][1] - gargamel.getTileY());
            azman.move(yol[1][0] - azman.getTileX(), yol[1][1] - azman.getTileY());

        }

    }
}
