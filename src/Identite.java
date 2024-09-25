public class Identite {

    //attributs

    private String NIP;
    private String nom;
    private String prenom;

    // constructeur
    public Identite (String nip, String n){
        this.NIP = nip;
        this.nom = n;

    }

    //methodes



    public String getNom() {
        return nom;
    }

    public String getNIP() {
        return NIP;
    }
}