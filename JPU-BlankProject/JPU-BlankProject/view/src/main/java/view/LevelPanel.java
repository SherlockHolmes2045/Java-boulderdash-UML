package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

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

public class LevelPanel extends JPanel implements Observer {

    /**
     * The Constant serialVersionUID
     */
    @Serial
    private static final long serialVersionUID = 556761802292369776L;

    private Level level;
    private Objet[][] tabObjets;
    private ExitDoor exit;
    private int diamondCount;
    private int exitableDiamond;
    private Dash dash;
    private int gameDuration;
    int xStart = 0;
    int yStart = 0;
    private int deathCount;
    private boolean exitable;
    private final Random r = new Random();

    private List<Monster> tabMonsters = new ArrayList<>();

    private static final int PAUSE = 3;


    public LevelPanel(Level level, int exitableDiamond, ExitDoor exit, Dash dash, int gameDuration) {
        this.level = level;
        tabObjets = this.mapImage();
        this.setGameDuration(gameDuration);
        this.diamondCount = this.getLevelDiamonds();
        this.exitableDiamond = exitableDiamond;
        this.dash = dash;
        deathCount = 0;
        setExit1(exit);

        this.exitable = false;

        startGameTime();

        startMonsterCollisionTask();

        startMonsterMovementTask();

        startDiamondFallTask();

        startRocFallTask();

        Thread refresh = new Thread(new Refresh(PAUSE, this));
        refresh.start();
    }

    private int getLevelDiamonds() {
        int levelDiamonds = 0;
        for (int i = 0; i < 24; i++) {

            for (int j = 0; j < 51; j++) {
                if (tabObjets[i][j] instanceof model.Diamond) {
                    levelDiamonds++;
                }
            }
        }
        return levelDiamonds;
    }

