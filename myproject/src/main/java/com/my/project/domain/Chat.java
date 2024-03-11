package com.my.project.domain;

import org.hibernate.annotations.DynamicUpdate;

import com.my.project.dto.ChatDTO;

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
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgNum;
	private String recipient;
	private String sender;
	private String msg;
	private String inTime;

	public Chat(ChatDTO dto) {

		this.msgNum = dto.getMsgNum();
		this.recipient = dto.getRecipient();
		this.sender = dto.getSender();
		this.msg = dto.getMsg();
		this.inTime = dto.getInTime();
	}
}
