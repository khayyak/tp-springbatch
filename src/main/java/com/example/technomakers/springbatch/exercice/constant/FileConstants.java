package com.example.technomakers.springbatch.exercice.constant;

public class FileConstants {

    private FileConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String INPUT_FILE_NAME = "products.csv";
    public static final String[] HEADERS = {"productId", "productName", "quantityInStock", "unitPrice", "supplier"};
    public static final String HEADER = "productId,productName,quantityInStock,unitPrice,supplier";
    public static final String OUTPUT_FILE_NAME = "edited_products.csv";
}
