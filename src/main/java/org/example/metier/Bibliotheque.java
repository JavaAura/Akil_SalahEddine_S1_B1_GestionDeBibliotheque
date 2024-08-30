package org.example.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bibliotheque {
    private final ArrayList<Document> documents;

    public Bibliotheque(){
        documents = new ArrayList<Document>();
    }
//    public void ajouterLivre(int id , String titre , String auteur , Date datePublication ,int nombreDePages, String isbn ,boolean emp ){
//        Livre livre = new Livre(id,titre,auteur,datePublication,nombreDePages ,isbn  );
//        livres.add(livre);
//        System.out.println("Le document est bien ajouter !!");
//    }
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
        for (Document doc : documents){
        if(doc.getTitre().equals(input) || doc.getAuteur().equals(input)){
            System.out.println("Le document que vous avez cherchez est : "+ doc);
          }else {
            System.out.println("Ce document n'existe pas ");
        }
        }
    }
    public void affichage(){
    System.out.println("Les livres qui sont disponible : ");
        for (Document doc : documents){
            if (!doc.isEmp()){
                System.out.println(doc);
            }
        }
    }
    public void Retourner (String key){
        for (Document doc :documents){
            if(doc.getTitre().equals(key) && doc.isEmp()){
                doc.setEmp(false);
                System.out.println("Document retourné avec succès !");
                return;
            }
        }
        System.out.println("Document non trouvé ou déjà retourné.");
    }
//    public static void main(String[] args){
//        Bibliotheque app = new Bibliotheque();
//        Date currentDate = new Date();
//        app.ajouterLivre(1, "Les Misérables", "Victor Hugo", currentDate, 1463, "978", false);
//        app.affichage();
//        //app.Recherche("Les ");
//        app.isEmprunt("978");
////        app.Retourner("978");
//
//    }
}
