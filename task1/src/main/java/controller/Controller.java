package controller;

import model.Model;
import view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * i uses for iteration over input operation and a word index in @{@link Model#VALID_ARGS} array
     */
    public void processUser() {
        for(int i = 0; i < Model.VALID_ARGS.length; i++) {
            System.out.println("Enter a word");
            Scanner scanner = new Scanner(System.in);
            inputWord(scanner, i);
        }

        System.out.println(View.RESULT_MESSAGE + model.getMessage());
    }

    private void inputWord(Scanner sc, int wordIndex) {
        String word;

        while(sc.hasNext()) {
            word = sc.next();
            if(model.validateWord(word, wordIndex)) {
                view.printMessage(View.CORRECT_WORD);
                model.concatToMessage(word);
                break;
            }

            view.printMessage(View.WRONG_WORD);
        }
    }
}
