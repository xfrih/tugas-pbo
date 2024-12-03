public class Animal extends LivingBeing {
    public Animal(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " tumbuh menjadi hewan.");
    }

    public void move(){
        System.out.println(name + " sedang bergerak.");
    }
}