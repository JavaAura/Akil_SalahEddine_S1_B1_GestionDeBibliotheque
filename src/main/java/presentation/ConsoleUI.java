package presentation;

import org.example.metier.Bibliotheque;
import org.example.metier.Livre;
import org.example.metier.Magazine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConsoleUI {

    public static void main(String[] args) {
        Bibliotheque biblio = new Bibliotheque();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");
        int choix ;
        do {
            System.out.println();
            System.out.println();
            System.out.println("Menu de Gestion de la Bibliothèque");
            System.out.println();
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Rechercher un document");
            System.out.println("4. Emprunter un document");
            System.out.println("5. Retourner un document");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1 :
                    System.out.println("Quel type de document voulez-vous ajouter ?");
                    System.out.println("1. Livre");
                    System.out.println("2. Magazine");
                    System.out.print("Choisissez une option : ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Id : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Auteur : ");
                    String auteur = scanner.nextLine();
                    System.out.print("Date de publication : ");
                    String date = scanner.nextLine();
                    System.out.print("Nombre des pages : ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();
                    if(type == 1){
                        System.out.print("ISBN : ");
                        String isbn = scanner.nextLine();
                        Livre livre = new Livre(id,titre,auteur,new Date(),pages,isbn);
                        biblio.ajouterDocument(livre);
                    } else if (type == 2) {
                        System.out.print("Numero : ");
                        int numero = scanner.nextInt();
                        Magazine magazine = new Magazine(id,titre,auteur,new Date(),pages,numero);
                        biblio.ajouterDocument(magazine);
                    }else {
                        System.out.println("Option invalide ");
                    }
                    break;
                case 2 :
                    biblio.affichage();
                    break;
            }
        }while (choix!=0);

    }
}