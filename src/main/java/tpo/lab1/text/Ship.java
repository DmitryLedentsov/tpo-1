package tpo.lab1.text;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class Ship extends Object{
    private Panel controlPanel;
    private LinkedList<Person> crew = new LinkedList<>();
    public Ship(String name){
        super(name);
    }

    public void addCrewMember(Person p){
        crew.add(p);
    }

    public boolean containsCrewMember(Person p){
        return crew.contains(p);
    }

    public void setControlPanel(Panel p){
        p.setShip(this);
    }

    @Override
    public void destruct(){
        crew.forEach((p)->p.destruct());
        super.destruct();
    }



    
}
