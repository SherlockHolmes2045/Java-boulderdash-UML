package view;

import java.util.Timer;
import java.util.TimerTask;

public class MoveMonster /*implements Runnable*/ {

    /*@Override*/
    public MoveMonster() {

        Timer time = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                for (int k = 0; k < ViewPanel2.tabMonsters.size(); k++) {

                    if (ViewPanel2.tabMonsters.get(k).getWalks() == false) {
                        //	System.out.println("nope");
                        for (int i = 0; i < 24; i++) {

                            for (int j = 0; j < 51; j++) {

                                if (ViewPanel2.tabObjets[i][j] != null) {

                                    if (ViewPanel2.tabMonsters.get(k).movesRight(ViewPanel2.tabObjets[i][j])) {
                                        ViewPanel2.tabMonsters.get(k).setWalks(true);
                                        ViewPanel2.tabMonsters.get(k).setGoesRight(true);
                                    } else if (ViewPanel2.tabMonsters.get(k).movesLeft(ViewPanel2.tabObjets[i][j])) {
                                        ViewPanel2.tabMonsters.get(k).setWalks(true);
                                        ViewPanel2.tabMonsters.get(k).setGoesLeft(true);
                                    } else if (ViewPanel2.tabMonsters.get(k).movesUp(ViewPanel2.tabObjets[i][j])) {
                                        ViewPanel2.tabMonsters.get(k).setWalks(true);
                                        ViewPanel2.tabMonsters.get(k).setGoesUp(true);
                                    } else if (ViewPanel2.tabMonsters.get(k).movesDown(ViewPanel2.tabObjets[i][j])) {
                                        ViewPanel2.tabMonsters.get(k).setWalks(true);
                                        ViewPanel2.tabMonsters.get(k).setGoesDown(true);
                                    }

                                }
                            }

                        }
                    } else {
                        //System.out.println("dacc");
                        for (int i = 0; i < 24; i++) {

                            for (int j = 0; j < 51; j++) {

                                if (ViewPanel2.tabObjets[i][j] != null) {

                                    if (ViewPanel2.tabMonsters.get(k).isGoesRight()) {

                                        if (ViewPanel2.tabMonsters.get(k).doesNotMoveRight(ViewPanel2.tabObjets[i][j])) {
                                            ViewPanel2.tabMonsters.get(k).setWalks(false);
                                            ViewPanel2.tabMonsters.get(k).setGoesRight(false);
                                        }
                                    } else if (ViewPanel2.tabMonsters.get(k).isGoesLeft()) {
                                        if (ViewPanel2.tabMonsters.get(k).doesNotMoveLeft(ViewPanel2.tabObjets[i][j])) {
                                            ViewPanel2.tabMonsters.get(k).setWalks(false);
                                            ViewPanel2.tabMonsters.get(k).setGoesLeft(false);
                                        }
                                    } else if (ViewPanel2.tabMonsters.get(k).isGoesUp()) {
                                        if (ViewPanel2.tabMonsters.get(k).doesNotMoveUp(ViewPanel2.tabObjets[i][j])) {
                                            ViewPanel2.tabMonsters.get(k).setWalks(false);
                                            ViewPanel2.tabMonsters.get(k).setGoesUp(false);
                                        }
                                    } else if (ViewPanel2.tabMonsters.get(k).isGoesDown()) {
                                        if (ViewPanel2.tabMonsters.get(k).doesNotMoveDown(ViewPanel2.tabObjets[i][j])) {
                                            ViewPanel2.tabMonsters.get(k).setWalks(false);
                                            ViewPanel2.tabMonsters.get(k).setGoesDown(false);
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
