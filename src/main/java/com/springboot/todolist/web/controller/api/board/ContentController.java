package com.springboot.todolist.web.controller.api.board;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.service.content.ContentService;
import com.springboot.todolist.web.CMRespDto;
import com.springboot.todolist.web.dto.CreateContentRepDto;
import com.springboot.todolist.web.dto.CreateContentRespDto;
import com.springboot.todolist.web.dto.ReadContentRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class ContentController {
	private final ContentService contentService;
	
	@PostMapping("/content")
	public ResponseEntity<?> addcontent(@RequestBody CreateContentRepDto contentRepDto) {
		CreateContentRespDto createContentRespDto = null;
		
		try {
			createContentRespDto = contentService.addContent(contentRepDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "content 등록 실패", createContentRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "content 등록 성공", createContentRespDto));
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getContentList(@RequestParam int page) {
		List<ReadContentRespDto> contentList = null;
		
		try {
			contentList = contentService.readContentList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "리스트" + page + "페이지 불러오기 실패", contentList));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "리스트 " + page + "페이지 불러오기 성공", contentList));
	}
}
