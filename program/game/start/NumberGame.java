package program.game.start;

import java.util.Random;

import static program.game.start.GameUtil.getComputerBet;
import static program.game.start.GameUtil.*;

public class NumberGame {

    public static void main(String[] args) throws InterruptedException {
        start(new Health(5), false);
    }

    public static void start(Health health, boolean doesWonWhenLost) throws InterruptedException {
        getBannerStyle();
        //Users::Input::Computers::Random
        System.out.println(PURPLE_BOLD_BRIGHT + "|> Random First Bet <|" + RESET);
        Thread.sleep(new Random().nextInt(1000) + 1);
        int firstPick = (int) (Math.random() * 2) + 1;
        Thread.sleep(new Random().nextInt(500) + 1);

        if (firstPick == 1) {
            System.out.println(RED_BOLD_BRIGHT + "|> You're the First One Who Will Pick A Number <|" + RESET);
            getResult(doesWonWhenLost && health.remainingHealth() < 5 ? new Health(health.remainingHealth() + 1) : health, true, doesWonWhenLost);
        }
        else if (firstPick == 2) {
            System.out.println(RED_BOLD_BRIGHT + "|> You're the Last One Who Will Pick A Number <|" + RESET);
            getResult(doesWonWhenLost && health.remainingHealth() < 5 ? new Health(health.remainingHealth() + 1) : health, false, doesWonWhenLost);
        }
        //Conditionals::SeparatedMethods
    }

    public static void lose(Health health) throws InterruptedException {

        health = gameLose(true, health.remainingHealth() - 1, false);
        isOutOfLives(health);
        int computerBet = getComputerBet();
        int userBet = getUserBet();

        //Conditionals::userBet <-> computerBet
        if (userBet > computerBet) win(true, new Health(health.remainingHealth() + 1), true); /* Win */
        else if (userBet < computerBet)  { /* Lose */
            health = gameLose(true, health.remainingHealth() - 1, false);
            isOutOfLives(health);
            computerBet = getComputerBet();
            userBet = getUserBet();

            //Conditionals::userBet <-> computerBet
            if (userBet > computerBet) win(true, new Health(health.remainingHealth() + 1), true); /* Win */
            else if (userBet < computerBet) { /* Lose */

                health = gameLose(true, health.remainingHealth() - 1, false);
                isOutOfLives(health);
                computerBet = getComputerBet();
                userBet = getUserBet();

                //Conditionals::userBet <-> computerBet
                if (userBet > computerBet) win(true, new Health(health.remainingHealth() + 1), true); /* Win */
                else if (userBet< computerBet) /* Lose */ {

                    health = gameLose(true, health.remainingHealth() - 1, false);
                    computerBet = getComputerBet();
                    userBet = getUserBet();

                    //Conditionals::userBet <-> computerBet
                    if (userBet > computerBet) win(true, new Health(health.remainingHealth() + 1), true); /* Win */
                    else if (userBet < computerBet) {
                        health = gameLose(true, health.remainingHealth() - 1, false);
                        isOutOfLives(health);
                    }
                }
                if (userBet == computerBet) tie(false, health, false); /* Tie */
            }
            if (userBet == computerBet) tie(false, health, false); /* Tie */
        }
        if (userBet == computerBet) tie(false, health, false); /* Tie */
    }

}
