package com.my.project.dto;

import com.my.project.domain.ChatRoom;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class ChatRoomDTO {
	private int roomNum;
	private String memberId;
	private String otherId;
	private String createDate;

	public static ChatRoomDTO toDTO(ChatRoom chatRoom) {
		return ChatRoomDTO.builder().memberId(chatRoom.getMemberId()).otherId(chatRoom.getOtherId())
				.createDate(chatRoom.getCreateDate()).build();
	}

	public ChatRoomDTO(HttpServletRequest req) {
		this.memberId = req.getParameter("memberId");
		this.otherId = req.getParameter("otherId");
		this.createDate = req.getParameter("createDate");
	}
}
