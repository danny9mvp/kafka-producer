package com.dannymvp.producer.controller;

import com.dannymvp.producer.dto.MessageDTO;
import com.dannymvp.producer.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/publish")
    public ResponseEntity<String> publishTopic(@RequestBody MessageDTO message) {
        topicService.send("danny-topic", message);
        return ResponseEntity.ok("success");
    }
}
