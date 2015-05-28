package com.moilioncircle.release.r016;

import javax.persistence.Column;

public class JavaAuthor {

	@Column(name="java",columnDefinition="varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL")
	private String java;//  `java` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

	@Column(name="author",columnDefinition="varchar(255) NOT NULL")
	private String author;//  `author` varchar(255) NOT NULL,
	
	
	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

}
