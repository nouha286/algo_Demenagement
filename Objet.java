package algo_Demenagement;

public class Objet {
int id;
String nom;
Carton carton;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Carton getCarton() {
        return carton;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", carton=" + carton +
                '}';
    }

    public void setCarton(Carton carton) {
        this.carton = carton;
    }

    public Objet(int id, String nom, Carton carton) {
        this.id = id;
        this.nom = nom;
        this.carton = carton;
    }


}
