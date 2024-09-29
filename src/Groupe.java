import java.util.*;

public class Groupe {
    private Map<Formation, List<Etudiant>> etudiants;

    public Groupe() {
        this.etudiants = new HashMap<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        Formation formationEtudiant = etudiant.getFormation();
        List<Etudiant> listeEtudiants = etudiants.get(formationEtudiant);
        if (listeEtudiants == null) {
            listeEtudiants = new ArrayList<>();
            etudiants.put(formationEtudiant, listeEtudiants);
        }
        listeEtudiants.add(etudiant);
    }

    public void supprimerEtudiant(Etudiant etudiant) {
        Formation formationEtudiant = etudiant.getFormation();
        List<Etudiant> listeEtudiants = etudiants.get(formationEtudiant);
        if (listeEtudiants != null) {
            listeEtudiants.remove(etudiant);
            if (listeEtudiants.isEmpty()) {
                etudiants.remove(formationEtudiant);
            }
        }
    }


    public double moyenneGroupeMatiere(String matiere) throws NoteInvalideException {
        double moy = 0;
        for (List<Etudiant> listeEtudiants: etudiants.values()){
            for (Etudiant etudiant: listeEtudiants){
                moy += etudiant.calculerMoyenneMatiere(matiere);
            }
            moy = moy/listeEtudiants.size();
        }
        moy = Math.round(moy * Math.pow(10,2)) / Math.pow(10,2);
        return moy;
    }

    public double moyenneGeneraleGroupe() throws NoteInvalideException {
        double moy = 0;
        for (List<Etudiant> listeEtudiants: etudiants.values()){
            for (Etudiant etudiant: listeEtudiants){
                moy += etudiant.calculerMoyenneGenerale();
            }
            moy = moy/listeEtudiants.size();
        }

        moy = Math.round(moy * Math.pow(10,2)) / Math.pow(10,2);
        return moy;
    }

    public Map<Formation, List<Etudiant>> getEtudiants() {
        return etudiants;
    }

    public List<Etudiant> getEtudiantsPourFormation(Formation formation) {
        return etudiants.get(formation);
    }



}