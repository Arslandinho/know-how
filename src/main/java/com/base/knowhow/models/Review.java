package com.base.knowhow.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review",schema = "public")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String reviewDate;

    @NotNull
    private String description;

    @NotNull
    @Column(name = "review_name")
    private String reviewName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }
//
//    public String getReviewDate() {
//        return reviewDate;
//    }
//
//    public void setReviewDate(String reviewDate) {
//        this.reviewDate = reviewDate;
//    }
}
