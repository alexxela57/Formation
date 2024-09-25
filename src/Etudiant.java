import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant implements Comparable<Etudiant> {
    private Identite identite;
    private Formation formation;
    private Map<String, List<Integer>> notes;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public void ajouterNote(String matiere, int note) throws NoteInvalideException {
        if (formation.contientMatiere(matiere) && note >= 0 && note <= 20) {
            if (!notes.containsKey(matiere)) {
                notes.put(matiere, new ArrayList<>());
            }
            notes.get(matiere).add(note);
        } else {
            throw new NoteInvalideException("Impossible d'ajouter la note. Vérifiez la matière ou la note.");
        }
    }

    public double calculerMoyenneMatiere(String matiere) throws NoteInvalideException {
        if (notes.containsKey(matiere)) {
            List<Integer> listeNotes = notes.get(matiere);
            if (listeNotes.isEmpty()) {
                throw new NoteInvalideException("Aucune note trouvée pour la matière '" + matiere + "'.");
            }
            double somme = 0.0;
            for (int note : listeNotes) {
                somme += note;
            }
            return somme / listeNotes.size();
        } else {
            throw new NoteInvalideException("Aucune note trouvée pour la matière '" + matiere + "'.");
        }
    }

    public double calculerMoyenneGenerale() throws NoteInvalideException {
        double sommeNotes = 0.0;
        double sommeCoefficients = 0.0;
        boolean auMoinsUneNote = false;

        for (String matiere : notes.keySet()) {
            double moyenneMatiere = calculerMoyenneMatiere(matiere);
            int coefficient = formation.getCoefMatiere(matiere);
            sommeNotes += moyenneMatiere * coefficient;
            sommeCoefficients += coefficient;
            if (!notes.get(matiere).isEmpty()) {
                auMoinsUneNote = true;
            }
        }
        if (!auMoinsUneNote) {
            throw new NoteInvalideException("Aucune note trouvée dans toutes les matières.");
        }
        return sommeNotes / sommeCoefficients;
    }

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    public Map<String, List<Integer>> getNotes() {
        return notes;
    }

    @Override
    public int compareTo(Etudiant autreEtudiant) {
        return this.getIdentite().getNom().compareTo(autreEtudiant.getIdentite().getNom());
    }
}