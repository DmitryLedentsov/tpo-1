package tpo.lab1.text;

public class Assistant extends Person{
    public Assistant(String name){
        setGender(Gender.FEMALE);
        setStrength(10);
    }

    public boolean block(Person p){
        return this.getStrength()>p.getStrength();
    }

}
