package org.example.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bibliotheque {
    private final ArrayList<Document> documents;
    private  Map <String,Document> documentMap;
    private int id;

    public Bibliotheque(){
        documents = new ArrayList<Document>();
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
