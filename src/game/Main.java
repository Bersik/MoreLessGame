package game;

import game.model.Model;

public class Main {

    public static void main(String[] args) {

        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.playGame();

    }
}
