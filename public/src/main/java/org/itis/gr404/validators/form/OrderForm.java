package org.itis.gr404.validators.form;

import org.itis.gr404.entities.User;

/**
 * Created by Регина on 24.04.2016.
 */
public class OrderForm {

    private String good;

    private String price;

    private String userLogin;

    public OrderForm() {
    }

    public OrderForm(String good, String price, String userLogin) {
        this.good = good;
        this.price = price;
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }
}
