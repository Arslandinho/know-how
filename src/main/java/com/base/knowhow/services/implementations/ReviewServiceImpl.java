package com.base.knowhow.services.implementations;

import com.base.knowhow.forms.ReviewForm;
import com.base.knowhow.models.Review;
import com.base.knowhow.models.User;
import com.base.knowhow.repositories.ReviewRepository;
import com.base.knowhow.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(ReviewForm reviewForm, User reviewAuthor) {
        Date date = new Date();
        Review newReview = Review.builder()
                .reviewName(reviewForm.getReviewName())
                .user(reviewAuthor)
                .reviewDate(String.valueOf(date))
                .description(reviewForm.getDescription())
                .build();
        reviewRepository.save(newReview);
        return newReview;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.getReviewById(id);
    }
}
