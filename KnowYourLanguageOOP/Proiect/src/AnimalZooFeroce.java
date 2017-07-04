import animalmananca.AnimalManancaOmException;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {
    @Override
    public void mananca(Object obj) throws AnimalManancaOmException{
        if (obj instanceof AngajatZoo) {
            throw  new AnimalManancaOmException();
        } else {
            System.out.println("AnimalZooFeroce mananca");
        }
    }

    @Override
    public void seJoaca() {
        System.out.println("suprascriu seJoaca");
    }

    @Override
    public void faceBaie() {
        System.out.println("suprascriu faceBaie");
    }

    @Override
    public void doarme() {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
