package view;

import model.Monster;
import model.Objet;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MoveMonster /*implements Runnable*/ {

    /*@Override*/
    public MoveMonster() {

        Timer time = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                int currentLevel = View.viewFrame.getLevelCounter();
                LevelPanel panel = ViewFrame.panels.stream().filter(p -> p.getLevel().getLevelNumber() == currentLevel).findFirst().orElse(ViewFrame.panels.get(0));
                List<Monster> tabMonsters = panel.getTabMonsters();
                Objet[][] tabObjets = panel.getTabObjets();
                for (Monster tabMonster : tabMonsters) {

                    if (!tabMonster.getWalks()) {
                        for (int i = 0; i < 24; i++) {

                            for (int j = 0; j < 51; j++) {

                                if (tabObjets[i][j] != null) {

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

                                }
                            }

                        }
                    } else {
                        //System.out.println("dacc");
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
        time.schedule(task, 10, 100);
    }

}
