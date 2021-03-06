package io.oneko.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;


/**
 * Inspired by http://www.baeldung.com/spring-5-reactive-websockets
 */
@Configuration
public class WebSocketConfiguration {
	private final WebSocketHandler webSocketHandler;

	@Autowired
	public WebSocketConfiguration(WebSocketHandler webSocketHandler) {
		this.webSocketHandler = webSocketHandler;
	}

	@Bean
	public WebSocketHandlerAdapter wsha() {
		return new WebSocketHandlerAdapter();
	}

	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		Map<String, WebSocketHandler> map = new HashMap<>();
		map.put("/ws", webSocketHandler);

		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		handlerMapping.setOrder(1);
		handlerMapping.setUrlMap(map);
		return handlerMapping;
	}
}
