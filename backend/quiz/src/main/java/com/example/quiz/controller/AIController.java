package com.example.quiz.controller;

import com.example.quiz.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/generate-quiz")
    public Mono<String> generateQuiz(@RequestParam String prompt) {
        return aiService.generateQuizQuestion(prompt);
    }
}
