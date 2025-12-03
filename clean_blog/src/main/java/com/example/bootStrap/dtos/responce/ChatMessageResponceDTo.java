package com.example.bootStrap.dtos.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatMessageResponceDTo {
    private Long id;

    private String content;
    private String sender;
    private String type;
}
