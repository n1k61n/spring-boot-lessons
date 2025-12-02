package com.example.bootStrap.dtos.request;

import com.example.bootStrap.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostRequestDTo {
    private String mainTitle;
    private String subTitle;
    private String photoUrl;
    private String headerPhotoUrl;
    private String content;
    private String description;
    private User author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isPublished;
}
