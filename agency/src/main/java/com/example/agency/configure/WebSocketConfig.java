package com.example.agency.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import tools.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker( "/user");
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        messageConverters.add(new Jackson3MessageConverter());
        return false;
    }

    /**
     * Custom message converter for Jackson 3.x (tools.jackson package)
     * This replaces the deprecated MappingJackson2MessageConverter
     */
    private static class Jackson3MessageConverter extends AbstractMessageConverter {
        private final ObjectMapper objectMapper;

        public Jackson3MessageConverter() {
            super(MimeTypeUtils.APPLICATION_JSON);
            this.objectMapper = new ObjectMapper();
        }

        @Override
        protected boolean supports(Class<?> clazz) {
            return true;
        }

        @Override
        protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
            try {
                Object payload = message.getPayload();
                if (payload instanceof byte[]) {
                    return objectMapper.readValue((byte[]) payload, targetClass);
                } else if (payload instanceof String) {
                    return objectMapper.readValue((String) payload, targetClass);
                }
                return null;
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert message", e);
            }
        }

        @Override
        protected Object convertToInternal(Object payload, MessageHeaders headers, Object conversionHint) {
            try {
                return objectMapper.writeValueAsBytes(payload);
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert message", e);
            }
        }
    }
}