package com.te.ems.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.entity.Bank;

public class BankPojoTest {

	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	private String jsonString = "{\"name\":\"SBI\",\"accountNo\":783298,\"ifsc\":\"SBIN898OUN \"}";

	@Test
	void bank() throws JsonMappingException, JsonProcessingException {
		Bank build = Bank.builder().name("SBI").accountNo(12000l).ifsc("CBIN028").build();
		Bank readValue = mapper.readValue(jsonString, Bank.class);
		assertThat(build.equals(readValue));

	}
}
