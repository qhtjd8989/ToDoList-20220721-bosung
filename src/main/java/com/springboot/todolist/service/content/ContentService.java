package com.springboot.todolist.service.content;

import java.util.List;

import com.springboot.todolist.web.dto.CreateContentRepDto;
import com.springboot.todolist.web.dto.CreateContentRespDto;
import com.springboot.todolist.web.dto.ReadContentRespDto;

public interface ContentService {
	public CreateContentRespDto addContent(CreateContentRepDto createContentRepDto) throws Exception; 
	public List<ReadContentRespDto> readContentList(int page) throws Exception;
}
