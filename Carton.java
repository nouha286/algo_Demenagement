package algo_Demenagement;

public class Carton {


int numero;
Categorie categorie;
    Carton carton;
    Demenagement demenagement;


    public Carton( int numero, Carton carton, Categorie categorie, Demenagement demenagement)
        {
        this.numero = numero;
        this.categorie = categorie;
        this.carton=carton;
        this.demenagement=demenagement;

    }


    public Carton()
    {

    }

    @Override
    public String toString() {
        return "Carton{" +
                "numero=" + numero +
                ", categorie=" + categorie +
                ", carton=" + carton +
                ", demenagement=" + demenagement +
                '}';
    }
}
