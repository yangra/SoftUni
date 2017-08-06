package softuni.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    private Long id;
    private Integer discount;

    private Car car;
    private Customer customer;

    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

