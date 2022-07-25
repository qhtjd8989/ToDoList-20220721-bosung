package com.springboot.todolist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentRespDto {
	private int contentcode; 
	private int usercode;
	private String content;
	private boolean insertStatus;
	
	
}
