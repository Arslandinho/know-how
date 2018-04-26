package com.base.knowhow.services;


import com.base.knowhow.models.Review;
import com.base.knowhow.models.User;
import com.base.knowhow.forms.ReviewForm;

import java.util.List;

public interface ReviewService {
    Review createReview(ReviewForm reviewForm, User reviewAuthor);

    List<Review> getAllReviews();

    Review getReviewById(Long id);

}
