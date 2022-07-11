package program.game.start;

import static program.game.start.GameUtil.getComputerBet;
import static program.game.start.GameUtil.*;

public class NumberGame {

    public static void main(String[] args) throws InterruptedException {
        start(new Health(5));
    }

    public static void start(Health health) throws InterruptedException {
        getBannerStyle();
        //Users::Input::Computers::Random
        System.out.println(PURPLE_BOLD_BRIGHT + "|> Random First Bet <|" + RESET);
        Thread.sleep(1500);
        int firstPick = (int) (Math.random() * 2) + 1;
        Thread.sleep(1000);

        if (firstPick == 1) {
            System.out.println(RED_BOLD_BRIGHT + "|> You're the First One Who Will Pick A Number <|" + RESET);
            getResult(health, true);
        }
        else if (firstPick == 2) {
            System.out.println(RED_BOLD_BRIGHT + "|> You're the Last One Who Will Pick A Number <|" + RESET);
            getResult(health, false);
        }
        //Conditionals::SeparatedMethods
    }

    public static void lose(Health health) throws InterruptedException {

        /* String Question for Loops */

        gameLose(true, health.remainingHealth() - 1);

        //Conditionals::userBet <-> computerBet
        if (getUserBet() > getComputerBet()) win(false, health); /* Win */

        if (getUserBet() < getComputerBet()) /* Lose */ {

            gameLose(true, health.remainingHealth() - 1);

            //Conditionals::userBet <-> computerBet
            if (getUserBet() > getComputerBet()) win(false, new Health(health.remainingHealth() + 1)); /* Win */

            if (getUserBet() < getComputerBet()) /* Lose */ {

                gameLose(true, health.remainingHealth() - 2);

                //Conditionals::userBet <-> computerBet
                if (getUserBet() > getComputerBet()) win(false, new Health(health.remainingHealth() + 1)); /* Win */

                if (getUserBet() < getComputerBet()) /* Lose */ {

                    gameLose(true, health.remainingHealth() - 3);

                    //Conditionals::userBet <-> computerBet
                    if (getUserBet() > getComputerBet()) win(false, new Health(health.remainingHealth() + 1)); /* Win */

                    if (getUserBet() < getComputerBet()) /* Lose */ {
                        System.out.println("\n" + RED_BOLD_BRIGHT + ">| Out Of Lives <|" + RESET);
                        getResponse(health);
                    }
                } else if (getUserBet() > getComputerBet()) win(false, new Health(health.remainingHealth() + 1)); /* Win */

            }
        }
        if (getComputerBet() == getComputerBet()) tie(false, health); /* Tie */
    }

}
