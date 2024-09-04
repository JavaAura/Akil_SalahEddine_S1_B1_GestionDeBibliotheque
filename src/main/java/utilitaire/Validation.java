package utilitaire;

import java.util.Scanner;

public class Validation {

    // Méthode pour valider une chaîne de caractères non vide entrée par l'utilisateur
    public String StringValisation(Scanner scan){
        boolean isValide = false;
        String input = null;
        while (!isValide){
            input = scan.nextLine();
            if (input != null && !input.isEmpty() ){
                isValide = true;
            }else {
                System.out.print("Erreur : vous devez entrer une chaîne de caractères non vide : ");
            }
        }
        return input;
    }

    // Méthode pour valider un entier entré par l'utilisateur
    public int intValidation(Scanner scan){
        boolean isValide = false;
        int input = 0;
        while (!isValide){
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                isValide = true;
            }else{
                System.out.print("Erreur : vous devez entrer un nombre entier : ");
                scan.next();
            }
        }
        return input;
    }

}
