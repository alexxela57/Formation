import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFormation {

    private Formation formation;

    @BeforeEach
    public void Initialisation() {

        //Initialisation d'une variable formation
        formation = new Formation("Informatique");
    }

    @Test
    public void testAjouterMatiere() {

        //Initialisation
        formation.ajouterMatiere("Math", 3);

        //Verification
        assertTrue(formation.contientMatiere("Math"));
        assertEquals(3, formation.getCoefMatiere("Math"));
    }

    @Test
    public void testSupprimerMatiere() {

        //Initialisation
        formation.ajouterMatiere("Math", 3);
        formation.supprimerMatiere("Math");

        //Verification
        assertFalse(formation.contientMatiere("Math"));
        assertEquals(-1, formation.getCoefMatiere("Math"));
    }

    @Test
    public void testCoefficientMatiere() {

        //Initialisation
        formation.ajouterMatiere("Math", 3);
        int coef = formation.getCoefMatiere("Math");

        //Verification
        assertEquals(3, coef);
    }

    @Test
    public void testCoefficientMatiereInexistante() {

        //Initialisation
        int coef = formation.getCoefMatiere("Inexistant");

        //Verification
        assertEquals(-1, coef);
    }
}
