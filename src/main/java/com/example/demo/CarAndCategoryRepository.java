package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CarAndCategoryRepository extends
        CrudRepository<CarAndCategory, Long>{

    Iterable<CarAndCategory> findAllByCarType_id(Long vehicle_id);

}
