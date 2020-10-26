package lieux;

public class EnBus extends MoyenTransport {
    private LigneBus saLigne;

    public EnBus(LigneBus l) { saLigne = l; }

    public String toString() {
        return "Ligne Bus [" + saLigne.nom() + "]";
    }

    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
    	return saLigne.attente(new Arret(l1.nom()),dep);
    	   
    }

    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
    	Arret a1 = (Arret) l1;
    	Arret a2 = (Arret) l2;
   	 	return saLigne.dureeEnBus(a1,a2);
    }

    public boolean estPossible(Lieu l1, Lieu l2, Heure dep) {
    	 int i1= saLigne.sesArrets.indexOf(l1);
    	 int i2=saLigne.sesArrets.indexOf(l2);
    	 
    		if (i1 != -1 && i2 != -1 && i1<i2 || i1==i2){
    				return true;
    }
    		else return false;
}}
