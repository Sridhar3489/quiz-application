package com.example.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import org.json.JSONObject;

@Service
public class AIService {

	private static final String OPENAI_API_KEY = "";
	private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

	private final RestTemplate restTemplate;

	@Autowired
	public AIService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Mono<String> generateQuizQuestion(String prompt) {
		String url = "https://api.openai.com/v1/chat/completions";

	    String topic = "Generate a quiz question about " + prompt;
	    
	    String jsonPayload = String.format(
	        "{\"model\":\"gpt-3.5-turbo\", \"messages\":[{\"role\":\"user\", \"content\":\"%s\"}]}",
	        topic
	    );

	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    headers.set("Authorization", "Bearer "+ OPENAI_API_KEY);
	    
	    JSONObject json = new JSONObject(jsonPayload);
	    HttpEntity<JSONObject> request = new HttpEntity<>(json, headers);
	    System.out.println(request);

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

	    return Mono.just(response.getBody());

	}
}
