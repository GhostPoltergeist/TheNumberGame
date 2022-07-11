package program.game.start;

import static program.game.start.NumberGame.lose;
import java.util.Random;

public class GameUtil extends Util {

    /**
     * Informs the user that he/she won.
     * @param playAgain if needed to input to play again.
     * @throws InterruptedException if interrupted at some point.
     */
    public static void win(boolean playAgain, Health health) throws InterruptedException {

        System.out.println("\n" + RED_BOLD_BRIGHT + "  |> WIN! <|" + RESET);
        System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);
        //GameNotice

        System.out.println("\n" + WIN_TEXT[new Random().nextInt(WIN_TEXT.length)]);

        if (playAgain) getResponse(health);
    }

    /**
     * Informs the user that he/she lose, but continue the game.
     * @throws InterruptedException if interrupted at some point.
     */
    public static void gameLose(boolean isLosing, int healthCount) throws InterruptedException {
        if (isLosing){
            Health health = new Health(healthCount);
            System.out.println(RED_BOLD_BRIGHT + "  |> LOSE <|" + RESET);
            System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);

            //GameNotice
            System.out.println("\n" + LOSE_TEXT[new Random().nextInt(LOSE_TEXT.length)]);

            //Sleep::Continue::Game:Start
            Thread.sleep(500);
            //Sleep::Continue::Game::End
        }
        else {
            System.out.println("\n" + RED_BOLD_BRIGHT + "                         |> LOSE <|" + RESET);
            System.out.println(RED_BOLD_BRIGHT + " |> Lifesaver is Here! you have another chance to win <|" + RESET);
            //Break::Continue
            NumberGame.start(new Health(healthCount));
        }
    }

    public static void tie(boolean tryAgain, Health health) throws InterruptedException {
        /* String Question for Loops */
        System.out.println("\n" + RED_BOLD_BRIGHT + " |> TIE SCORES <|" + RESET);
        System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);
        //GameNotice

        System.out.println("\n" + TIE_TEXT[new Random().nextInt(TIE_TEXT.length)]);
        if (tryAgain) getResponse(health);
    }

    public static void getResponse(Health health) throws InterruptedException {
        System.out.print(RED_BOLD_BRIGHT + "|> [Y/N]Play Again?: " + RESET);
        String answer = INPUT.next();
        if (answer.matches("^[Y|y]$")) NumberGame.start(new Health(health.remainingHealth()));
        if (answer.matches("^[N|n]$")) System.exit(0);
    }

    public static void getResult(Health health, boolean isUserTheFirstOneToBet) throws InterruptedException {
        //Conditionals::userBet <-> computerBet
        int userBet;
        int computerBet;

        if (isUserTheFirstOneToBet) {
            userBet = getUserBet();
            computerBet = getComputerBet();
        }
        else {
            computerBet = getComputerBet();
            userBet = getUserBet();
        }

        if (userBet > computerBet) win(true, health);    /*  Win  */
        if (userBet < computerBet) lose(health);         /*  Lose */
        if (userBet == computerBet) tie(true, health);   /*  Tie  */
    }

    public static int getComputerBet() throws InterruptedException {
        System.out.println(RED_BOLD_BRIGHT + "|> Please Wait, Computer is now picking <|" + RESET);
        Thread.sleep(2000);
        int bet = (int) (Math.random() * 999) + 1;
        System.out.println("BET: " + bet);
        return bet;
    }

    public static int getUserBet() throws InterruptedException {
        System.out.println(RED_BOLD_BRIGHT + "|> Pick A Number <|" + RESET);
        Thread.sleep(1500);
        System.out.print(CYAN_BOLD_BRIGHT + "|> Please Bet A Number: " + RESET);
        return (INPUT.nextInt());
    }
}
