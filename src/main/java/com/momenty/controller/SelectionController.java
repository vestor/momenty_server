package com.momenty.controller;



import com.momenty.exception.SelectionNotFoundException;
import com.momenty.pojo.SelectionDTO;
import com.momenty.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by manish on 13/09/16.
 */
@RestController
@RequestMapping("/api/selection")
public class SelectionController {

    private final SelectionService selectionService;

    @Autowired
    private SelectionController(SelectionService selectionService){
        this.selectionService = selectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SelectionDTO createSelection(@Valid @RequestBody SelectionDTO selection, BindingResult bindingResult){
        return selectionService.save(selection);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public SelectionDTO updateSelection(@Valid @RequestBody SelectionDTO selection, BindingResult bindingResult) {
        return selectionService.save(selection);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectionDTO> findByUserId(@PathVariable @NotNull String userId) {
        return selectionService.findByUserId(userId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(SelectionNotFoundException ex) {
    }

}