    private void startGameTime() {
        //timer to handle the gametime
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (getGameDuration() > 0) {
                    setGameDuration(getGameDuration() - 1);
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
    }

    private void startMonsterCollisionTask() {
        //timer for collision between monster and hero
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                for (Monster tabMonster : getTabMonsters()) {
                    if (dash.getX() == tabMonster.getX() && dash.getY() == tabMonster.getY()) {
                        dash.setDeath(true);
                    }
                }
            }
        };
        time.schedule(task, 10, 100);
    }


    private void startRocFallTask() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (getTabObjets()[i][j] instanceof model.Roc) {

                            if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j + 1] instanceof model.Back && getTabObjets()[i + 1][j + 1] instanceof model.Back) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j + 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j + 1].setX(getTabObjets()[i][j].getX() + 32);
                            } else if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j - 1] instanceof model.Back && getTabObjets()[i + 1][j - 1] instanceof model.Back) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j - 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j - 1].setX(getTabObjets()[i][j].getX() - 32);
                            }
                        }
                    }
                }
            }
        };
        time.schedule(task, 10, 200);
    }

    private void startDiamondFallTask() {

        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (getTabObjets()[i][j] instanceof model.Diamond) {

                            if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j + 1] instanceof model.Back && getTabObjets()[i + 1][j + 1] instanceof model.Back) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j + 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j + 1].setX(getTabObjets()[i][j].getX() + 32);
                            } else if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j - 1] instanceof model.Back && getTabObjets()[i + 1][j - 1] instanceof model.Back) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j - 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j - 1].setX(getTabObjets()[i][j].getX() - 32);
                            }
                        }

                    }
                }
            }
        };
        time.schedule(task, 10, 200);
    }

    private void startMonsterMovementTask() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                int nb = r.nextInt(4);
                for (Monster tabMonster : getTabMonsters()) {

                    if (!tabMonster.getWalks()) {

                        for (int i = 0; i < 24; i++) {
                            for (int j = 0; j < 51; j++) {

                                if (nb == 0) {

                                    if (tabMonster.movesRight(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesLeft(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesUp(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesDown(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else if (nb == 1) {

                                    if (tabMonster.movesLeft(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesRight(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesUp(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesDown(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else if (nb == 2) {

                                    if (tabMonster.movesUp(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesLeft(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesRight(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    } else if (tabMonster.movesDown(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    }

                                } else {

                                    if (tabMonster.movesDown(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesDown(true);
                                    } else if (tabMonster.movesLeft(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesLeft(true);
                                    } else if (tabMonster.movesUp(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesUp(true);
                                    } else if (tabMonster.movesRight(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(true);
                                        tabMonster.setGoesRight(true);
                                    }

                                }

                            }

                        }
                    } else {
                        for (int i = 0; i < 24; i++) {

                            for (int j = 0; j < 51; j++) {

                                if (getTabObjets()[i][j] != null) {

                                    if (tabMonster.isGoesRight()) {

                                        if (tabMonster.doesNotMoveRight(getTabObjets()[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesRight(false);
                                        }
                                    } else if (tabMonster.isGoesLeft()) {
                                        if (tabMonster.doesNotMoveLeft(getTabObjets()[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesLeft(false);
                                        }
                                    } else if (tabMonster.isGoesUp()) {
                                        if (tabMonster.doesNotMoveUp(getTabObjets()[i][j])) {
                                            tabMonster.setWalks(false);
                                            tabMonster.setGoesUp(false);
                                        }
                                    } else if (tabMonster.isGoesDown() && tabMonster.doesNotMoveDown(getTabObjets()[i][j])) {
                                        tabMonster.setWalks(false);
                                        tabMonster.setGoesDown(false);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        };
        time.schedule(task, 300, 100);
    }

    /**
     * @param o   observable
     * @param arg object
     */

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 51; j++) {
                if (getTabObjets()[i][j] instanceof model.Roc) {

                    getTabObjets()[i][j].setPushableRight(getTabObjets()[i][j].rightContact(getTabObjets()[i][j + 1]));
                    getTabObjets()[i][j].setPushableLeft(getTabObjets()[i][j].leftContact(getTabObjets()[i][j - 1]));

                }

            }
        }

        for (int i = 0; i < 24; i++) {

            for (int j = 0; j < 51; j++) {

                if (getTabObjets()[i][j] instanceof model.Roc || getTabObjets()[i][j] instanceof model.Diamond) {

                    if (getTabObjets()[i][j].nearDown(getTabObjets()[i + 1][j]) && !getTabObjets()[i][j].downContactDash(getDash())) {
                        int x = getTabObjets()[i][j].getX();
                        int y = getTabObjets()[i][j].getY();
                        getTabObjets()[i][j].setFalling(true);
                        getTabObjets()[i + 1][j] = getTabObjets()[i][j];
                        getTabObjets()[i][j] = new Back(x, y);
                        getTabObjets()[i + 1][j].setY(getTabObjets()[i + 1][j].getY() + 32);
                        getTabObjets()[i + 1][j].setVelocity(getTabObjets()[i + 1][j].getVelocity() + 1);
                    } else {
                        getTabObjets()[i][j].setFalling(false);
                        getTabObjets()[i][j].setVelocity(0);
                    }
                }
                assert getTabObjets()[i][j] != null;
                g2.drawImage(getTabObjets()[i][j].getImgObj(), getTabObjets()[i][j].getX(), getTabObjets()[i][j].getY(), null);
            }
        }


        for (Monster tabMonster : getTabMonsters()) {
            g2.drawImage(tabMonster.getImgChar(), tabMonster.getX(), tabMonster.getY(), null);

        }

        if (diamondCount <= exitableDiamond) {
            this.exitable = true;
            for (int i = 0; i < 24; i++) {

                for (int j = 0; j < 51; j++) {
                    if (getTabObjets()[i][j].getX() == this.exit.getX() && getTabObjets()[i][j].getY() == this.exit.getY()) {
                        tabObjets[i][j] = this.exit;
                    }

                }
            }
            //g2.drawImage(getExit1().getImgObj(), getExit1().getX(), getExit1().getY(), null);
        }

        if (!getDash().getDeath() && !getDash().isRest()) {
            g2.drawImage(getDash().imageWalk(50), getDash().getX(), getDash().getY(), null);
        } else if (getDash().isRest() && !getDash().getDeath()) {
            g2.drawImage(getDash().getImgChar(), getDash().getX(), getDash().getY(), null);
        } else if (getDash().getDeath()) {
            if (deathCount == 0) {
                xStart = getDash().getX();
                yStart = getDash().getY();
            }
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart, yStart - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart - 64, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart, yStart - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart - 32, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart - 32, yStart, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xStart + 32, yStart, null);
            g2.drawImage(getDash().getImgChar(), getDash().getX(), getDash().getY(), null);
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
        g2.drawString(Integer.toString(getDash().getScore()), 30, 22);
        g2.drawString(Integer.toString(getGameDuration()), 125, 57);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/diam_icon.png"))).getImage(), 105, 8, null);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/horloge_icon.png"))).getImage(), 105, 40, null);

    }

    /**
     * @return tabObjets
     */
    private Objet[][] mapImage() {

        Objet[][] mapObjects = new Objet[25][51];

        Objet tmp2;
        int xobj = 0;
        int yobj = 0;

        for (int j = 0; j < 25; j++) {

            for (int i = 0; i < 51; i++) {


                if (getLevel().getMap()[j][i] == '.') {
                    tmp2 = new Ground(xobj, yobj);

                } else if (getLevel().getMap()[j][i] == '-') {
                    tmp2 = new Wall(xobj, yobj);

                } else if (getLevel().getMap()[j][i] == 'X') {
                    tmp2 = new Roc(xobj, yobj);

                } else if (getLevel().getMap()[j][i] == 'D') {
                    tmp2 = new Diamond(xobj, yobj);
                } else if (getLevel().getMap()[j][i] == ' ') {

                    tmp2 = new Back(xobj, yobj);
                } else if (getLevel().getMap()[j][i] == 'M') {
                    tmp2 = new Back(xobj, yobj);
                    getTabMonsters().add(new Monster(xobj, yobj));
                } else {
                    tmp2 = new Ground(xobj, yobj);
                }
                mapObjects[j][i] = tmp2;
                xobj += 32;
            }
            xobj = 0;
            yobj += 32;
        }
        return mapObjects;

    }

    /**
     * @return diamondCount
     */
    public int getDiamondCount() {
        return diamondCount;
    }

    /**
     * @param diamondCount the actual number of diamond
     */

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    /**
     * @return exitable
     */

    public boolean isExitable() {
        return exitable;
    }

    /**
     * @param exitable the new value of exitable
     */

    public void setExitable(boolean exitable) {
        this.exitable = exitable;
    }

    /**
     * @return gameDuration
     */

    public int getTimegame() {
        return getGameDuration();
    }


    public ExitDoor getExit() {
        return exit;
    }

    public void setExit1(ExitDoor exit) {
        this.exit = exit;
    }

    public Dash getDash() {
        return dash;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    /**
     * Get panel current level
     */
    public Level getLevel() {
        return level;
    }

    public Objet[][] getTabObjets() {
        return tabObjets;
    }

    /**
     * Arraylist of monsters
     */
    public List<Monster> getTabMonsters() {
        return tabMonsters;
    }
}
