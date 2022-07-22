package com.springboot.todolist.domain.content;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentRepository {
	public int savecontent(Content content); // content 추가
	public List<Content> getContentList(int index); // content 리스트 가져오기
}
