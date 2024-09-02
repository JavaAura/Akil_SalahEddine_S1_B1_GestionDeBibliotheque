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
       System.out.println("Le document est bien ajouter !!");
    }
    public void EmprunterDocument(String key) {
        boolean docTrouve = false;
        for (Document doc : documents) {
            if (doc instanceof Livre && ((Livre) doc).getIsbn().equals(key) || (doc instanceof Magazine && String.valueOf(((Magazine) doc).getNumero()).equals(key))) {
                docTrouve = true;
                if (doc.isEmp()) {
                    System.out.println("Le document est déjà emprunté !");
                } else {
                    doc.setEmp(true);
                    System.out.println("Document emprunté avec succès !");
                }
                break;
            }
        }
        if (!docTrouve) {
            System.out.println("Pas de document avec ce identifiant");
        }
    }
    public void Recherche (String titre){
       Document doc = documentMap.get(titre);
       if (doc != null){
           System.out.println("Le document que vous avez cherché est : " + doc);
       } else {
           System.out.println("Ce document n'existe pas.");
       }
    }

    public void affichage(){
        if (documents.isEmpty()){
            System.out.println("Aucun document disponible.");
        }else {
            System.out.println("Les livres sont : " );
            documents.stream().filter(doc -> doc instanceof Livre).forEach(System.out::println);
            System.out.println("Les magazine sont : " );
            documents.stream().filter(doc -> doc instanceof Magazine).forEach(System.out::println);
        }
    }
    public void Retourner (String key){
        for (Document doc :documents){
            if((doc instanceof Livre && ((Livre) doc).getIsbn().equals(key)) || (doc instanceof Magazine && String.valueOf (((Magazine) doc).getNumero()).equals(key)) && doc.isEmp()){
                doc.setEmp(false);
                System.out.println("Document retourné avec succès !");
                return;
            }
        }
        System.out.println("Document non trouvé ou déjà retourné.");
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
