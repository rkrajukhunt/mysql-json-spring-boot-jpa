package com.emperorbrains.rajukhunt.mysql.json.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
public class Book extends Item{
	
	private String title;
	private String author;
	
	

}
