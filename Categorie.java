package algo_Demenagement;

public enum Categorie {

    Vetement(1),
    accessoire(2),
    chaussure(3);

    int id;

    Categorie(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
