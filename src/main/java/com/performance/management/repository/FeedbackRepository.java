package com.performance.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.performance.management.model.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
	List<Feedback> findByFeedbackRequestorId(String feedbackRequestorId);

	List<Feedback> findByFeedbackRequestorIdAndFeedbackAcceptedStatus(String feedbackRequestorId, String feedbackAcceptedStatus);
	
	List<Feedback> findByFeedbackReceiversIdAndFeedbackAcceptedStatus(String feedbackReceiversId, String feedbackAcceptedStatus);
	/*
	 * @Query("{ 'id' : ?0 }") Optional<Feedback> findById(String id);
	 */
}
