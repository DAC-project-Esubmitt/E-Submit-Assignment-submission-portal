package com.esubmit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatbotService {

    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String getResponse(String userMessage) {
        try {
            // Prepare the request body using a Map
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "deepseek");
            requestBody.put("prompt", userMessage);
            requestBody.put("stream", false);

            // Convert Map to JSON String
            ObjectMapper objectMapper = new ObjectMapper();
            String requestJson = objectMapper.writeValueAsString(requestBody);

            // Create headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request
            HttpEntity<String> request = new HttpEntity<>(requestJson, headers);

            // Send request using RestTemplate
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                OLLAMA_URL, HttpMethod.POST, request, String.class);

            // Parse JSON response using Jackson
            JsonNode jsonResponse = objectMapper.readTree(response.getBody());
            return jsonResponse.get("response").asText(); // Extract chatbot reply

        } catch (Exception e) {
            return "Error communicating with Ollama: " + e.getMessage();
        }
    }
}
