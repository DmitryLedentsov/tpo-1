package tpo.lab1.text;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Object{
    private String name;
    private List<Quolity> quolities = new LinkedList<>() ;
    private Gender gender;
    private int strength = 10;

    public Person(String name){
        super(name);
    }
}
