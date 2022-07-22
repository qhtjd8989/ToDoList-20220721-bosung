package com.springboot.todolist.web.dto;

import com.springboot.todolist.domain.content.Content;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateContentRepDto {
	private int usercode;
	private String content;
	
	public Content toEntity() {
		return Content.builder()
				.usercode(usercode)
				.content(content)
				.build();
	}
}
