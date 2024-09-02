package org.example.metier;

import utilitaire.DateUtils;

import java.util.Date;

public class Magazine extends Document{
    private int numero;

    public Magazine( String titre, String auteur, Date datePublication, int nombreDePages, int numero ) {
        super( titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        String datePub = DateUtils.dateToString(super.getDatePublication());
        return
                "\nId = " +super.getId() + '\n'+
                "Titre = " + super.getTitre() +'\n' +
                "Auteur = " + super.getAuteur() +'\n' +
                "Date de publication = " +datePub +'\n' +
                "Nombre de page = " +super.getNombreDePages()+'\n' +
                "Numero = " + numero + '\n'+
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
