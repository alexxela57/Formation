import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupe {

    private Groupe groupe;
    private Formation formation;
    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    public void Initialisation() {
        groupe = new Groupe();
        formation = new Formation("Informatique");
        etudiant1 = new Etudiant(new Identite("NIP123", "John"), formation);
        etudiant2 = new Etudiant(new Identite("NIP456", "Alice"), formation);
    }

    @Test
    public void testAjouterEtudiant() {

        //Initialisation
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        //Vérification
        assertTrue(groupe.getEtudiants().containsKey(formation));
        assertTrue(groupe.getEtudiants().get(formation).contains(etudiant1));
        assertTrue(groupe.getEtudiants().get(formation).contains(etudiant2));
    }

    @Test
    public void testSupprimerEtudiant() {

        //Initialisation
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        groupe.supprimerEtudiant(etudiant1);

        //Vérification
        assertTrue(groupe.getEtudiants().containsKey(formation));
        assertFalse(groupe.getEtudiants().get(formation).contains(etudiant1));
        assertTrue(groupe.getEtudiants().get(formation).contains(etudiant2));
    }


}

