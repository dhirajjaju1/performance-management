package com.performance.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {
    
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
    @Id
    private String id;

    @DBRef
    private Institution institution;
    
    @NotBlank
    private String employeeId;

    @NotBlank
    @Size(max = 20)
    private String userName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(max = 120)
    private String password;
    
    @NotBlank
    private String managersId;

    @DBRef
    private Set<Role> roles = new HashSet<>();

	/**
	 * @param institution
	 * @param employeeId
	 * @param username
	 * @param email
	 * @param password
	 * @param managersId
	 */
	public User(@NotBlank @Size(max = 20) String userName,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank String managersId) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.managersId = managersId;
	}
    
	/*
	 * public User(String username, String email, String password) { this.username =
	 * username; this.email = email; this.password = password; }
	 */
    
}