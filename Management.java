package algo_Demenagement;

import java.util.ArrayList;
import java.util.List;

public class Management {
    ArrayList<Carton> cartons=new ArrayList<Carton>();
    ArrayList<Objet> objets=new ArrayList<Objet>();
    ArrayList<Demenagement> demenagements=new ArrayList<Demenagement>();

    //methode pour l'ajout d'un déménagement======================================================================================
    public void addDemenagement(Demenagement demenagement)
    {
        demenagements.add(demenagement);
    }


    public ArrayList<Demenagement> getDemenagements() {
        return demenagements;
    }

    public Demenagement findDemenagementById(int id) {
        Demenagement dem = null;
        for (Demenagement demenagement : demenagements) {
            if (demenagement.id == id) {
                dem = demenagement;
            }
        }
        return dem;
    }

    //methode pour l'ajout d'un carton======================================================================================
public void addCarton(Carton carton)
{
    cartons.add(carton);
}

    public ArrayList<Carton> getCartons() {
        return cartons;
    }

    public Carton findCartonByNumero(int num) {
        Carton cart = null;
        for (Carton carton : cartons) {
            if (carton.numero == num) {
                cart = carton;
            }
        }
        return cart;
    }

    public void displayCarton()
    {
        for (Carton carton: cartons
             ) {
            System.out.println(carton);

        }
    }

    public void afficherCartonContennu(Carton cartonRecherche)
    {
        for (Carton carton: cartons)
        {
            if (carton.carton==cartonRecherche)
            {
                System.out.println("carton numéro: "+carton.numero);
            }
        }

    }
    public void afficherObjetContenu(Carton cartonRecherche)
    {


            for (Objet objet:objets)
            {
                if (objet.carton==cartonRecherche)
                {
                    System.out.println(objet.id+"-"+objet.nom);
                }
            }


    }
    public Carton cartonPlusExterne(Objet objet)
    {
        Carton c=null;
         for (Carton carton:cartons)
         {
             if(objet.carton==carton)
             {
                c=carton;

             }
         }
if(c==null) return c;
            while (c.carton != null) {
                c =c.carton;
            }

        return c;
    }


//methode pour l'ajout d'un objet======================================================================================
public void addObjet(Objet objet)
{
    objets.add(objet);
}


    public ArrayList<Objet> getObjets() {
        return objets;
    }

    public Objet findObjetById(int id) {
        Objet obj = null;
        for (Objet objet : objets) {
            if (objet.id==id) {
                obj = objet;
            }
        }
        return obj;
    }


    //Catégorie=================================================================================================
    public Categorie findCategorieById(int id)
    {
       Categorie catlist=null;
        for (Categorie categorie:Categorie.values())
        { if (categorie.getId()==id)
        {
            catlist=categorie;
        }
    }
        return catlist;}


    @Override
    public String toString()
    {
        return "Management{" +
                "cartons=" + cartons +
                ", objets=" + objets +
                ", demenagements=" + demenagements +
                '}';
    }
}

