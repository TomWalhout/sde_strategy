package com.hz;

import products.Product;

public class DiscountCalculator {

    private Customer customer;

    public void setChristmasEve(boolean christmasEve) {
        isChristmasEve = christmasEve;
    }
    public void setBlackFriday(boolean blackFriday) { isBlackFriday = blackFriday; }

    private boolean isChristmasEve;
    private boolean isBlackFriday;

    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }

    public double getDiscount(Product product, int index) {

        double discount = 0.0;

        boolean isFirstProduct = index == 0;

        // on Christmas Eve, 1st product 20%, the next 12.5% discount
        if(isChristmasEve) {

            if(isFirstProduct) {
                discount = .20;
            } else {
                discount = .125;
            }

        }

        // On Black Friday, things go crazy. Every customer is awarded a discount equal to the number of products in their basket, up to 80% off!
        else if (isBlackFriday) {
            // if the index is more than 80, discount is 80%
            double numOfProducts = customer.getCart().getNumberOfProducts();
            if (numOfProducts > 80) {
                discount = .80;
            } else {
                // Divide by 100 to convert to percentage
                discount = numOfProducts / 100;
            }
        }

        // Default situation: new customers full price, regular 15% off
        else if(customer.isRegular()) {
            discount = .15;
        }

        return 1 - discount;
    }
}
