import java.util.List;
import java.util.Random;

public abstract class Animal {
    protected int age;
    protected boolean alive;
    protected Field field;
    protected Location location;
    protected static final Random rand = new Random();
    
    public Animal(boolean randomAge, Field field, Location location){
        if(randomAge){
            this.age = rand.nextInt(getMaxAge());
        }else{
            this.age = 0;
        }
        this.alive = true;
        this.field = field;
        setLocation(location);
    }

    public int getAge(){
        return age;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setDead(){
        alive = false;
        if(location != null){
            field.clear(location);
            location = null;
        }
        field = null;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location newLocation){
        if(location != null){
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public boolean canBreed(){
        return age >= getBreedingAge();
    }

    protected void incrementAge(){
        age++;
        if(age > getMaxAge()){
            setDead();
        }
    }

    protected void giveBirth(List<Animal> newAnimals){
        if(location == null) return;

        List<Location> free = field.allFreeAdjacentLocations(location);
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++){
            Location loc = free.remove(0);
            Animal young = createOffspring(false, field, loc);
            newAnimals.add(young);
        }
    }

    protected int breed(){
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()){
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    public abstract void act(List<Animal> newAnimals);

    abstract protected int getBreedingAge();  
    
    abstract protected int getMaxAge();  
    
    abstract protected double getBreedingProbability();  
    
    abstract protected int getMaxLitterSize();
    
    abstract protected Animal createOffspring(Field field, Location location);  
}