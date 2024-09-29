import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMoyenneGroupe {

    private Groupe groupe;
    private Formation formation;
    private Etudiant etudiant1;
    private Etudiant etudiant2;
    @BeforeEach
    public void Initialisation() throws NoteInvalideException {
        groupe = new Groupe();
        formation = new Formation("Informatique");
        etudiant1 = new Etudiant(new Identite("NIP123", "John"), formation);
        etudiant2 = new Etudiant(new Identite("NIP456", "Alice"), formation);

//ajout des matières
        formation.ajouterMatiere("maths",1);
        formation.ajouterMatiere("feur",2);
//ajout de notes pour les étudiants
        etudiant1.ajouterNote("maths", 0);
        etudiant1.ajouterNote("maths", 20);
        etudiant2.ajouterNote("maths", 10);
        etudiant2.ajouterNote("maths", 14);
        etudiant2.ajouterNote("feur", 10);
        etudiant1.ajouterNote("feur", 10);
//ajout des élèves dans le groupe
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
    }




    @Test
    public void testCalculerMoyenneMatiere() throws NoteInvalideException {
        double moyenne = groupe.moyenneGroupeMatiere("maths");
        assertEquals(11,moyenne);
    }

    @Test
    public void testCalculerMoyenne() throws NoteInvalideException {
        double moyenne = groupe.moyenneGeneraleGroupe();
        assertEquals(10.33,moyenne);
    }
}