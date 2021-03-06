package com.corneliacalin.sda.onlineanimalshop.repository;

import com.corneliacalin.sda.onlineanimalshop.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long> {

    List<Category> findAllByParentIsNull ();

}
