package org.example.metier;

import java.util.*;

public class Bibliotheque {
    private final ArrayList<Document> documents;
    private final Map <String,Document> documentMap;
    private int id;

    public Bibliotheque(){
        documents = new ArrayList<>();
        this.documentMap = new HashMap<>();
        this.id=1;
    }
    public void ajouterDocument(Document doc){
        doc.setId(id);
        documents.add(doc);
        documentMap.put(doc.getTitre(),doc);
        id++;
       System.out.println("\nLe document est bien ajouter !!");
    }

    public void EmprunterDocument(int id) {
        boolean docTrouve = false;
        for (Document doc : documents) {
            if (doc.getId() == id){
                docTrouve = true;
                if (doc.isEmp()){
                    System.out.println("Le document est déjà emprunté !");
                }else {
                    doc.setEmp(true);
                    System.out.println("\nLe document emprunté avec succès !");
                }
                break;
            }
        }
        if (!docTrouve) {
        System.out.println("\nPas de document avec ce identifiant :)");
          }
    }
    public void Recherche (String titre){
       Document doc = documentMap.get(titre);
       if (doc != null){
           System.out.println("\nLe document que vous avez cherché est : " + doc);
       } else {
           System.out.println("\nCe document n'existe pas.");
       }
    }

    public void affichage(){
        if (documents.isEmpty()){
            System.out.println("\nAucun document disponible.");
        }else {

            System.out.println("\nLes livres sont : " );
            documents.stream().filter(doc -> doc instanceof Livre).forEach(System.out::println);
            System.out.println("\nLes magazine sont : " );
            documents.stream().filter(doc -> doc instanceof Magazine).forEach(System.out::println);
        }
    }
    public void Retourner (int id){
        for (Document doc :documents){
            if(doc.getId()==id && doc.isEmp()){
                doc.setEmp(false);
                System.out.println("\nDocument retourné avec succès !");
                return;
            }
        }
        System.out.println("\nDocument non trouvé ou déjà retourné.");
    }
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
    public int intValidation(Scanner scan){
        boolean isValide = false;
        int input =0 ;
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
