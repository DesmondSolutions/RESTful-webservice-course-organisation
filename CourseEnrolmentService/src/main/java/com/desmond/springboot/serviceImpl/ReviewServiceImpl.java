package com.desmond.springboot.serviceImpl;

import com.desmond.springboot.exception.ReviewNotFoundException;
import com.desmond.springboot.entity.Review;
import com.desmond.springboot.repository.ReviewRepository;
import com.desmond.springboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(){

    }
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepository.findById(id).orElseThrow(() ->
                new ReviewNotFoundException(id));
    }

    @Override
    public Review deleteReview(int id) {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
        return review;
    }

    @Override
    @Transactional
    public Review editReview(int reviewId, Review review) {
        Review reviewToEdit = getReviewById(reviewId);
        reviewToEdit.setComments(review.getComments());
        return reviewToEdit;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
