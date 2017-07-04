import animalmananca.AnimalManancaOmException;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public  abstract class Animal {

    public abstract void mananca(Object obj) throws AnimalManancaOmException;
    public abstract void seJoaca();
    public abstract void faceBaie();

    public void doarme () {
        System.out.println("Animalul doarmne");
    }
}
