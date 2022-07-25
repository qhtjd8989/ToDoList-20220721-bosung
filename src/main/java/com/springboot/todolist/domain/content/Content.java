package com.springboot.todolist.domain.content;

import java.time.LocalDateTime;

import com.springboot.todolist.web.dto.ContentRespDto;
import com.springboot.todolist.web.dto.ReadContentRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Content {
	private int contentcode;
	private int usercode;
	private String username;
	private String content;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
	public ContentRespDto toCreateContentDto(boolean insertStatus) {
		return ContentRespDto.builder()
				.contentcode(contentcode)
				.usercode(usercode)
				.content(content)
				.insertStatus(insertStatus)
				.build();
	}
	
	public ReadContentRespDto readContentListDto() {
		return ReadContentRespDto.builder()
				.contentcode(contentcode)
				.usercode(usercode)
				.username(username)
				.content(content)
				.createDate(createDate)
				.build();
	}
}
