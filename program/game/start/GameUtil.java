package program.game.start;

import static program.game.start.NumberGame.lose;
import java.util.Random;

public class GameUtil extends Util {

    /**
     * Informs the user that he/she won.
     * @param playAgain if needed to input to play again.
     * @throws InterruptedException if interrupted at some point.
     */
    public static void win(boolean playAgain, Health health, boolean doesWonWhenLost) throws InterruptedException {

        System.out.println("\n" + RED_BOLD_BRIGHT + "  |> WIN! <|" + RESET);
        System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);
        //GameNotice

        System.out.println("\n" + WIN_TEXT[new Random().nextInt(WIN_TEXT.length)]);

        if (playAgain) getResponse(health, doesWonWhenLost);
    }

    /**
     * Informs the user that he/she lose, but continue the game.
     * @throws InterruptedException if interrupted at some point.
     */
    public static Health gameLose(boolean isLosing, int healthCount, boolean doesWonWhenLost) throws InterruptedException {
        Health health = new Health(healthCount);
        if (isLosing){
            System.out.println(RED_BOLD_BRIGHT + "  |> LOSE <|" + RESET);
            System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);

            //GameNotice
            System.out.println("\n" + LOSE_TEXT[new Random().nextInt(LOSE_TEXT.length)]);

            //Sleep::Continue::Game:Start
            Thread.sleep(new Random().nextInt(500) + 1);
            //Sleep::Continue::Game::End
        }
        else {
            System.out.println("\n" + RED_BOLD_BRIGHT + "                         |> LOSE <|" + RESET);
            System.out.println(RED_BOLD_BRIGHT + " |> Lifesaver is Here! you have another chance to win <|" + RESET);
            //Break::Continue
            NumberGame.start(new Health(healthCount), doesWonWhenLost);
        }
        return health;
    }

    public static void tie(boolean tryAgain, Health health, boolean doesWonWhenLost) throws InterruptedException {
        /* String Question for Loops */
        System.out.println("\n" + RED_BOLD_BRIGHT + "|> TIE SCORES <|" + RESET);
        System.out.println(RED_BOLD_BRIGHT + "|> HEALTH: " + health.remainingHealth() + " <|" + RESET);
        //GameNotice
        isOutOfLives(health);
        System.out.println("\n" + TIE_TEXT[new Random().nextInt(TIE_TEXT.length)]);
        if (tryAgain) getResponse(health, doesWonWhenLost);
        else getResult(health, false, doesWonWhenLost);
    }

    public static void getResponse(Health health, boolean doesWonWhenLost) throws InterruptedException {
        String response;
        do {
            System.out.print(RED_BOLD_BRIGHT + "|> [Y/N] Play Again?: " + RESET);
            response = INPUT.nextLine().trim();
            if (isYes.or(isNo).test(response)) {
                if (isYes.test(response)) NumberGame.start(new Health(health.remainingHealth()), doesWonWhenLost);
                else if (isNo.test(response)) exit();
                else System.out.println(RED_BOLD_BRIGHT + "PLEASE ENTER Y or N" + RESET);
            } else System.out.println(RED_BOLD_BRIGHT + "Y or N only" + RESET);
        } while (isLetter.and(isYes).and(isNo).negate().test(response));
    }

    public static void getResult(Health health, boolean isUserTheFirstOneToBet, boolean doesWonWhenLost) throws InterruptedException {
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

        if (userBet > computerBet) win(true, health, doesWonWhenLost);   /*  Win  */
        else if (userBet < computerBet) lose(doesWonWhenLost ? new Health(health.remainingHealth() - 1) : health);   /*  Lose */
        else tie(true, health, doesWonWhenLost);                         /*  Tie  */
    }

    public static int getComputerBet() throws InterruptedException {
        System.out.println(RED_BOLD_BRIGHT + "|> Please Wait, Computer is now picking <|" + RESET);
        Thread.sleep(new Random().nextInt(1000) + 1);
        return (int) (Math.random() * 999) + 1;
    }

    /** @noinspection BusyWait*/
    public static int getUserBet() throws InterruptedException {
        String temp;
        int bet = 0;
        do {
            System.out.println(RED_BOLD_BRIGHT + "|> Pick A Number <|" + RESET);
            Thread.sleep(new Random().nextInt(1000) + 1);
            System.out.print(CYAN_BOLD_BRIGHT + "|> Please Bet A Number: " + RESET);
            temp = INPUT.nextLine().trim();
            if (isNumber.test(temp)) bet = Integer.parseInt(temp);
            else System.out.println(RED_BOLD_BRIGHT + "PLEASE ENTER A VALID BET" + RESET);

        } while (isNumber.negate().test(temp));
        return bet;
    }

    public static void isOutOfLives(Health health) throws InterruptedException {
        if (health.remainingHealth() == 0) /* Lose */ {
            System.out.println("\n" + RED_BOLD_BRIGHT + ">| Out Of Lives <|" + RESET);
            getResponse(new Health(5), false);
        }
    }
}
