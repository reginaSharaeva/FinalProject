package org.itis.gr404.entities;

import javax.persistence.*;

/**
 * Created by Regina on 11.04.2016.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private User CUSTOMER;

    @Column(name = "GOOD")
    private String good;

    @Column(name = "PRICE")
    private int price;

    public Order() {
    }

    public Order(User user, String good, int price) {
        this.CUSTOMER = user;
        this.good = good;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public User getUser() {
        return CUSTOMER;
    }

    public void setUser(User user) {
        this.CUSTOMER = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
