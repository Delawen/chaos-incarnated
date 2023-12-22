package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Cat {
	private String name;
	private Long id;

	@Id
	@SequenceGenerator(name = "catSeq", sequenceName = "cat_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "catSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
