package lieux;

public class CompAttente implements Comparateur {
    public int compare(Trajet t1, Trajet t2) {
	try {
		return t2.attente().compareTo(t1.attente());
	}catch (ErreurTrajet e) {
		
	}
    	return 0;
    }
}
