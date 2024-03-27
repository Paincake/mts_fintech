package ru.mts.hwseven.exceptions;

import java.util.concurrent.ExecutionException;

public class NoEntityException extends ExecutionException {
    public NoEntityException(String message) {
        super(message);
    }
}
