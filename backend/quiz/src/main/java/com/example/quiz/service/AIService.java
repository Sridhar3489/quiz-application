package com.example.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import org.json.JSONObject;

@Service
public class AIService {
	
	//https://aistudio.google.com/app/apikey
	//https://ai.google.dev/gemini-api/docs/api-key#windows
	private static final String GEMINI_API_KEY = "";
	private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    private final WebClient webClient;

    public AIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(GEMINI_API_URL).build();
    }

    public Mono<String> generateContent(String prompt) {

    	String jsonPayload = String.format(
            "{ \"contents\": [{ \"parts\": [{ \"text\": \"%s\" }] }] }",
            prompt
        );

        return webClient.post()
                .uri(uriBuilder -> uriBuilder.queryParam("key", GEMINI_API_KEY).build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> {
                    e.printStackTrace();
                    return Mono.error(new RuntimeException("Error calling Gemini API: " + e.getMessage()));
                });
    }
}
