/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if (animal instanceof AnimalZooFeroce)
            animal.faceBaie();
    }

    @Override
    public void calculeazaBonusSalarial() {
        int bonus = 0;
        bonus = bonus +valoareBonusPerAnimal * 2;

    }
}
