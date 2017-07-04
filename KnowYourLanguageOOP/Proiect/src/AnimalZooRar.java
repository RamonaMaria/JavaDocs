import animalmananca.AnimalManancaOmException;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {
    String nume;
    String numeleTariiDEOrigine;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumeleTariiDEOrigine() {
        return numeleTariiDEOrigine;
    }

    public void setNumeleTariiDEOrigine(String numeleTariiDEOrigine) {
        this.numeleTariiDEOrigine = numeleTariiDEOrigine;
    }
    public AnimalZooRar() {
    }

    public AnimalZooRar(String nume) {
        this.nume = nume;
    }

    public AnimalZooRar(String nume, String numeleTariiDEOrigine) {
        this.nume = nume;
        this.numeleTariiDEOrigine = numeleTariiDEOrigine;
    }


    @Override
    public void mananca(Object obj) throws AnimalManancaOmException {
        if (obj instanceof AngajatZoo) {
            throw  new AnimalManancaOmException();
        } else {
            System.out.println("AnimalZooRar mananca");
        }
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");

    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }

    @Override
    public void doarme() {
        super.doarme();
    }
}
