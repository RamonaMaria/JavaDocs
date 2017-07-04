import animalmananca.AnimalManancaOmException;
import animalpecalededisparitie.AnimalPeCaleDeDisparitieException;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    @Override
    public void lucreaza(Animal animal) {
        System.out.println("ingrijitorul intra in cusca animalului");
    }

    @Override
    public void calculeazaBonusSalarial() {
        int bonus = 0;
        bonus = bonus + valoareBonusPerAnimal * 3;

    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException, AnimalManancaOmException {
        if (animal instanceof AnimalZooRar && mancare == null)
            throw new AnimalPeCaleDeDisparitieException();
        this.lucreaza(animal);
        animal.doarme();
        animal.faceBaie();
        animal.mananca(mancare);
        animal.seJoaca();

    }

}
