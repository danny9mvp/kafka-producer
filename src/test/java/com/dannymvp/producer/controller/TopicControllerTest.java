package com.dannymvp.producer.controller;

import com.dannymvp.producer.dto.MessageDTO;
import com.dannymvp.producer.service.TopicService;
import com.dannymvp.producer.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TopicControllerTest {

    @Mock
    private TopicService topicService;

    @InjectMocks
    private TopicController topicController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void publishTopic() {
        // Arrange
        String topic = "danny-topic";
        String jsonFileName = "MessageDTO.json";
        MessageDTO message = FileUtils.readJsonFile(jsonFileName, MessageDTO.class);
        doNothing().when(topicService).send(topic, message);

        // Act
        ResponseEntity<String> responseEntity = topicController.publishTopic(message);

        // Assert
        verify(topicService, times(1)).send(topic, message);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("success", responseEntity.getBody());
    }
}
