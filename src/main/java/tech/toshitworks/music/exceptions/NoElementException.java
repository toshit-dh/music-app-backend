package tech.toshitworks.music.exceptions;

import java.util.NoSuchElementException;

public class NoElementException extends NoSuchElementException {
    public NoElementException(String entity,String param,String value) {
        super("No such element of " + entity + " for " + param + " " + value);
    }
}
