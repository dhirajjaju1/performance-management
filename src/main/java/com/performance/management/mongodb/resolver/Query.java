package com.performance.management.mongodb.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.performance.management.model.Feedback;
import com.performance.management.model.User;
import com.performance.management.repository.FeedbackRepository;
import com.performance.management.repository.UserRepository;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Autowired public Query(FeedbackRepository feedbackRepository) {
	 * this.feedbackRepository = feedbackRepository; }
	 */

	public List<Feedback> findByFeedbackRequestorId(String feedbackRequestorId) {
		return feedbackRepository.findByFeedbackRequestorId(feedbackRequestorId);
	}
	
	public List<Feedback> getFeedbackByStatus(String feedbackRequestorId, String feedbackAcceptedStatus) {
		return feedbackRepository.findByFeedbackRequestorIdAndFeedbackAcceptedStatus(feedbackRequestorId, feedbackAcceptedStatus);
	}
	
	public Optional<User> findByUserName(String userName){
		return userRepository.findByUserName(userName);
	}
	
	public Optional<User> findByEmployeeId(String id){
		return userRepository.findByEmployeeId(id);
	}
	
	public List<User> findByEmployeeIdOrUserName(String id, String userName){
		return userRepository.findByEmployeeIdOrUserName(id, userName);
	}
	
	public List<User> findByManagersId(String id){
		return userRepository.findByManagersId(id);
	}
	
	public List<Feedback> getOpenFeedbackRequest(String feedbackReceiversId, String feedbackAcceptedStatus) {
		return feedbackRepository.findByFeedbackReceiversIdAndFeedbackAcceptedStatus(feedbackReceiversId, feedbackAcceptedStatus);
	}
}