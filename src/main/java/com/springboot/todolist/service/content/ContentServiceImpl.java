package com.springboot.todolist.service.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.content.Content;
import com.springboot.todolist.domain.content.ContentRepository;
import com.springboot.todolist.web.dto.CreateContentRepDto;
import com.springboot.todolist.web.dto.CreateContentRespDto;
import com.springboot.todolist.web.dto.ReadContentRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
	
	private final ContentRepository contentRepository;

	@Override
	
	public CreateContentRespDto addContent(CreateContentRepDto createContentRepDto) throws Exception {
		Content contentEntity = createContentRepDto.toEntity();
		boolean insertStatus = contentRepository.savecontent(contentEntity) > 0;
		return contentEntity.toCreateContentDto(insertStatus);
	}

	@Override
	public List<ReadContentRespDto> readContentList(int page) throws Exception {
		List<ReadContentRespDto> contentDtoList = new ArrayList<ReadContentRespDto>();
		
		contentRepository.getContentList((page-1)*10).forEach(content -> {
			contentDtoList.add(content.readContentListDto());
		});
		return contentDtoList;
	}
}
