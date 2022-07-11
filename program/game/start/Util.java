package program.game.start;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Util {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    public static final Scanner INPUT = new Scanner(System.in);

    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN

    public static final String[] WIN_TEXT = {
            GREEN_BOLD_BRIGHT + "|> Computer: I only want to see whether you will let me win this game, or beat it." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You win your battles or I'll destroy you!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: It is not difficult to capture a fortress but it is difficult to win a RandomGame." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: What did you win in your deal about me?" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You really want to win this bet, don't you? haha Congrats!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Harold is the one who created me, he say's that you temporarily win this game" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: After you beat me and win the game, there's no way you can fire me again." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You thinking you're gonna win this game, haha you're right" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You know you can't win a battle without me. you against AI, stupid" + RESET};

    public static final String[] LOSE_TEXT = {
            GREEN_BOLD_BRIGHT + "|> Computer: It seems weird, you totally feel like the loser." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Obnoxious loser!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: The game participants take turns spinning the bottle and the loser? has to kiss the ghoul in front of everyone else." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Think you know your Biggest Loser trivia?" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: you're was The Biggest Loser in season." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Harold is the one who created me, he say's that you temporarily lose this game" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: The Biggest Loser has been around since 2022." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You thinking you're gonna win this game, not today stupid!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Jillian Michael's has appeared on numerous talk shows to promote both The Biggest Loser and maybe it's you. :)" + RESET};

    public static final String[] TIE_TEXT = {
            GREEN_BOLD_BRIGHT + "|> Computer: dead-heat, TIE" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You win your battles or I'll destroy you!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: It is not difficult to capture a fortress but it is difficult to win a RandomGame." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: What did you win in your deal about me?" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You really want to win this bet, don't you? haha Congrats!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: Harold is the one who created me, he say's that you temporarily win this game" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: After you beat me and win the game, there's no way you can fire me again." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You thinking you're gonna win this game, haha you're right" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You know you can't win a battle without me. you against AI, stupid" + RESET};

    public static void getBannerStyle() throws InterruptedException {
        //Banner::Change::Feature
        System.out.println();
        System.out.println();
        System.out.println(GREEN_BOLD_BRIGHT + "═══════════════════════════════╗" + RESET);
        System.out.println(YELLOW_BOLD_BRIGHT + "═══════════════════════╗       ║" + RESET);
        System.out.println(PURPLE_BOLD_BRIGHT + "═══════════════════════║═══════║════════════════════════The Number Game════════════════════════════════════════════|>" + RESET);
        System.out.println(RED_BOLD_BRIGHT + "═════|> PLEASE WAIT. <|" + RESET);
        int banner = (int) (Math.random() * 5) + 1;
        Thread.sleep(new Random().nextInt(500) + 1);
        if (banner == 1) {
            String art = CYAN_BOLD_BRIGHT + """
                             ███╗   ██╗██╗   ██╗███╗   ███╗██████╗ ███████╗██████╗
                             ████╗  ██║██║   ██║████╗ ████║██╔══██╗██╔════╝██╔══██╗
                             ██╔██╗ ██║██║   ██║██╔████╔██║██████╔╝█████╗  ██████╔╝
                             ██║╚██╗██║██║   ██║██║╚██╔╝██║██╔══██╗██╔══╝  ██╔══██╗
                             ██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██████╔╝███████╗██║  ██║
                            ╔══╝ ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═════╝ ╚══════╝╚═╝   ╚═╝
                            ╚══╗         ██████╗  █████╗ ███╗   ███╗███████╗
                               ║        ██╔════╝ ██╔══██╗████╗ ████║██╔════╝
                               ║        ██║  ███╗███████║██╔████╔██║█████╗
                               ║        ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝     ╔> Ng-NumberGame // GetReadyToPlay
                               ║        ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗   ║
                               ║         ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝   ║
                               ║ ╔═══════> Bring Your Ideas Into Reality ══════╝
                               ╚═╝
                                                                                                                                             		
                    """ + RESET;
            printArt(art);
        } else if (banner == 2) {
            String art = GREEN_BOLD_BRIGHT + """
                     ▐ ▄ ▄• ▄▌• ▌ ▄ ·. ▄▄▄▄· ▄▄▄ .▄▄▄
                    •█▌▐██▪██▌·██ ▐███▪▐█ ▀█▪▀▄.▀·▀▄ █·
                    ▐█▐▐▌█▌▐█▌▐█ ▌▐▌▐█·▐█▀▀█▄▐▀▀▪▄▐▀▀▄
                    ██▐█▌▐█▄█▌██ ██▌▐█▌██▄▪▐█▐█▄▄▌▐█•█▌
                    ▀▀ █▪ ▀▀▀ ▀▀  █▪▀▀▀·▀▀▀▀  ▀▀▀ .▀  ▀
                         ▄▄ •  ▄▄▄· • ▌ ▄ ·. ▄▄▄ .
                        ▐█ ▀ ▪▐█ ▀█ ·██ ▐███▪▀▄.▀·    Bring Your Ideas Into Reality
                        ▄█ ▀█▄▄█▀▀█ ▐█ ▌▐▌▐█·▐▀▀▪▄
                        ▐█▄▪▐█▐█ ▪▐▌██ ██▌▐█▌▐█▄▄▌
                        ·▀▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀ ▀▀▀
                    """ + RESET;
            printArt(art);
        } else if (banner == 3) {
            String art = RED_BOLD_BRIGHT + """
                    888b    888                        888                             .d8888b.         d8888 888b     d888 8888888888
                    8888b   888                        888                            d88P  Y88b       d88888 8888b   d8888 888
                    88888b  888                        888                            888    888      d88P888 88888b.d88888 888
                    888Y88b 888 888  888 88888b.d88b.  88888b.   .d88b.  888d888      888            d88P 888 888Y88888P888 8888888
                    888 Y88b888 888  888 888 "888 "88b 888 "88b d8P  Y8b 888P"        888  88888    d88P  888 888 Y888P 888 888
                    888  Y88888 888  888 888  888  888 888  888 88888888 888          888    888   d88P   888 888  Y8P  888 888
                    888   Y8888 Y88b 888 888  888  888 888 d88P Y8b.     888          Y88b  d88P  d8888888888 888   "   888 888
                    888    Y888  "Y88888 888  888  888 88888P"   "Y8888  888           "Y8888P88 d88P     888 888       888 8888888888
                            
                    """ + RESET;
            printArt(art);
        } else if (banner == 4) {
            String art = BLUE_BOLD_BRIGHT + """
                       ▄     ▄   █▀▄▀█ ███   ▄███▄   █▄▄▄▄       ▄▀  ██   █▀▄▀█ ▄███▄
                        █     █  █ █ █ █  █  █▀   ▀  █  ▄▀     ▄▀    █ █  █ █ █ █▀   ▀
                    ██   █ █   █ █ ▄ █ █ ▀ ▄ ██▄▄    █▀▀▌      █ ▀▄  █▄▄█ █ ▄ █ ██▄▄
                    █ █  █ █   █ █   █ █  ▄▀ █▄   ▄▀ █  █      █   █ █  █ █   █ █▄   ▄▀
                    █  █ █ █▄ ▄█    █  ███   ▀███▀     █        ███     █    █  ▀███▀
                    █   ██  ▀▀▀    ▀                  ▀                █    ▀
                                   Bring Your Ideas Into Reality      ▀
                                                                                                         
                    """ + RESET;
            printArt(art);
        } else if (banner == 5) {
            String art = PURPLE_BOLD_BRIGHT + """
                           .______  .____     ._____.___ ._______ ._______.______       ._____  .______  ._____.___ ._______
                           :      \\ |    |___ :         |: __   / : .____/: __   \\      :_ ___\\ :      \\ :         |: .____/
                           |       ||    |   ||   \\  /  ||  |>  \\ | : _/\\ |  \\____|     |   |___|   .   ||   \\  /  || : _/\\
                           |   |   ||    :   ||   |\\/   ||  |>   \\|   /  \\|   :  \\      |   /  ||   :   ||   |\\/   ||   /  \\
                           |___|   ||        ||___| |   ||_______/|_.: __/|   |___\\     |. __  ||___|   ||___| |   ||_.: __/
                               |___||. _____/       |___|            :/   |___|          :/ |. |    |___|      |___|   :/
                                     :/                                                  :   :/
                                     :          Bring Your Ideas Into Reality                :
                           
                           """ + RESET;
                printArt(art);
        }
    }

    private static void printArt(String art) throws InterruptedException {
        for (int i = 0; i < art.length(); i++) {
            System.out.print(art.charAt(i));
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}
