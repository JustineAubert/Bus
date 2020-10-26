package lieux;

public class CompChgt implements Comparateur {
    public int compare(Trajet t1, Trajet t2) {
	try { 
		return t2.nbChgt()-t1.nbChgt();
	}catch (ErreurTrajet e){
		
	}return 0;
    }
}
