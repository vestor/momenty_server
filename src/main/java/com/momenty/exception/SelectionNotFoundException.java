package com.momenty.exception;

/**
 * Created by manish on 14/09/16.
 */
public class SelectionNotFoundException extends Exception {
    private String selectionId;

    public SelectionNotFoundException(String selectionId) {

        super("Selection with id " + selectionId + " not found");
        this.selectionId = selectionId;
    }
}
