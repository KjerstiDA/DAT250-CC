package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons = new ArrayList<Person>();

    //@ManyToMany
    //private Set<Person> people = new HashSet<Person>();

    public void setNumber(Integer aNumber){
        this.number = aNumber;}

    public Integer getNumber(){
        return number;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String aStreet){
        this.street = aStreet;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number + '\'' +
                ", person=" + persons +
                '}';
    }


}
