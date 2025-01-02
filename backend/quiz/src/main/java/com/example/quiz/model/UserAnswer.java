package com.example.quiz.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String answerText;
    private Boolean isCorrect;
}