package lieux;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Trajet {
    private String nom;
    private Lieu depart;
    private Lieu arrivee;
    private Heure dateDepart;
    private ArrayList<Etape> sesEtapes;

    public Trajet(String n, Lieu dep, Lieu arr, Heure d,
                  ArrayList<Etape> etapes) {
        nom = n;
        depart = dep;
        arrivee = arr;
        dateDepart = d;
        sesEtapes = etapes;
    }

    public String nom() { return nom; }

    public Lieu depart() { return depart; }

    public Lieu arrivee() { return arrivee; }

    public void liste() {
        System.out.println("Trajet " + nom + " de " + depart.nom() + " a " 
                           + arrivee.nom() + ", depart a " + dateDepart + " :");
        for(Etape e: sesEtapes) e.liste();
    }

    public boolean estCoherent() {
    	for (Etape e : sesEtapes ) 
       // throw new UnsupportedOperationException();
    }

    public Heure hArrivee() throws ErreurTrajet {
       return sesEtapes[sesEtapes.length-1].hArrivee();
    	// throw new UnsupportedOperationException();
    }

    public Heure duree() throws ErreurTrajet {
        return dateDepart.moins(arrivee());
    }

    public Heure attente() throws ErreurTrajet {
        return 
 }

    public int nbChgt() throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }

    public static Trajet meilleur(Collection<Trajet> col, Comparateur comp)
    throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }

}
