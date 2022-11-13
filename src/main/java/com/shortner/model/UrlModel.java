package com.shortner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "urls")

@Getter

@Setter
public class UrlModel {

	@Id
	@GeneratedValue
	private int id;

	private String longURL;

	private String slug;
}
