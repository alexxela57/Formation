import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTris {
    private Groupe groupe;

    private Formation info;

    @BeforeEach
    public void setUp() {
        // Initialisation du groupe et ajout d'étudiants pour les tests
        groupe = new Groupe();
        info = new Formation("Informatique");
        Etudiant b = new Etudiant(new Identite("02", "Bob", "Lennon"), info);
        Etudiant c = new Etudiant(new Identite("03", "Clem", "Poulet"), info);
        Etudiant a = new Etudiant(new Identite("01", "Amine", "boeuf"), info);
        groupe.ajouterEtudiant(b);
        groupe.ajouterEtudiant(c);
        groupe.ajouterEtudiant(a);
    }

    @Test
    public void testTriAlpha() {
        // Appliquer le tri alphabétique
        groupe.triAlpha();

        // Vérifiez que les étudiants sont triés par ordre alphabétique des noms
        List<Etudiant> etudiantsTriAlpha = groupe.getEtudiantsPourFormation(info);
        assertEquals("Amine", etudiantsTriAlpha.get(0).getIdentite().getNom());
        assertEquals("Bob", etudiantsTriAlpha.get(1).getIdentite().getNom());
        assertEquals("Clem", etudiantsTriAlpha.get(2).getIdentite().getNom());
    }

    @Test
    public void testTriAntiAlpha() {
        // Appliquer le tri alphabétique inverse
        groupe.triAntiAlpha();

        // Vérifiez que les étudiants sont triés par ordre alphabétique inverse des noms
        List<Etudiant> etudiantsTriAntiAlpha = groupe.getEtudiantsPourFormation(info);
        assertEquals("Clem", etudiantsTriAntiAlpha.get(0).getIdentite().getNom());
        assertEquals("Bob", etudiantsTriAntiAlpha.get(1).getIdentite().getNom());
        assertEquals("Amine", etudiantsTriAntiAlpha.get(2).getIdentite().getNom());
    }

    @Test
    public void testTriAlpha_AvecAutreFormation() {
        // Ajouter un étudiant d'une autre formation
        Formation autreFormation = new Formation("Mathématiques");
        Etudiant math = new Etudiant(new Identite("04", "Mathieu", "Poisson"), autreFormation);
        groupe.ajouterEtudiant(math);

        // Appliquer le tri alphabétique
        groupe.triAlpha();

        // Vérifier que les étudiants de la formation "Informatique" sont triés
        List<Etudiant> etudiantsTriAlphaInfo = groupe.getEtudiantsPourFormation(info);
        assertEquals("Amine", etudiantsTriAlphaInfo.get(0).getIdentite().getNom());
        assertEquals("Bob", etudiantsTriAlphaInfo.get(1).getIdentite().getNom());
        assertEquals("Clem", etudiantsTriAlphaInfo.get(2).getIdentite().getNom());

        // Vérifier que l'étudiant de la formation "Mathématiques" est inchangé
        List<Etudiant> etudiantsAutreFormation = groupe.getEtudiantsPourFormation(autreFormation);
        assertEquals("Mathieu", etudiantsAutreFormation.get(0).getIdentite().getNom());
    }

    @Test
    public void testTriAntiAlpha_AvecAutreFormation() {
        // Ajouter un étudiant d'une autre formation
        Formation autreFormation = new Formation("Mathématiques");
        Etudiant math = new Etudiant(new Identite("04", "Mathieu", "Grenier"), autreFormation);
        groupe.ajouterEtudiant(math);

        // Appliquer le tri alphabétique inverse
        groupe.triAntiAlpha();

        // Vérifier que les étudiants de la formation "Informatique" sont triés
        List<Etudiant> etudiantsTriAntiAlphaInfo = groupe.getEtudiantsPourFormation(info);
        assertEquals("Clem", etudiantsTriAntiAlphaInfo.get(0).getIdentite().getNom());
        assertEquals("Bob", etudiantsTriAntiAlphaInfo.get(1).getIdentite().getNom());
        assertEquals("Amine", etudiantsTriAntiAlphaInfo.get(2).getIdentite().getNom());

        // Vérifier que l'étudiant de la formation "Mathématiques" est inchangé
        List<Etudiant> etudiantsAutreFormation = groupe.getEtudiantsPourFormation(autreFormation);
        assertEquals("Mathieu", etudiantsAutreFormation.get(0).getIdentite().getNom());
    }
}