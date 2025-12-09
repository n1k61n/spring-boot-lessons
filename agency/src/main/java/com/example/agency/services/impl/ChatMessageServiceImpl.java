package com.example.agency.services.impl;

import com.example.agency.enums.MessageStatus;
import com.example.agency.exceptions.ResourceNotFoundException;
import com.example.agency.models.ChatMessage;
import com.example.agency.repositories.ChatMessageRepository;
import com.example.agency.services.ChatMessageService;
import com.example.agency.services.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;


    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);

        return chatMessage;
    }

    public Long countNewMessages(String senderId, String recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
        var messages = chatId.map(repository::findByChatId).orElse(new ArrayList<>());
        if (!messages.isEmpty()) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }

        return messages;
    }

    public ChatMessage findById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
        repository
                .findAll()
                .stream()
                .filter(m -> m.getSenderId().equals(senderId) && m.getRecipientId().equals(recipientId))
                .forEach(m -> {
                    m.setStatus(status);
                    repository.save(m);
                });
    }
}
