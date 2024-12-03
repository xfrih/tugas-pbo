public class Plant extends LivingBeing {
    public Plant(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " tumbuh menjadi tumbuhan.");
    }

    public void photosynthesize(){
        System.out.println(name + " sedang berfotosintesis.");
    }
}