package com.app.softtek.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MessageProperties {

	@Value("${create.message}")
	private String createMessage;

	@Value("${create.messageError}")
	private String createError;

	@Value("${update.message}")
	private String updateMessage;

	@Value("${update.messageError}")
	private String updateError;

	@Value("${delete.message}")
	private String deleteMessage;

	@Value("${delete.messageError}")
	private String deleteError;
}
