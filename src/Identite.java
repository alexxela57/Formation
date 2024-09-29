public class Identite {

    //attributs

    private String NIP;
    private String nom;
    private String prenom;

    // constructeur
    public Identite (String nip, String n, String p){
        this.NIP = nip;
        this.nom = n;
        this.prenom = p;

    }

    //methodes



    public String getNom() {
        return nom;
    }

    public String getNIP() {
        return NIP;
    }
}