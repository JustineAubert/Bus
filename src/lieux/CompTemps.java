package lieux;

public class CompTemps implements Comparateur {
    public int compare(Trajet t1, Trajet t2) {
    	try {
            return t2.duree().compareTo(t1.duree());
        }catch (ErreurTrajet e){

        }
	    return -1;
    }
    }

