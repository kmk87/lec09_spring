package com.gn.spring.websocket.model.service;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChattingServer extends TextWebSocketHandler {

	
	// 클라이언트가 연결되었을 때 설정
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}

	// 클라이언트가 웹소켓 서버로 메세지를 전송했을 때 설정
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
	}

	
	// 클라이언트가 연결을 끊었을 때 설정
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
	}
	
	
	
	
	
}
