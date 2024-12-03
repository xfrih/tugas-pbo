import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Simulator {
    private Field field;
    private List<Animal> animals;
    private int step;  
    private SimulatorView view;
    private static final int DEFAULT_ROW = 30;  
    private static final int DEFAULT_COL = 30;

    
    public Simulator(int depth, int width) {
        if(width <= 0 || depth <= 0){
            System.out.println("The dimensions must be greater than zero."); 
            System.out.println( "Using default values."); 
            depth = DEFAULT_ROW;
            width = DEFAULT_COL;
        }

        animals = new ArrayList<Animal>();
        field = new Field(depth, width);

        view = new SimulatorView(depth, width, field);
        view.setSymbol(Rabbit.class, 'R');
        view.setSymbol(Fox.class, 'F');
                
        reset(); 
    }

    public void simulate(int steps){
        for(int step = 0; step < steps; step++){
            simulateOneStep();
        }
    }

    public void reset(){
        step = 0;
        animals.clear();
        field.clearAll();
        populate();
        view.show(step, field);
    }

    public void simulateOneStep(){
        step++;

        List<Animal> newAnimals = new ArrayList<Animal>();
        for(Iterator<Animal> it = animals.iterator(); it.hasNext();){
            Animal animal = it.next();
            animal.act(newAnimals);
        }
        view.show(step, field);
    }

    private void populate(){
        field.clearAll();

        double foxProbability = 0.2;
        double rabbitProbability = 0.3;

        Random rand = new Random();
        for(int i=0;i<field.getRow();i++){
            for(int j=0;j<field.getCol();j++){
                Location location = new Location(i, j);
                
                if(rand.nextDouble() <= foxProbability){
                    Fox fox = new Fox(false, field, location);
                    animals.add(fox);
                    field.place(fox, location);
                }

                if(rand.nextDouble() <= rabbitProbability){
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                    field.place(rabbit, location);
                }
            }
        }
    }   
}