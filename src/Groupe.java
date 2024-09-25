import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Formation, List<Etudiant>> getEtudiants() {
        return etudiants;
    }

    public List<Etudiant> getEtudiantsPourFormation(Formation formation) {
        return etudiants.get(formation);
    }


}