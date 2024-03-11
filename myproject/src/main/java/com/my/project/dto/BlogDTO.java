package com.my.project.dto;

import com.my.project.domain.Blog;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class BlogDTO {
	private int num;
	private String title;
	private String content;
	private String inDate;
	private String img;
	
	public static BlogDTO toDTO(Blog blog) {
		return BlogDTO.builder()
				.title(blog.getTitle())
				.content(blog.getContent())
				.inDate(blog.getInDate())
				.img(blog.getImg())
				.build();
	}

	public BlogDTO(HttpServletRequest req) {
		this.title = req.getParameter("title");
		this.content = req.getParameter("content");
		this.inDate = req.getParameter("inDate");
		this.img = req.getParameter("img");

	}
}
