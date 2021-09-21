package entities;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Integer limit;

    private Integer balance;

    @ManyToOne
    private Person owner;

    @OneToOne
    private Pincode pin_id;

    @ManyToOne Bank bank;

    public Long getId(){
        return id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setLimit(Integer aLim){
        this.limit = aLim;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public Pincode getPin_id() {
        return pin_id;
    }

    public void setPin_id(Pincode pin_id) {
        this.pin_id = pin_id;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", limit=" + limit + '\'' +
                ", balance=" + balance + '\'' +
                ", owner=" + owner + '\'' +
                ", pin=" + pin_id + '\'' +
                ", bank=" + bank +
                '}';
    }
}
