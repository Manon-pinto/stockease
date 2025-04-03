// ProduitNotFoundException.java
package com.stockease.api.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(String message) {
        super(message);
    }
}
