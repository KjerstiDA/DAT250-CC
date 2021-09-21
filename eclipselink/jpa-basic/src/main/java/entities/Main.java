package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "Creditcards";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        // create test bank
        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);

        // create test address
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        em.persist(address);

        // create test person
        Person person = new Person();
        person.setName("Max Musterman");
        person.getAddresses().add(address);
        em.persist(person);

        // create test pin 1
        Pincode pin1 = new Pincode();
        pin1.setPin("123");
        pin1.setCount(1);
        em.persist(pin1);

        // create test card 1
        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(5000);
        card1.setLimit(10000);
        card1.setOwner(person);
        card1.setPin_id(pin1);
        card1.setBank(bank);
        em.persist(card1);

        // create test pin 2
        Pincode pin2 = new Pincode();
        pin2.setPin("123");
        pin2.setCount(1);
        em.persist(pin2);

        // create test card 2
        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);
        card2.setOwner(person);
        card2.setPin_id(pin2);
        card2.setBank(bank);
        em.persist(card2);

        em.getTransaction().commit();
        em.close();
    }
}
