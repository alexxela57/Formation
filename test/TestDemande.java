import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class TestDemande {

    private Groupe groupe;

    private Formation formation;

    private Etudiant etudiant1;
    private Etudiant etudiant2;
    private Etudiant etudiant3;

    @BeforeEach
    public void Initialisation() throws NoteInvalideException {

        //Creation des formations, eleves et matieres

        groupe = new Groupe();
        formation = new Formation("BUT_info");
        etudiant1 = new Etudiant(new Identite("NIP123", "Rener", "Alfred"), formation);
        etudiant2 = new Etudiant(new Identite("NIP456", "Sed", "Astrid"), formation);
        etudiant3 = new Etudiant(new Identite("NIP789", "Grener", "Thomas"), formation);
        formation.ajouterMatiere("web",1);
        formation.ajouterMatiere("reseau",1);
        formation.ajouterMatiere("algo",2);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);

        //insertion des notes

        etudiant1.ajouterNote("web", 12);
        etudiant1.ajouterNote("web", 10);
        etudiant1.ajouterNote("web", 11);
        etudiant1.ajouterNote("web", 15);

        etudiant1.ajouterNote("reseau", 12);
        etudiant1.ajouterNote("reseau", 10);
        etudiant1.ajouterNote("reseau", 11);

        etudiant1.ajouterNote("algo", 9);
        etudiant1.ajouterNote("algo", 8);
        etudiant1.ajouterNote("algo", 10);


        etudiant2.ajouterNote("web", 9);
        etudiant2.ajouterNote("web", 8);
        etudiant2.ajouterNote("web", 10);

        etudiant2.ajouterNote("reseau", 9);
        etudiant2.ajouterNote("reseau", 8);
        etudiant2.ajouterNote("reseau", 10);


        etudiant3.ajouterNote("web", 12);
        etudiant3.ajouterNote("web", 10);
        etudiant3.ajouterNote("web", 11);

        etudiant3.ajouterNote("reseau", 12);
        etudiant3.ajouterNote("reseau", 10);
        etudiant3.ajouterNote("reseau", 11);

        etudiant3.ajouterNote("algo", 9);
        etudiant3.ajouterNote("algo", 8);
        etudiant3.ajouterNote("algo", 10);
    }

    //Tests pour les moyennes de chaques matières des chaque eleve
    @Test
    public void testCalculerMoyenneWeb1() throws NoteInvalideException{

        //verification
        double moyenne = etudiant1.calculerMoyenneMatiere("web");
        assertEquals(12, moyenne);
    }

    @Test
    public void testCalculerMoyenneReseau1() throws NoteInvalideException{

        //verification
        double moyenne = etudiant1.calculerMoyenneMatiere("reseau");
        assertEquals(11, moyenne);
    }
    @Test
    public void testCalculerMoyenneAlgo1() throws NoteInvalideException{

        //verification
        double moyenne = etudiant1.calculerMoyenneMatiere("algo");
        assertEquals(9, moyenne);
    }

    @Test
    public void testCalculerMoyenneWeb2() throws NoteInvalideException{

        //verification
        double moyenne = etudiant2.calculerMoyenneMatiere("web");
        assertEquals(9, moyenne);
    }
    @Test
    public void testCalculerMoyenneReseau2() throws NoteInvalideException{

        //verification
        double moyenne = etudiant2.calculerMoyenneMatiere("reseau");
        assertEquals(9, moyenne);
    }


    @Test
    public void testCalculerMoyenneWeb3() throws NoteInvalideException{

        //verification
        double moyenne = etudiant3.calculerMoyenneMatiere("web");
        assertEquals(11, moyenne);
    }
    @Test
    public void testCalculerMoyenneReseau3() throws NoteInvalideException{

        //verification
        double moyenne = etudiant3.calculerMoyenneMatiere("reseau");
        assertEquals(11, moyenne);
    }
    @Test
    public void testCalculerMoyenneAlgo3() throws NoteInvalideException{

        //verification
        double moyenne = etudiant1.calculerMoyenneMatiere("algo");
        assertEquals(9, moyenne);
    }


    //Tests pour les moyennes genereales des chaque eleve

    @Test
    public void testCalculerMoyenneGenerale1() throws NoteInvalideException{

        //verification
        double moyenne = etudiant1.calculerMoyenneGenerale();
        assertEquals(10.25, moyenne);
    }

    @Test
    public void testCalculerMoyenneGenerale2() throws NoteInvalideException{

        //verification
        double moyenne = etudiant2.calculerMoyenneGenerale();
        assertEquals(9, moyenne);
    }

    @Test
    public void testCalculerMoyenneGenerale3() throws NoteInvalideException{

        //verification
        double moyenne = etudiant3.calculerMoyenneGenerale();
        assertEquals(10, moyenne);
    }


    //Test pour les moyennes de matières du groupe

    @Test
    public void testCalculerMoyenneWeb() throws NoteInvalideException {
        double moyenne = groupe.moyenneGroupeMatiere("web");
        assertEquals(10.66,moyenne,0.01);
    }

    @Test
    public void testCalculerMoyenneReseau() throws NoteInvalideException {
        double moyenne = groupe.moyenneGroupeMatiere("reseau");
        assertEquals(10.33,moyenne);
    }

    @Test
    public void testCalculerMoyenneAlgo() throws NoteInvalideException {
        double moyenne = groupe.moyenneGroupeMatiere("algo");
        assertEquals(9,moyenne);
    }

    //Test pour la moyenne generale du groupe

    @Test
    public void testCalculerMoyenne() throws NoteInvalideException {
        double moyenne = groupe.moyenneGeneraleGroupe();
        assertEquals(9.75,moyenne);
    }


}
