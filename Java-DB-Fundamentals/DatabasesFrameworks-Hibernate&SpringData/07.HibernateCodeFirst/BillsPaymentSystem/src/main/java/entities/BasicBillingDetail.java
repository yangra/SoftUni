package entities;

import javax.persistence.*;

@Entity
@Table(name="billing_details")
//@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicBillingDetail implements BillingDetail {
    private Long id;
    private String number;
    private User owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    @ManyToOne
    @JoinColumn(name= "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return this.owner;
    }
}
