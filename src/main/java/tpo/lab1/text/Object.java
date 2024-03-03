package tpo.lab1.text;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class Object implements Destroyable {
    
    private String name;
    public Object(String n){
        name = n;
    }

    @Setter
    @Getter
    private boolean destroyed = false;
    @Override
    public void destruct(){
        setDestroyed(true);
        System.out.println("Объект " + name + " был уничтожен");
    }
}
