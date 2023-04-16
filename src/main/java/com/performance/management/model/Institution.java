package com.performance.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
@Document(collection = "institution")
//Class
public class Institution {
  
	@Transient
    public static final String SEQUENCE_NAME = "institution_sequence";
	
    // Attributes
    @Id 
    private String id;
    private String institutionName;
    private String institutionType;
    private String institutionAddress;
}