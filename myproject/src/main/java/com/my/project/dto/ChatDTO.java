package com.my.project.dto;

import com.my.project.domain.Chat;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class ChatDTO {
	private int msgNum;
	private String recipient;
	private String sender;
	private String msg;
	private String inTime;
	
	public static ChatDTO toDTO(Chat chat) {
		return ChatDTO.builder()
				.recipient(chat.getRecipient())
				.sender(chat.getSender())
				.msg(chat.getMsg())
				.inTime(chat.getInTime())
				.build();
	}

	public ChatDTO(HttpServletRequest req) {
		this.recipient = req.getParameter("recipient");
		this.sender = req.getParameter("sender");
		this.msg = req.getParameter("msg");
		this.inTime = req.getParameter("inTime");
	}
}
