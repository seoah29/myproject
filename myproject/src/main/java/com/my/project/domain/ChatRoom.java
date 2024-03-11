package com.my.project.domain;

import org.hibernate.annotations.DynamicUpdate;

import com.my.project.dto.ChatRoomDTO;

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
public class ChatRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomNum;
	private String memberId;
	private String otherId;
	private String createDate;
	
	public ChatRoom(ChatRoomDTO dto) {

		this.roomNum = dto.getRoomNum();
		this.memberId = dto.getMemberId();
		this.otherId = dto.getOtherId();
		this.createDate = dto.getCreateDate();
	}
}
