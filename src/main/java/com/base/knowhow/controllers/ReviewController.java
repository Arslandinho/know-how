package com.base.knowhow.controllers;

import com.base.knowhow.forms.ReviewForm;
import com.base.knowhow.models.Review;
import com.base.knowhow.models.User;
import com.base.knowhow.services.AuthenticationService;
import com.base.knowhow.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private AuthenticationService authenticationService;

    private List<User> authors = new ArrayList<>();


    @GetMapping("/addReview")
    public String getPage(Authentication authentication, ReviewForm reviewForm) {
    if (authentication==null){
        return "redirect:/signIn";
    }

        return "review-form";
    }

    @PostMapping("addReview")
    public String sendReview(Authentication authentication, ReviewForm reviewForm){
        User reviewAuthor = authenticationService.getUserByAuthentication(authentication);
        reviewService.createReview(reviewForm,reviewAuthor);

        return "redirect:/reviews";
    }

    @GetMapping("/reviews")
    public String getAllReviews(Model model){
        List<Review> allReviews = reviewService.getAllReviews();
        model.addAttribute("review",allReviews);

        for (Review review : allReviews){
            User author = review.getUser();
                authors.add(author);
        }
        model.addAttribute("allAuthors",authors);

        return "reviews";
    }
    @GetMapping("/review/{id}")
    public String findReview(@PathVariable("id") Long id, Model model){
        Review review = reviewService.getReviewById(id);
        model.addAttribute("review",review);

        return "review";
    }

}
