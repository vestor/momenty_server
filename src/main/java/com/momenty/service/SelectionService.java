package com.momenty.service;

import com.momenty.exception.SelectionNotFoundException;
import com.momenty.pojo.SelectionDTO;

import java.util.Collection;
import java.util.List;

/**
 * Created by manish on 13/09/16.
 */
public interface SelectionService {
    /**
     * Saves a single selection to the database
     * @param selection
     * @return selection
     */
    SelectionDTO save(SelectionDTO selection);

    /**
     * Returns all the selections from the database
     * @return List of selections
     */
    List<SelectionDTO> findAll();

    /**
     * Save the provided list of selections to the database
     * @param selections
     * @return List of selections
     */
    List<SelectionDTO> saveAll(List<SelectionDTO> selections);

    /**
     * Returns a selection by the provided selection id
     * @param id
     * @return selection
     */
    SelectionDTO findById(String id) throws SelectionNotFoundException;

    /**
     * Returns a list of selections based on the provided user's id
     * @param userId
     * @return List of selections
     */
    List<SelectionDTO> findByUserId(String userId);
}
