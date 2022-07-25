package com.springboot.todolist.service.content;

import java.util.List;

import com.springboot.todolist.web.dto.ContentReqDto;
import com.springboot.todolist.web.dto.ContentRespDto;
import com.springboot.todolist.web.dto.ReadContentRespDto;

public interface ContentService {
	public ContentRespDto addContent(ContentReqDto createContentRepDto) throws Exception; 
	public List<ReadContentRespDto> readContentList(int page) throws Exception;
}
