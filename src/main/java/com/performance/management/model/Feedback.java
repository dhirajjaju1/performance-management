package com.performance.management.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "feedback")
//Class
public class Feedback {
  
	@Transient
    public static final String SEQUENCE_NAME = "feedback_sequence";
	
    // Attributes
    @Id 
    private String id;
    private String feedbackRequestorId;
    @DBRef
    private User feedbackRequestor;
    
    private String feedbackRequestorManagersId;
    @DBRef
    private User feedbackRequestorManager;
    
    private String feedbackReceiversId;
    @DBRef
    private User feedbackReceiverUser;
    
    private String feedbackAcceptedStatus;
    private String strengths;
    private String improvements;
    private Date feedbackRequestedDate;
    private Date feedbackResponseRecdDate;
    
    
}