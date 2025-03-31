package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import model.*;

/**
 * Date:02-06-2019
 * The Class ViewPanel2.
 *
 * @author Lemovou Ivan
 */

public class LevelPanel extends JPanel implements Observer, Serializable {

    /**
     * The Constant serialVersionUID
     */
    @Serial
    private static final long serialVersionUID = 556761802292369776L;

    private final Level level;
    private Objet[][] tabObjets;
    private ExitDoor exit;
    private int diamondCount;
    private final int exitableDiamond;
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

        startDiamondSlideTask();

        startRocSlideTask();

        rockFallingTask();

        Thread refresh = new Thread(new Refresh(PAUSE, this));
        refresh.start();
    }

    private int getLevelDiamonds() {
        int levelDiamonds = 0;
        for (int i = 0; i < GameConstants.COLUMN; i++) {

            for (int j = 0; j < GameConstants.ROW; j++) {
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
                    dash.setDead(true);
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
                        dash.setDead(true);
                    }
                }
            }
        };
        time.schedule(task, 10, 100);
    }


    private void startRocSlideTask() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < GameConstants.COLUMN; i++) {

                    for (int j = 0; j < GameConstants.ROW; j++) {
                        if (getTabObjets()[i][j] instanceof model.Roc) {

                            if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j + 1] instanceof model.Back && getTabObjets()[i + 1][j + 1] instanceof model.Back && !isDashBlockingSlideRight(getTabObjets()[i][j])) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j + 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j + 1].setX(getTabObjets()[i][j].getX() + GameConstants.PIXEL_SIZE);
                            } else if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j - 1] instanceof model.Back && getTabObjets()[i + 1][j - 1] instanceof model.Back && !isDashBlockingSlideLeft(getTabObjets()[i][j])) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j - 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j - 1].setX(getTabObjets()[i][j].getX() - GameConstants.PIXEL_SIZE);
                            }
                        }
                    }
                }
            }
        };
        time.schedule(task, 10, 200);
    }

    private boolean isDashBlockingSlideRight(Objet objet) {
        return (objet.getX() == dash.getX() - GameConstants.PIXEL_SIZE && objet.getY() == dash.getY()) || (objet.getX() == dash.getX() - GameConstants.PIXEL_SIZE && objet.getY() == dash.getY() - GameConstants.PIXEL_SIZE);
    }

    private boolean isDashBlockingSlideLeft(Objet objet) {
        return (objet.getX() == dash.getX() + GameConstants.PIXEL_SIZE && objet.getY() == dash.getY()) || (objet.getX() == dash.getX() + GameConstants.PIXEL_SIZE && objet.getY() == dash.getY() - GameConstants.PIXEL_SIZE);
    }

    private void startDiamondSlideTask() {

        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                for (int i = 0; i < GameConstants.COLUMN; i++) {

                    for (int j = 0; j < GameConstants.ROW; j++) {
                        if (getTabObjets()[i][j] instanceof model.Diamond) {

                            if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j + 1] instanceof model.Back && getTabObjets()[i + 1][j + 1] instanceof model.Back && !isDashBlockingSlideRight(getTabObjets()[i][j])) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j + 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j + 1].setX(getTabObjets()[i][j].getX() + GameConstants.PIXEL_SIZE);
                            } else if ((getTabObjets()[i + 1][j] instanceof model.Roc || getTabObjets()[i + 1][j] instanceof model.Diamond) && getTabObjets()[i][j - 1] instanceof model.Back && getTabObjets()[i + 1][j - 1] instanceof model.Back && !isDashBlockingSlideLeft(getTabObjets()[i][j])) {
                                int x = getTabObjets()[i][j].getX();
                                int y = getTabObjets()[i][j].getY();
                                getTabObjets()[i][j - 1] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(x, y);
                                getTabObjets()[i][j - 1].setX(getTabObjets()[i][j].getX() - GameConstants.PIXEL_SIZE);
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
                for (Monster monster : getTabMonsters()) {
                    // Reset monster movement if it can't continue in current direction
                    if (monster.getWalks() && isBlocked(monster)) {
                            monster.setWalks(false);
                            continue;
                        }


                    // If monster is not walking, try to start moving
                    if (!monster.getWalks()) {
                        moveMonsterRandomly(monster);
                    }
                }
            }
        };
        time.schedule(task, 300, 300); // Adjusted timing
    }

    private boolean isBlocked(Monster monster) {
        for (int i = 0; i < getTabObjets().length; i++) {
            for (int j = 0; j < getTabObjets()[i].length; j++) {
                Objet obj = getTabObjets()[i][j];

                if (monster.isGoesRight() && monster.doesNotMoveRight(obj)) return true;
                if (monster.isGoesLeft() && monster.doesNotMoveLeft(obj)) return true;
                if (monster.isGoesUp() && monster.doesNotMoveUp(obj)) return true;
                if (monster.isGoesDown() && monster.doesNotMoveDown(obj)) return true;
            }
        }
        return false;
    }

    private void moveMonsterRandomly(Monster monster) {
        List<Direction> possibleDirections = new ArrayList<>();

        // Check possible movement directions
        for (int i = 0; i < getTabObjets().length; i++) {
            for (int j = 0; j < getTabObjets()[i].length; j++) {
                Objet obj = getTabObjets()[i][j];

                if (monster.canMoveRight(obj)) possibleDirections.add(Direction.RIGHT);
                if (monster.canMoveLeft(obj)) possibleDirections.add(Direction.LEFT);
                if (monster.canMoveUp(obj)) possibleDirections.add(Direction.UP);
                if (monster.canMoveDown(obj)) possibleDirections.add(Direction.DOWN);
            }
        }

        // If directions are available, choose randomly
        if (!possibleDirections.isEmpty()) {
            Direction randomDirection = possibleDirections.get(new Random().nextInt(possibleDirections.size()));

            monster.setWalks(true);
            switch (randomDirection) {
                case RIGHT:
                    monster.setGoesRight(true);
                    break;
                case LEFT:
                    monster.setGoesLeft(true);
                    break;
                case UP:
                    monster.setGoesUp(true);
                    break;
                case DOWN:
                    monster.setGoesDown(true);
                    break;
            }
        }
    }

    private enum Direction {
        RIGHT, LEFT, UP, DOWN
    }

    private void rockFallingTask() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < GameConstants.COLUMN; i++) {

                    for (int j = 0; j < GameConstants.ROW; j++) {

                        if (getTabObjets()[i][j] instanceof model.Roc || getTabObjets()[i][j] instanceof model.Diamond) {

                            if (getTabObjets()[i][j].nearDown(getTabObjets()[i + 1][j]) && !getTabObjets()[i][j].downContactDash(getDash())) {
                                getTabObjets()[i][j].setFalling(true);
                                getTabObjets()[i + 1][j] = getTabObjets()[i][j];
                                getTabObjets()[i][j] = new Back(getTabObjets()[i][j].getX(), getTabObjets()[i][j].getY());
                                getTabObjets()[i + 1][j].setY(getTabObjets()[i + 1][j].getY() + GameConstants.PIXEL_SIZE);
                                getTabObjets()[i + 1][j].setVelocity(getTabObjets()[i + 1][j].getVelocity() + 1);
                            } else {
                                getTabObjets()[i][j].setFalling(false);
                                getTabObjets()[i][j].setVelocity(0);
                            }
                        }
                    }
                }
                repaint();
            }
        };
        time.schedule(task, 300, 500);
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


        for (int i = 0; i < GameConstants.COLUMN; i++) {

            for (int j = 0; j < GameConstants.ROW; j++) {
                if (getTabObjets()[i][j] instanceof model.Roc) {

                    getTabObjets()[i][j].setPushableRight(getTabObjets()[i][j].rightContact(getTabObjets()[i][j + 1]));
                    getTabObjets()[i][j].setPushableLeft(getTabObjets()[i][j].leftContact(getTabObjets()[i][j - 1]));

                }

                g2.drawImage(getTabObjets()[i][j].getImgObj(), getTabObjets()[i][j].getX(), getTabObjets()[i][j].getY(), null);
            }
        }


        for (Monster tabMonster : getTabMonsters()) {
            g2.drawImage(tabMonster.getImgChar(), tabMonster.getX(), tabMonster.getY(), null);

        }

        if (diamondCount <= exitableDiamond) {
            this.exitable = true;
            for (int i = 0; i < GameConstants.COLUMN; i++) {
                for (int j = 0; j < GameConstants.ROW; j++) {
                    if (getTabObjets()[i][j].getX() == this.exit.getX() && getTabObjets()[i][j].getY() == this.exit.getY()) {
                        tabObjets[i][j] = this.exit;
                    }
                }
            }
        }

        if (!getDash().isDead() && !getDash().isRest()) {
            g2.drawImage(getDash().imageWalk(50), getDash().getX(), getDash().getY(), null);
        } else if (getDash().isRest() && !getDash().isDead()) {
            g2.drawImage(getDash().getImgChar(), getDash().getX(), getDash().getY(), null);
        } else if (getDash().isDead()) {
            if (deathCount == 0) {
                xStart = getDash().getX();
                yStart = getDash().getY();
            }
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart - GameConstants.PIXEL_SIZE, yStart - GameConstants.PIXEL_SIZE * 2, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart, yStart - GameConstants.PIXEL_SIZE * 2, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart + GameConstants.PIXEL_SIZE, yStart - GameConstants.PIXEL_SIZE * 2, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart - GameConstants.PIXEL_SIZE, yStart - GameConstants.PIXEL_SIZE, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart, yStart - GameConstants.PIXEL_SIZE, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart + GameConstants.PIXEL_SIZE, yStart - GameConstants.PIXEL_SIZE, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart - GameConstants.PIXEL_SIZE, yStart, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.STAR_IMAGE))).getImage(), xStart + GameConstants.PIXEL_SIZE, yStart, null);
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
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.DIAMOND_ICON))).getImage(), 105, 8, null);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.HORLOGE_ICON))).getImage(), 105, 40, null);

    }

    /**
     * @return tabObjets
     */
    private Objet[][] mapImage() {

        Objet[][] mapObjects = new Objet[25][GameConstants.ROW];

        Objet tmp2;
        int xobj = 0;
        int yobj = 0;

        for (int j = 0; j < 25; j++) {

            for (int i = 0; i < GameConstants.ROW; i++) {


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
                xobj += GameConstants.PIXEL_SIZE;
            }
            xobj = 0;
            yobj += GameConstants.PIXEL_SIZE;
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
