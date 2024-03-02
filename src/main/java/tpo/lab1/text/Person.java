package tpo.lab1.text;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Person extends Object{
    private String name;
    private Set<Quolity> quolities = new HashSet<>() ;
    private Gender gender;
}
