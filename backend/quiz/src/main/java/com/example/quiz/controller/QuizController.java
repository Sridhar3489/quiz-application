package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.AIService;

import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173") 
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AIService aiService;

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    @PostMapping("/generate-question")
    public Mono<String> generateQuestion(@RequestParam String topic) throws Exception {
        return aiService.generateContent("JUST give questions regarding " + topic +" with various difficulty levels ");
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
    	System.out.println(quiz.getName());
        return quizRepository.save(quiz);
    }

    @PostMapping("/{quizId}/questions")
    public Question addQuestionToQuiz(@PathVariable Long quizId, @RequestBody Question question) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }
}
