package org.example.metier;

import java.util.Date;

public class Magazine extends Document{
    private int numero;

    public Magazine(int id, String titre, String auteur, Date datePublication, int nombreDePages, int numero ) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Magazine : \n" +
                "Titre = " + super.getTitre() +'\n' +
                "Auteur = " + super.getAuteur() +'\n' +
                "Date de publication = " +super.getDatePublication() +'\n' +
                "Nombre de page = " +super.getNombreDePages()+'\n' +
                "Numero = " + numero + '\n'
//                "emp = " + emp
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
