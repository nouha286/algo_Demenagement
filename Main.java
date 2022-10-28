package algo_Demenagement;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner inString= new Scanner(System.in);
        Scanner inInteger= new Scanner(System.in);
        Management carton=new Management();
        Management demenagement=new Management();
        Management objet=new Management();


        int choix;

          do {

              System.out.println("=====================================================================");
              System.out.println("Bonjour, Entrez votre choix pour organiser vos déménagement");
              System.out.println("1-Ajouter un déménagement.");
              System.out.println("2-Ajouter une carton.");
              System.out.println("3-Ajouter un objet.");
              System.out.println("4-Afficher les déménagement.");
              System.out.println("5-Afficher les cartons");
              System.out.println("6-Afficher les objets.");
              System.out.println("7-Afficher le contenu d’un carton donné. ");
              System.out.println("8-Trouver le numéro du carton où se trouve un objet de nom donné.");

               choix=inInteger.nextInt();
switch (choix)
{
    case 1:
        System.out.println("Entrez l'id du déménagement:");
        int id=inInteger.nextInt();
        System.out.println("Entrez le nom du déménagement:");
        String nom=inString.nextLine();
        Demenagement demenagement1=new Demenagement(id,nom);
        demenagement.addDemenagement(demenagement1);

        break;

    case 2:
        System.out.println("Entrez le numéro du carton");
        int numéro=inInteger.nextInt();
        int idCategorie=0;
        int dem=0;


        System.out.println("Sélectionnez le carton dans laquelle vous voulez stocker cette carton ");
        if(carton.getCartons().size()>0)
        {
            for (Carton carton1: carton.cartons)
            {
                System.out.println( carton1.numero+"-carton numéro "+carton1.numero +"dont la catégorie: "+carton1.categorie);
            }
        }
        System.out.println("0-ne le stocker dans aucun carton");
        int cart=inInteger.nextInt();
        if (cart==0)
        {
            System.out.println("Séléctionner la catégorie");
            for (Categorie categorie:Categorie.values() ) {
                System.out.println(categorie.getId()+"-"+categorie);
            }
            idCategorie=inInteger.nextInt();

            System.out.println("Sélectionnez le déménagement");
            if(demenagement.getDemenagements().size()>0)
            {
                for (Demenagement demenagement2: demenagement.demenagements)
                {
                    System.out.println( demenagement2.id +"-"+demenagement2.nom);
                }
                dem=inInteger.nextInt();
            }
        }

        Carton cartonPAR=null;
        Demenagement demPAR=null;
        Categorie catPAR=null;
        if (cart!=0 )
        {
          cartonPAR=carton.findCartonByNumero(cart);
        }
        if (dem!=0 )
        {
             demPAR=demenagement.findDemenagementById(dem);
        }

        if (idCategorie!=0 )
        {
             catPAR=carton.findCategorieById(idCategorie);
        }

        if(idCategorie==0)
        {
            Carton carton1=new Carton(numéro,cartonPAR,cartonPAR.categorie,cartonPAR.demenagement);
            carton.addCarton(carton1);
        }
        else {
            Carton carton1=new Carton(numéro,cartonPAR,catPAR,demPAR);
            carton.addCarton(carton1);
        }

        carton.displayCarton();

        break;

    case 3:
        System.out.println("Entrez l'id d'objet:");
        int idobj=inInteger.nextInt();
        System.out.println("Entrez le nom d'objet:");
        String nomObj=inString.nextLine();


            System.out.println("Sélectionner le carton ou vous voulez entrer l'objet:");
            for (Carton carton2: carton.cartons)
            {
                System.out.println( carton2.numero +"-Carton numéro :"+carton2.numero+"du déménagement: "+carton2.demenagement.nom);
            }
            System.out.println("0-ne le stocker dans aucun carton");

            int num_carton=inInteger.nextInt();
            if (num_carton==0)
            {
                Objet obj=new Objet(idobj,nomObj,null);
                objet.addObjet(obj);
            }
            else
            {
                Objet obj=new Objet(idobj,nomObj,carton.findCartonByNumero(num_carton));
                objet.addObjet(obj);
            }




        System.out.println(objet.getObjets());


        break;
    case 4:
        if(demenagement.getDemenagements().size()>0)
        {
            for (Demenagement demenagement2: demenagement.demenagements)
            {
                System.out.println( demenagement2.id +"-"+demenagement2.nom);
            }

        }else {
            System.out.println("La table des déménagements est vide.");
        }

        break;
    case 5:
        if(carton.getCartons().size()>0)
        {
            for (Carton carton2: carton.cartons)
            {
                System.out.println( "carton numéro "+carton2.numero +"dont la catégorie: "+carton2.categorie);
            }
        }
        else
        {
            System.out.println("La table des cartons est vide.");
        }

        break;
    case 6:
        if(objet.getObjets().size()>0)
        {
            for (Objet objet1: objet.objets)
            {
                System.out.println( objet1.id +"-"+objet1.nom);
            }
        }
        else
        {
            System.out.println("La table des objets est vide.");
        }
        break;

    case 7:
        System.out.println("Veuillez choisir le carton que vous voulez afficher son contenu");
        if(carton.getCartons().size()>0)
    {
        for (Carton carton2: carton.cartons)
        {
            System.out.println( "carton numéro: "+carton2.numero +" dont la catégorie: "+carton2.categorie);
        }
    }


    else
    {
        System.out.println("La table des cartons est vide.");
        break;
    }
        int choixCarton=inInteger.nextInt();
        Carton carton1=carton.findCartonByNumero(choixCarton);
        carton.afficherCartonContennu(carton1);
        objet.afficherObjetContenu(carton1);

        break;

    case 8:
        System.out.println("Veuillez choisissez l'objet que vous voulez trouvez son emplacement: ");

        if(objet.getObjets().size()>0)
        {
            for (Objet objet1: objet.objets)
            {
                System.out.println( objet1.id +"-"+objet1.nom);
                System.out.println(" ");
            }
        }
        else
        {
            System.out.println("La table des objets est vide.");
            break;
        }
        int choixObjet=inInteger.nextInt();
        Objet objet1=objet.findObjetById(choixObjet);
        System.out.println(objet1);
        if(carton.cartonPlusExterne(objet1)==null)
        {
            System.out.println("Le numéro du carton le plus externe est ");
            System.out.println("-1");
            break;
        }
        System.out.println("Le numéro du carton le plus externe est "+carton.cartonPlusExterne(objet1).numero);

        break;
}

          }while (choix!=0);

    }
}
