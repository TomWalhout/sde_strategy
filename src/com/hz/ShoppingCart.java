package com.hz;
import products.Product;

import java.util.ArrayList;

public class ShoppingCart extends ArrayList<Product> {

    public double getTotalPrice(DiscountCalculator discountCalculator) {

        double totalPrice = 0.0;

        for(Product product : this) {

            int index = this.indexOf(product);

            double discount = discountCalculator.getDiscount(product, index);
            double price = product.getPrice() * discount;

            totalPrice += price;
        }

        return totalPrice;
    }

    public double getNumberOfProducts() {
        double number = this.size();
        return number;
    }
}