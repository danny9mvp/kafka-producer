package com.dannymvp.producer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TopicServiceTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private TopicService topicService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_KafkaTemplateCreated_Then_Send() {
        // Arrange
        String topic = "danny-topic";
        String message = "test message";

        // Act
        topicService.send(topic, message);

        // Assert
        verify(kafkaTemplate, times(1)).send(topic, message);
    }
}