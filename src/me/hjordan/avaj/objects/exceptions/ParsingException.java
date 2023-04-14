package me.hjordan.avaj.objects.exceptions;

import java.io.IOException;

public class ParsingException extends IOException {

    public ParsingException(String message, Throwable cause) {
        super("[AVAJ] " + message, cause);
    }

    public ParsingException(String message) {
        super("[AVAJ] " + message);
    }

    public void exit() {
        System.err.println(this.getMessage());
        System.exit(1);
    }

}
