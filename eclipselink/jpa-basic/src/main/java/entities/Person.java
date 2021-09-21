package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //@ManyToMany
    //private Set<Address> addresses = new HashSet<Address>();
    @ManyToMany
    @JoinTable(name= "jnd_per_adr",joinColumns = @JoinColumn(name="Person_fk"),
            inverseJoinColumns = @JoinColumn(name = "adr_fk"))
    private List<Address> addresses = new ArrayList<Address>();

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name +
                ", addresses='" + addresses +
                '}';
    }
}
