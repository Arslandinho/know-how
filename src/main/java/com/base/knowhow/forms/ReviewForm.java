package com.base.knowhow.forms;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewForm {

    private Date reviewDate;

    private String description;

    private String reviewName;

    private String gameTitle;

//    public ReviewForm(int score, Date reviewDate, String description, String reviewName) {
//        this.score = score;
//        this.reviewDate = reviewDate;
//        this.description = description;
//        this.reviewName = reviewName;
//    }

//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }
//
//    public Date getReviewDate() {
//        return reviewDate;
//    }
//
//    public void setReviewDate(Date reviewDate) {
//        this.reviewDate = reviewDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getReviewName() {
//        return reviewName;
//    }
//
//    public void setReviewName(String reviewName) {
//        this.reviewName = reviewName;
//    }
}
