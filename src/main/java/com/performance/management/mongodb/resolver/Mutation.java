package com.performance.management.mongodb.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.performance.management.common.PerformanceManagementUtils;
import com.performance.management.model.Feedback;
import com.performance.management.model.User;
import com.performance.management.repository.FeedbackRepository;
import com.performance.management.repository.UserRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PerformanceManagementUtils performanceManagementUtils;

	/*
	 * @Autowired public Mutation(FeedbackRepository feedbackRepository) {
	 * this.feedbackRepository = feedbackRepository; }
	 */

	public Feedback createFeedback(String feedbackRequestorId,String feedbackReceiversId) throws Exception {
		
		User user = userRepository.findById(feedbackRequestorId)
				.orElseThrow(() -> new RuntimeException("Error: Requestor User not found."));
		
		User feedbackReceiverUser = userRepository.findByEmployeeId(feedbackReceiversId)
				.orElseThrow(() -> new RuntimeException("Error: Receivers User not found."));
		
		User userManagers = userRepository.findByEmployeeId(user.getManagersId())
				.orElseThrow(() -> new RuntimeException("Error: Manager's User not found."));
		
		Feedback feedback = new Feedback();
		feedback.setId(performanceManagementUtils.generateSequence(Feedback.SEQUENCE_NAME) + "");
		feedback.setFeedbackRequestorId(user.getEmployeeId());
		feedback.setFeedbackRequestor(user);
		feedback.setFeedbackRequestorManagersId(user.getManagersId());
		feedback.setFeedbackRequestorManager(userManagers);
		feedback.setFeedbackReceiversId(feedbackReceiversId);
		feedback.setFeedbackReceiverUser(feedbackReceiverUser);
		feedback.setFeedbackAcceptedStatus("New");

		feedbackRepository.save(feedback);
		return feedback;
	}

	public Feedback updateFeedback(String id, String feedbackAcceptedStatus, String strengths, String improvements)
			throws Exception {
		Optional<Feedback> optFeedback = feedbackRepository.findById(id);

		if (optFeedback.isPresent()) {
			Feedback feedback = optFeedback.get();

			if (strengths != null)
				feedback.setStrengths(strengths);
			if (improvements != null)
				feedback.setImprovements(improvements);

			feedback.setFeedbackAcceptedStatus("Completed");

			feedbackRepository.save(feedback);
			return feedback;
		}

		throw new Exception("Not found Feedback to update!");
	}

	public boolean deleteUserByEmployeeId(String id) {
		userRepository.deleteByEmployeeId(id);
		return true;
	}
}