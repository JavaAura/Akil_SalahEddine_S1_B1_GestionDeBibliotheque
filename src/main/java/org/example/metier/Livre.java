package org.example.metier;

import java.util.Date;

public class Livre extends Document{
    private String Isbn ;

    public Livre(int id, String titre, String auteur, Date datePublication, int nombreDePages, String isbn ) {
        super(id, titre, auteur, datePublication, nombreDePages);
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
        return "\nLivre : \n" +
                "Titre = " + super.getTitre() +'\n' +
                "Auteur = " + super.getAuteur() +'\n' +
                "Date de publication = " +super.getDatePublication() +'\n' +
                "Nombre de page = " +super.getNombreDePages()+'\n' +
                "Isbn = " + Isbn + '\n'+
                "Emprunter = " + super.isEmp()
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
