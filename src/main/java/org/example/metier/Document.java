package org.example.metier;

import java.util.Date;

public abstract class Document {
    private int Id ;
    private String titre ;
    private String auteur ;
    private Date datePublication;
    private int nombreDePages;
    private boolean emp ;

    public Document( String titre ,String auteur ,Date datePublication ,int nombreDePages ) {
        this.auteur = auteur;
        this.titre = titre;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages ;
        this.emp = false;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }
    public boolean isEmp() {
        return emp;
    }

    public void setEmp(boolean emp) {
        this.emp = emp;
    }
    public abstract boolean emprunter();
    public abstract boolean retourner();
    public abstract void afficherDetails();
}
