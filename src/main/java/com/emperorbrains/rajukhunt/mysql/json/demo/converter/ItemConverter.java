package com.emperorbrains.rajukhunt.mysql.json.demo.converter;

import java.util.List;

import javax.persistence.AttributeConverter;

import com.emperorbrains.rajukhunt.mysql.json.demo.entity.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemConverter implements AttributeConverter<List<Item>, String> {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(List<Item> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public List<Item> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData,new TypeReference<List<Item>>() {});
		} catch (Exception e) {
			return null;
		}
	}
	
}
