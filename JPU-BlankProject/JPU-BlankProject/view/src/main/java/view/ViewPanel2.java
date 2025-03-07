package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import java.util.*;

import javax.swing.ImageIcon;

import model.Back;
import model.Dash;
import model.Diamond;
import model.ExitDoor;
import model.Ground;
import model.Level;
import model.Monster;
import model.Objet;
import model.Roc;
import model.Wall;

/**
 * Date:02-06-2019
 * The Class ViewPanel2.
 *
 * @author Welaji chris-yvan
 */

public class ViewPanel2 extends ApplicationPanel implements Observer {

    /**
     * The Constant serialVersionUID
     */
    @Serial
    private static final long serialVersionUID = 556761802292369776L;

    /**
     * @see ViewPanel
     */
    private static final Level level = new Level(2);
    public static Objet[][] tabObjets = new Objet[25][51];
    private ExitDoor exit1;
    private int diamondCount;
    public static Dash dash = new Dash(320, 576);
    private int gameDuration = 150;
    int xStart = 0;
    int yStart = 0;
    private int deathCount;
    private boolean exitable;
    private final Random r = new Random();

    /**
     * Arraylist of monsters
     */
    public static List<Monster> tabMonsters = new ArrayList<>();

    private static final int PAUSE = 3;


    public ViewPanel2() {
        diamondCount = 12;
        deathCount = 0;
        setExit1(new ExitDoor(672, 704));
        tabObjets = mapImage();
        this.exitable = false;

        //timer to handle the gametime
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (gameDuration > 0) {
                    gameDuration--;
                }
                if (gameDuration <= 0) {
                    dash.setDeath(true);
                }
                if (!dash.getWalks()) {
                    dash.setRest(true);
                }
            }
        };
        time.schedule(task, 0, 1000);

        //timer for collision between monster and hero
        Timer time2 = new Timer();
        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {
                for (Monster tabMonster : tabMonsters) {
                    if (dash.getX() == tabMonster.getX() && dash.getY() == tabMonster.getY()) {
                        dash.setDeath(true);
                    }
                }
            }
        };
        time2.schedule(task2, 10, 100);

        Timer time5 = new Timer();

        TimerTask task5 = new TimerTask() {

            @Override
            public void run() {
                int nb = r.nextInt() * 4;
                for (Monster tabMonster : tabMonsters) {

                    if (!tabMonster.getWalks()) {

                        for (int i = 0; i < 24; i++) {
                            for (int j = 0; j < 51; j++) {

                                if (nb == 0) {

                                    if (tabMonster.movesRight(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesLeft(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesUp(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesDown(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else if (nb == 1) {

                                    if (tabMonster.movesLeft(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesRight(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesUp(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesDown(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else if (nb == 2) {

                                    if (tabMonster.movesUp(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesLeft(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesRight(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesDown(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else if (nb == 3) {

                                    if (tabMonster.movesDown(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    } else if (tabMonster.movesLeft(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesUp(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesRight(tabObjets[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    }

                                }

                            }

                        }
                    } else {
                        for (int i = 0; i < 24; i++) {

                            for (int j = 0; j < 51; j++) {

                                if (tabObjets[i][j] != null) {

                                    if (tabMonster.isGoesRight()) {

                                        if (tabMonster.doesNotMoveRight(tabObjets[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesRight(false);
                                        }
                                    } else if (tabMonster.isGoesLeft()) {
                                        if (tabMonster.doesNotMoveLeft(tabObjets[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesLeft(false);
                                        }
                                    } else if (tabMonster.isGoesUp()) {
                                        if (tabMonster.doesNotMoveUp(tabObjets[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesUp(false);
                                        }
                                    } else if (tabMonster.isGoesDown()) {
                                        if (tabMonster.doesNotMoveDown(tabObjets[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesDown(false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        time5.schedule(task5, 300, 100);


        Timer time3 = new Timer();
        TimerTask task3 = new TimerTask() {

            @Override
            public void run() {

                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (tabObjets[i][j] instanceof model.Diamond) {

                            if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j + 1] instanceof model.Back && tabObjets[i + 1][j + 1] instanceof model.Back) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j + 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j + 1].setX(tabObjets[i][j].getX() + 32);
                            } else if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j - 1] instanceof model.Back && tabObjets[i + 1][j - 1] instanceof model.Back) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j - 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j - 1].setX(tabObjets[i][j].getX() - 32);
                            }
                        }

                    }
                }
            }
        };
        time3.schedule(task3, 10, 200);

        Timer time4 = new Timer();
        TimerTask task4 = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (tabObjets[i][j] instanceof model.Roc) {

                            if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j + 1] instanceof model.Back && tabObjets[i + 1][j + 1] instanceof model.Back) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j + 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j + 1].setX(tabObjets[i][j].getX() + 32);
                            } else if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j - 1] instanceof model.Back && tabObjets[i + 1][j - 1] instanceof model.Back) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j - 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j - 1].setX(tabObjets[i][j].getX() - 32);
                            }
                        }
                    }
                }
            }
        };
        time4.schedule(task4, 10, 200);

        Thread refresh = new Thread(new Refresh(PAUSE, this));
        refresh.start();
    }

    /**
     * @param o   observable
     * @param arg object
     */

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * @see ViewPanel
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 51; j++) {
                if (tabObjets[i][j] != null && tabObjets[i][j] instanceof model.Roc) {

                    tabObjets[i][j].setPushableRight(tabObjets[i][j].rightContact(tabObjets[i][j + 1]));
                    tabObjets[i][j].setPushableLeft(tabObjets[i][j].leftContact(tabObjets[i][j - 1]));

                }

            }
        }

        for (int i = 0; i < 24; i++) {

            for (int j = 0; j < 51; j++) {

                if (tabObjets[i][j] instanceof model.Roc || tabObjets[i][j] instanceof model.Diamond) {

                    if (tabObjets[i][j].nearDown(tabObjets[i + 1][j]) && !tabObjets[i][j].downContactDash(dash)) {
                        int x = tabObjets[i][j].getX();
                        int y = tabObjets[i][j].getY();
                        tabObjets[i][j].setFalling(true);
                        tabObjets[i + 1][j] = tabObjets[i][j];
                        tabObjets[i][j] = new Back(x, y);
                        tabObjets[i + 1][j].setY(tabObjets[i + 1][j].getY() + 32);
                        tabObjets[i + 1][j].setVelocity(tabObjets[i + 1][j].getVelocity() + 1);
                    } else {
                        tabObjets[i][j].setFalling(false);
                        tabObjets[i][j].setVelocity(0);
                    }
                }
                assert tabObjets[i][j] != null;
                g2.drawImage(tabObjets[i][j].getImgObj(), tabObjets[i][j].getX(), tabObjets[i][j].getY(), null);
            }
        }


        for (Monster tabMonster : tabMonsters) {
            g2.drawImage(tabMonster.getImgChar(), tabMonster.getX(), tabMonster.getY(), null);

        }

        if (diamondCount <= 5) {
            this.exitable = true;
            g2.drawImage(getExit1().getImgObj(), getExit1().getX(), getExit1().getY(), null);
        }

        if (!dash.getDeath() && !dash.isRest()) {
            g2.drawImage(dash.imageWalk(50), dash.getX(), dash.getY(), null);
        } else if (dash.isRest() && !dash.getDeath()) {
            g2.drawImage(dash.getImgChar(), dash.getX(), dash.getY(), null);
        } else if (dash.getDeath()) {
            if (deathCount == 0) {
                xStart = dash.getX();
                yStart = dash.getY();
            }
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart, yStart - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart - 64, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart, yStart - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart - 32, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart, null);
            g2.drawImage(dash.getImgChar(), dash.getX(), dash.getY(), null);
            deathCount++;

        }

        Font font = new Font("Courier", Font.BOLD, 20);
        g2.setFont(font);

        g2.fillRoundRect(20, 2, 48, 28, 20, 20);
        g2.fillRoundRect(100, 2, 63, 28, 20, 20);
        g2.fillRoundRect(100, 35, 63, 28, 20, 20);
        g2.setColor(Color.BLUE);
        g2.drawRoundRect(20, 2, 48, 28, 20, 20);
        g2.drawRoundRect(100, 2, 63, 28, 20, 20);
        g2.drawRoundRect(100, 35, 63, 28, 20, 20);
        g2.setColor(Color.WHITE);
        g2.drawString(Integer.toString(diamondCount), 130, 22);
        g2.drawString(Integer.toString(dash.getScore()), 30, 22);
        g2.drawString(Integer.toString(gameDuration), 125, 57);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/diam_icon.png"))).getImage(), 105, 8, null);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/horloge_icon.png"))).getImage(), 105, 40, null);

    }

    /**
     * @return tabObjets
     * @see ViewPanel
     */
    private Objet[][] mapImage() {

        Objet[][] tabObjets = new Objet[25][51];

        Objet tmp2;
        int xobj = 0;
        int yobj = 0;

        for (int j = 0; j < 25; j++) {

            for (int i = 0; i < 51; i++) {


                if (level.getMap()[j][i] == '.') {
                    tmp2 = new Ground(xobj, yobj);

                } else if (level.getMap()[j][i] == '-') {
                    tmp2 = new Wall(xobj, yobj);

                } else if (level.getMap()[j][i] == 'X') {
                    tmp2 = new Roc(xobj, yobj);

                } else if (level.getMap()[j][i] == 'D') {
                    tmp2 = new Diamond(xobj, yobj);
                } else if (level.getMap()[j][i] == ' ') {

                    tmp2 = new Back(xobj, yobj);
                } else if (level.getMap()[j][i] == 'M') {
                    tmp2 = new Back(xobj, yobj);
                    tabMonsters.add(new Monster(xobj, yobj));
                } else {
                    tmp2 = new Ground(xobj, yobj);
                }
                tabObjets[j][i] = tmp2;
                xobj += 32;
            }
            xobj = 0;
            yobj += 32;
        }
        return tabObjets;

    }

    /**
     * @return diamondCount
     * @see ViewPanel
     */
    public int getDiamondCount() {
        return diamondCount;
    }

    /**
     * @param diamondCount the actual number of diamond
     * @see ViewPanel
     */

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    /**
     * @return exitable
     * @see ViewPanel
     */

    public boolean isExitable() {
        return exitable;
    }

    /**
     * @param exitable the new value of exitable
     * @see ViewPanel
     */

    public void setExitable(boolean exitable) {
        this.exitable = exitable;
    }

    /**
     * @return gameDuration
     * @see ViewPanel
     */

    public int getTimegame() {
        return gameDuration;
    }


    public ExitDoor getExit1() {
        return exit1;
    }

    public void setExit1(ExitDoor exit1) {
        this.exit1 = exit1;
    }
}
