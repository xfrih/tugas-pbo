import java.util.List;

public class Rabbit extends Animal{
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 50;
    private static final double BREEDING_PROBABILITY = 0.15;
    private static final int MAX_LITTER_SIZE = 5;

    public Rabbit(boolean randomAge, Field field, Location location){
        super(randomAge, field, location);
    }

    @Override
    public void act(List<Animal> newRabbits){
        incrementAge();
        if(isAlive()){
            giveBirth(newRabbits);
            Location newLocation = field.freeAdjacentLocation(location);
            if(newLocation != null){
                setLocation(newLocation);
            }else{
                setDead();
            }
        }
    }

    protected int getBreedingAge(){
        return BREEDING_AGE;
    }

    protected int getMaxAge(){
        return MAX_AGE;
    }

    protected double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }

    protected int getMaxLitterSize(){
        return MAX_LITTER_SIZE;
    }

    @Override
    protected Animal createOffspring(Field field, Location location){
        return new Rabbit(false, field, location);
    }
}