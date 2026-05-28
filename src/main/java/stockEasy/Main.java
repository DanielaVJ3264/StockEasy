package stockEasy;

import stockEasy.config.Config;
import stockEasy.userinterface.MenuApp;

public class Main {

    public static void main(String[] args) {

        MenuApp menuApp = Config.createMenuApp();

        menuApp.mainMenu();
    }
}