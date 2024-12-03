public class Human extends LivingBeing {
    public Human(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " tumbuh menjadi manusia.");
    }

    public void speak(String sentence){
        System.out.println(name + " berkata: " + sentence);
    }
}