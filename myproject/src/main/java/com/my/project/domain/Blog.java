package com.my.project.domain;

import org.hibernate.annotations.DynamicUpdate;

import com.my.project.dto.BlogDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@DynamicUpdate
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String content;
	private String inDate;
	private String img;

	public Blog(BlogDTO dto) {

		this.num = dto.getNum();
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.inDate = dto.getInDate();
		this.img = dto.getImg();
	}
}
