package com.hz;

import products.BlenderWithIntegratedRadio;
import products.CuteTeddyBear;
import products.TVScreen;

public class Main {

    // Main scenario
    public static void main(String[] args) {

        // There is a shop with a checkout
        // For testing purposes, it's both Christmas and BlackFriday in this store
        Checkout kassa5 = new Checkout(SalesAction.BlackFriday);
        Checkout kassa3 = new Checkout(SalesAction.ChristmasEve);

        // Two customers enter the shop
        Customer piet = new Customer(CustomerType.Regular, "Piet");
        Customer anne = new Customer(CustomerType.New, "Anne");
        Customer andries = new Customer(CustomerType.New, "Andries");

        // buying stuff

        //piet wants bears
        piet.buys(new CuteTeddyBear());

        // To test max 80%, Andries wants to watch TV
        // Without discount, 100 * 897.99 = 89799.00
        // With correct discount .20 * 89799.00 = 17959,80
        for (int i = 1; i < 100; i++) {
            andries.buys(new TVScreen());
        }

        anne.buys(new CuteTeddyBear());

        // and proceed to checkout
        kassa5.nextInLine(piet);
        kassa5.nextInLine(andries);
        kassa3.nextInLine(anne);
    }
}
