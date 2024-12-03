import java.util.List;
import java.util.Iterator;

public class Fox extends Animal{
    private static final int RABBIT_ENERGY_VALUE = 10; 
    private static final int BREEDING_AGE = 10;
    private static final int MAX_AGE = 70;
    private static final double BREEDING_PROBABILITY = 0.15;
    private static final int MAX_LITTER_SIZE = 3;
    private static final int INITIAL_ENERGY = 20;
    private int energyLevel;

    public Fox(boolean randomAge, Field field, Location location){
        super(randomAge, field, location);
        energyLevel = INITIAL_ENERGY;
    }

    @Override
    public void act(List<Animal> newFoxes){
        incrementAge();
        incrementHunger();
        if(isAlive()){
            giveBirth(newFoxes);
            Location newLocation = findFood();
            if(newLocation == null){
                newLocation = field.freeAdjacentLocation(location);
            }
            if(newLocation != null){
                setLocation(newLocation);
            }else{
                setDead();
            }
        }
    }

    private Location findFood(){
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where); 
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal; 
                if(rabbit.isAlive()) {
                    rabbit.setDead();
                    energyLevel += RABBIT_ENERGY_VALUE;
                    return where;    
                } 
            }
        }
        return null;
    }

    private void incrementHunger(){
        energyLevel--;
        if(energyLevel <= 0){
            setDead();
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
        return new Fox(false, field, location);
    }
}