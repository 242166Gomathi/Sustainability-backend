package com.project.sustainability.exception;

/**
 * Custom exception to be thrown when a resource is not found.
 * Extends RuntimeException to indicate an unchecked exception.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message The detail message which is saved for later retrieval
     *                by the {@link #getMessage()} method.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
