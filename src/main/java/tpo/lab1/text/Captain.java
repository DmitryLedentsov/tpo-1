package tpo.lab1.text;


public class Captain extends Person{
    public Captain(String name){
        setName(name);
        setGender(Gender.MALE);
        setStrength(20);
    }
    public void drumWithFingers(Object o){
        destroy(o);
    }

    public void destroy(Object o){
        o.destruct();
    }


}
