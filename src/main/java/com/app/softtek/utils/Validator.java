package com.app.softtek.utils;

import com.app.softtek.dto.EmployeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Validator {

	private String message;
	private boolean success;
	private EmployeDto obj;
}
