package tpo.lab1.text;

import lombok.Data;

@Data
public class Panel extends Object{

    private Ship ship;
    public Panel(){
        super("панель управления");
    }
    @Override
    public void destruct(){
        ship.destruct();
        super.destruct();
    }
    
}
