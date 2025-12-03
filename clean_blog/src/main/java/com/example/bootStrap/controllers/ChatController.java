package com.example.bootStrap.controllers;

import com.example.bootStrap.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {


    /**
     * Обрабатывает сообщения, отправленные клиентом на адрес /app/chat.sendMessage.
     * * @param chatMessage сообщение от клиента
     * @return то же сообщение, которое будет отправлено всем подписчикам
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public") // Отправляет возвращаемое значение всем клиентам, подписанным на /topic/public
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        // Здесь можно добавить логику: сохранение в базу данных, валидация и т.д.
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Добавляем имя пользователя в сессию WebSocket (опционально, но полезно)
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage; // Отправляем сообщение JOIN всем
    }


}