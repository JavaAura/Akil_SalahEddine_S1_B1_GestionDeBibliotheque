package org.example.metier;

import java.util.*;

public class Bibliotheque {
    // Liste pour stocker tous les documents de la bibliothèque
    private final ArrayList<Document> documents;
    // Map pour stocker les documents avec leur titre comme clé pour une recherche rapide
    private final Map <String,Document> documentMap;
    // Variable pour générer des identifiants uniques pour chaque document
    private int id;

    // Constructeur de la classe Bibliotheque
    public Bibliotheque(){
        documents = new ArrayList<>();
        this.documentMap = new HashMap<>();
        this.id=1;
    }

    // Méthode pour ajouter un nouveau document à la bibliothèque
    public void ajouterDocument(Document doc){
        doc.setId(id);
        documents.add(doc);
        documentMap.put(doc.getTitre(),doc);
        id++;
       System.out.println("\nLe document est bien ajouter !!");
    }

    // Méthode pour emprunter un document à partir de son ID
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

    // Méthode pour rechercher un document par son titre
    public void Recherche (String titre){
       Document doc = documentMap.get(titre);
       if (doc != null){
           System.out.println("\nLe document que vous avez cherché est : " + doc);
       } else {
           System.out.println("\nCe document n'existe pas.");
       }
    }

    // Méthode pour afficher tous les documents de la bibliothèque
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

    // Méthode pour retourner un document emprunté
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
}
