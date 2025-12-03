package com.example.bootStrap.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Включает обработку сообщений по WebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 1. Конфигурация брокера сообщений
        // /topic - префикс для общих сообщений (от сервера клиенту). Клиенты подписываются на них.
        config.enableSimpleBroker("/topic");

        // 2. Префикс для сообщений, отправляемых клиентами на сервер (@MessageMapping)
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 3. Конечная точка, к которой подключается клиент
        // .withSockJS() добавляет поддержку SockJS для старых браузеров
        registry.addEndpoint("/ws").withSockJS();
    }
}