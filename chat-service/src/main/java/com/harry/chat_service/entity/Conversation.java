package com.harry.chat_service.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection =  "conversation")
public class Conversation {
    @MongoId
    String id;

    String type; // GROUP, DIRECT

    @Indexed(unique = true)
    String participantsHash;

    List<ParticipantInfo> participants;

    Instant createdDate;

    Instant modifiedDate;
}