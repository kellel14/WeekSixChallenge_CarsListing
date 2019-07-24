package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CarAndCategoryRepository extends
        CrudRepository<CarAndCategory, Long>{

//    Iterable<CarAndCategory> findAllByVehicle_Id(Long category_id);
    Iterable<CarAndCategory> findAllByCategory(Category category);


}
