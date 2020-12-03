package com.techtorial;

public class Instructions {


    public static void getInstructions(int input) {

        switch (input) {
            case 0:
                System.out.println("0 - to list available options. \n1 List all available options. \n2 Get item/product info, price & inventory number.\n3 Select a product" +
                        "\n4 Get item/product price. \n5 List all prices. \n6 Set price range. \n7 Exit. \n8 Buy an item");

                /*
                 * Vending machine options are:
                 * 0 - list available options
                 * 1 - List all items/products, names of products
                 * 2 - Get item/product info (details, availability), price and inventory number
                 * 3 - Select a product
                 * 4 - Get item/product price
                 * 5 - List all prices
                 * 6 - Set price range
                 * 7 - Exit
                 * 8 - Buy an item
                 */
            default:
                System.out.println("Please enter 0");
        }
    }

}
