package org.example.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bibliotheque {
    private final ArrayList<Document> documents;

    public Bibliotheque(){
        documents = new ArrayList<Document>();
    }
    public void ajouterDocument(Document doc){
        documents.add(doc);

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

    public void Recherche (String input ){
        boolean estTrouver = false;
        for (Document doc : documents){
        if(doc.getTitre().equals(input) || doc.getAuteur().equals(input)){
            System.out.println("Le document que vous avez cherchez est : "+ doc);
            estTrouver =true;
          }
        }
        if (!estTrouver){
            System.out.println("Ce document n'existe pas ");
        }
    }
    public void affichage(){
        if (documents.isEmpty()){
            System.out.println("Aucun document disponible.");
        }else {
            for (Document doc : documents){
                System.out.println(doc);
            }
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

}
