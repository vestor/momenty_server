package com.momenty.impl;

import com.momenty.entity.Selection;
import com.momenty.exception.SelectionNotFoundException;
import com.momenty.pojo.SelectionDTO;
import com.momenty.repository.SelectionRepository;
import com.momenty.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manish on 13/09/16.
 */

@Service
public class SelectionServiceImpl implements SelectionService {

    private final SelectionRepository repository;

    @Autowired
    SelectionServiceImpl(SelectionRepository selectionRepository) {
        this.repository = selectionRepository;
    }

    @Override
    public SelectionDTO save(SelectionDTO selection) {
        Selection toReturn = repository.save(convertFromDTO(selection));
        return convertToDTO(toReturn);
    }

    @Override
    public List<SelectionDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SelectionDTO> saveAll(List<SelectionDTO> selections) {
//        List<Selection> selectionsList = selections.stream().map(this::convertFromDTO).collect(Collectors.toList());
//        return repository.save(selectionsList).stream().map(this::convertToDTO).collect(Collectors.toList());
        return null;
    }

    @Override
    public SelectionDTO findById(String id) throws SelectionNotFoundException {
        return convertToDTO(repository.findOne(id).orElseThrow(() -> new SelectionNotFoundException(id)));
    }

    @Override
    public List<SelectionDTO> findByUserId(String userId) {
        return repository.findByUserId(userId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private SelectionDTO convertToDTO(Selection selection) {
        SelectionDTO newDTO = new SelectionDTO();
        newDTO.setId(selection.getId());
        newDTO.setRange(selection.getRange());
        newDTO.setText(selection.getText());
        newDTO.setUrl(selection.getUrl());
        newDTO.setUserId(selection.getUserId());

        return newDTO;
    }

    private Selection convertFromDTO(SelectionDTO dto) {
        return Selection.getBuilder()
                .id(dto.getId())
                .range(dto.getRange())
                .text(dto.getText())
                .userId(dto.getUserId())
                .url(dto.getUrl()).build();
    }
}
