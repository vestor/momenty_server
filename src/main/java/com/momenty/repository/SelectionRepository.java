package com.momenty.repository;

import com.momenty.entity.Selection;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by manish on 13/09/16.
 */
public interface SelectionRepository extends Repository<Selection, String> {


    List<Selection> findAll();
    Optional<Selection> findOne(String id);
    Selection save(Selection selection);
//    List<Selection> save(List<Selection> selection);
    List<Selection> findByUserId(String userId);
}
