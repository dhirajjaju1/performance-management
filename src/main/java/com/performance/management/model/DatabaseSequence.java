package com.performance.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "database_sequences")
public class DatabaseSequence {

	@Id
	private String id;
	private long seq;
}