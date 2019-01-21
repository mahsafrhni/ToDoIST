package com.company;

public class WrongEmailFormatException extends Exception {
    WrongEmailFormatException(String message) {
        super(message);
    }
}
