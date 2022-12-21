package com.gyojincompany.test.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	
	private String writerid;
	private String title;
	private String content;
	private LocalDateTime createTime;
	
	private MemberDto memberDto;
}
