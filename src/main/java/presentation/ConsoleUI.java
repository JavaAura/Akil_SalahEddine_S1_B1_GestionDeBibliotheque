package presentation;

import org.example.metier.Bibliotheque;
import org.example.metier.Livre;
import org.example.metier.Magazine;
import utilitaire.DateUtils;
import utilitaire.Validation;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI {

    public static void main(String[] args) throws ParseException {
        Bibliotheque biblio = new Bibliotheque();
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        int choix ;
        do {
            System.out.println();
            System.out.println("Menu de Gestion de la Bibliothèque");
            System.out.println();
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Rechercher un document");
            System.out.println("4. Emprunter un document");
            System.out.println("5. Retourner un document");
            System.out.println("6. Quitter");
            System.out.print("\nVeuillez entrer votre choix (1-6) : " );
            choix = validation.intValidation(scanner);
            scanner.nextLine();
            switch (choix){
                case 1 :
                    System.out.println("Quel type de document voulez-vous ajouter ?");
                    System.out.println("1. Livre");
                    System.out.println("2. Magazine");
                    System.out.print("Choisissez une option : ");
                    int type = validation.intValidation(scanner);
                    if (type != 1 && type != 2){
                        System.out.println("Option invalide ");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Titre : ");
                    String titre = validation.StringValisation(scanner);
                    System.out.print("Auteur :");
                    String auteur = validation.StringValisation(scanner);
                    String date;
                    Date datePublication;
                    do {
                        System.out.print("Date de publication (dd/MM/yyyy) : ");
                        date = scanner.nextLine();
                        if (DateUtils.isValidDate(date)){
                            datePublication = DateUtils.StringToDate(date);
                            break;
                        }else {
                            System.out.println("Date invalide. Veuillez entrer une date au format dd-MM-yyyy.");
                        }
                    }while (true);
                    System.out.print("Nombre des pages : ");
                    int pages = validation.intValidation(scanner);
                    scanner.nextLine();
                    if(type == 1){
                        System.out.print("ISBN : ");
                        String isbn = scanner.nextLine();
                        Livre livre = new Livre(titre,auteur,datePublication,pages,isbn);
                        biblio.ajouterDocument(livre);
                    } else if (type == 2) {
                        System.out.print("Numero : ");
                        int numero ;
                        numero = validation.intValidation(scanner);
                        Magazine magazine = new Magazine(titre,auteur,datePublication,pages,numero);
                        biblio.ajouterDocument(magazine);
                    }
                    break;
                case 2 :
                    biblio.affichage();
                    break;
                case 3 :
                    System.out.print("Veuillez entrer le titre de document : ");
                    String title = validation.StringValisation(scanner);
                    biblio.Recherche(title);
                    break;
                case 4 :
                        System.out.print("Veuillez entrer le ID de document pour emprunter : ");
                        int id = validation.intValidation(scanner);
                        biblio.EmprunterDocument(id);
                    break;
                case 5 :
                        System.out.print("Veuillez entrer le ID de document pour retourner : ");
                        int iD = validation.intValidation(scanner);
                        biblio.Retourner(iD);
                    break;
                case 6:
                    System.out.println("\nAu revoir !");
                    break;
                default:
                    System.out.println("Option invalide !!" );
            }
        }while (choix!=0);

    }
}