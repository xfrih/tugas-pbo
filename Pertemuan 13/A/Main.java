public abstract class LivingBeing {
    protected String name;

    public LivingBeing(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void breathe(){
        System.out.println(name + " is breathing.");
    }

    public abstract void grow();
}