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
    	for (Etape e : sesEtapes ) {
    		if (e.estPossible()) {
    			return true;
    		}
    	}
		return false;
    }

    public Heure hArrivee() throws ErreurTrajet {
       return sesEtapes.get(sesEtapes.size()-1).hArrivee();
    }

    public Heure duree() throws ErreurTrajet {
    	Heure duree = new Heure();
        for(Etape etape : sesEtapes){
            try {
                duree = duree.add(etape.duree());
            }catch (ErreurHeure e){
                e.getMessage();
            }
        }
        return duree;
    }

    public Heure attente() throws ErreurTrajet {
    	Heure attente = new Heure();
    for(Etape etape : sesEtapes){
        try {
            attente = attente.add(etape.attente());
        }catch (ErreurHeure e){
            e.getMessage();
        }
    }
    return attente;
 }

    public int nbChgt() throws ErreurTrajet {
    	int nbChgt = 0;
        for(int i=0; i<sesEtapes.size()-1; i++){
            if(!sesEtapes.get(i).moyen().toString().equals(sesEtapes.get(i+1).moyen().toString())){
                nbChgt++;
            }
        }
        return nbChgt;
    }

    public static Trajet meilleur(Collection<Trajet> col, Comparateur comp) {
    Trajet meilleur = null;
    for(Trajet trajet : col){
        if(meilleur == null){
            meilleur = trajet;
        }
        if(comp.compare(meilleur, trajet)<0){
            meilleur = trajet;
        }
    }
    return meilleur;
}

}
