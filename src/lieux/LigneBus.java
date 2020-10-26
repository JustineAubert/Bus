package lieux;
import java.util.ArrayList;

public class LigneBus {
    protected String nomLigne;
    protected ArrayList<Arret> sesArrets;
    protected Heure[] sesDeparts;
    protected Heure[] sesTemps;

    public LigneBus(String nom) { nomLigne = nom; }

    public void addArrets(Arret[] lesArrets) {
        sesArrets = new ArrayList<Arret>();
        for(Arret a : lesArrets) {
            a.ajoutLigne(this);
            sesArrets.add(a);
        }
    }

    public String nom() { return nomLigne; }

    /* pour simplifier on suppose que les durees de deplacement sont
     * independantes de l'heure. Pour definir les horaires il suffit de donner
     * les heures de depart ainsi que les durees entre 2 arrets successifs.
     * La dimension du tableau des horaires doit etre egale au nombre d'arrets
     * de la ligne moins 1.
     *
     * Attention: une ligne de bus est orientee. Les horaires sont donnes dans
     * le sens de parcours. Si on veut aussi pouvoir parcourir une ligne dans
     * l'autre sens, il faut creer une deuxieme ligne !
     * On suppose enfin que les lignes ne sont pas circulaires,
     */
    public void ajoutHoraires(Heure[] horaire, Heure[] hdepart)
        throws ErreurTrajet {
        if (horaire.length != sesArrets.size() - 1) {
            throw new ErreurTrajet("Horaire mal formatte");
        }
        sesDeparts = hdepart;
        sesTemps = horaire;
    }

    public boolean estPossible(Arret a1, Arret a2, Heure dep) {
    	int i1= sesArrets.indexOf(a1);
      	 int i2=sesArrets.indexOf(a2);
       	if (i1 != -1 && i2 != -1 && i1<i2) {
       		return true;
       	}else return false;
        //throw new UnsupportedOperationException();
    }

    // On suppose que la duree de transport entre deux arrets ne depend pas
    // de l'heure et qu'on n'arrive jamais le lendemain du jour de depart.
    public Heure dureeEnBus(Arret a1, Arret a2) throws ErreurTrajet {
    	int i1= sesArrets.indexOf(a1);
    	int i2=sesArrets.indexOf(a2);
    	Heure h = new Heure();
    	for (int k = i1;k<i2;k+=1) {
    		try {
				h = h.add(sesTemps[k]);
			} catch (ErreurHeure e) {
				// TODO Auto-generated catch block
				throw new ErreurTrajet();
			}
    	}return h;
        //throw new UnsupportedOperationException();
    }

    public Heure attente(Arret a, Heure h) throws ErreurTrajet {
    	Heure heure;
        try {
            heure = sesDeparts[0].add(dureeEnBus(sesArrets.get(0), a));

            int i = 0;
            while((sesDeparts[i].add(dureeEnBus(sesArrets.get(0), a)).compareTo(h) == -1)){
                heure = sesDeparts[i+1].add(dureeEnBus(sesArrets.get(0), a));
                i++;
            }
            //System.out.println(heure);
            return h.delaiAvant(heure);

        } catch (ErreurHeure e) {
            throw new ErreurTrajet("On a une erreur d'attente de la ligne bus avec : "+ a + " \n");
        }
    
    }
}
