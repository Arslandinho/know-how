package com.base.knowhow.repositories;

import com.base.knowhow.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    List<Review> findAll();

    Review getReviewById(Long id);
}
