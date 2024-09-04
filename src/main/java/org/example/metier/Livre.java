package org.example.metier;

import utilitaire.DateUtils;

import java.util.Date;

public class Livre extends Document{
    private String Isbn ;

    public Livre( String titre, String auteur, Date datePublication, int nombreDePages, String isbn ) {
        super( titre, auteur, datePublication, nombreDePages);
        this.Isbn = isbn;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    @Override
    public String toString() {
        String datePub = DateUtils.dateToString(super.getDatePublication());
        String message;
        if (super.isEmp()){
             message = "Pas Disponible";
        }else {
             message = "Disponible";
        }
        return
                "\nId = " +super.getId() + '\n'+
                "Titre = " + super.getTitre() +'\n' +
                "Auteur = " + super.getAuteur() +'\n' +
                "Date de publication = " +datePub +'\n' +
                "Nombre de page = " +super.getNombreDePages()+'\n' +
                "Isbn = " + Isbn + '\n'+
                "Status = " + message
                ;
    }
    @Override
    public boolean emprunter() {
        return false;
    }

    @Override
    public boolean retourner() {
        return false;
    }

    @Override
    public void afficherDetails() {

    }
}
