package com.desmond.springboot.service;

import com.desmond.springboot.entity.Review;
import java.util.List;

public interface ReviewService {

    List <Review> getAllReviews();
    Review getReviewById(int id);
    Review deleteReview(int id);
    Review editReview(int reviewId, Review review);
    Review saveReview(Review review);

}
