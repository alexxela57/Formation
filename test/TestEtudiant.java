import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestEtudiant {

    private Formation formation;
    private Identite identite;
    private Etudiant etudiant;

    @BeforeEach
    public void Initialisation() {
        //Initialisation des variables de tests
        formation = new Formation("Informatique");
        formation.ajouterMatiere("Math", 3);
        formation.ajouterMatiere("Physique", 2);
        formation.ajouterMatiere("Chimie", 1);

        identite = new Identite("NIP123", "Clement");
        etudiant = new Etudiant(identite, formation);
    }

    @Test
    public void testAjouterNote() throws NoteInvalideException {

        //ajout de note
        etudiant.ajouterNote("Math", 15);

        //verification
        assertTrue(etudiant.getNotes().containsKey("Math"));
        assertEquals(Arrays.asList(15), etudiant.getNotes().get("Math"));
    }

    @Test
    public void testCalculerMoyenneMatiere() throws NoteInvalideException{

        //ajout de notes
        etudiant.ajouterNote("Math", 15);
        etudiant.ajouterNote("Math", 18);

        //verification
        double moyenne = etudiant.calculerMoyenneMatiere("Math");
        assertEquals(16.5, moyenne);
    }

    @Test
    public void testCalculerMoyenneGenerale() throws NoteInvalideException{

        //ajout de notes
        etudiant.ajouterNote("Math", 15);
        etudiant.ajouterNote("Physique", 18);

        //verification
        double moyenne = etudiant.calculerMoyenneGenerale();
        assertEquals(16.2, moyenne);
    }


}

