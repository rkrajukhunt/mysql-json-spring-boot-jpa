package com.emperorbrains.rajukhunt.mysql.json.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emperorbrains.rajukhunt.mysql.json.demo.converter.ItemConverter;

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
@Entity
@Table
public class Store {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String name;
	
	@Convert(converter = ItemConverter.class)
	@Column(columnDefinition = "json")
	private List<Item> items = new ArrayList<>();

}
