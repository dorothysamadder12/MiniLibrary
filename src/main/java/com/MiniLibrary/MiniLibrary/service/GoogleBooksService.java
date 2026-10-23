
package com.MiniLibrary.MiniLibrary.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleBooksService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${google.books.api-key:}")
    private String apiKey;

    public String searchBooks(String query) {
        String url = UriComponentsBuilder
                .fromUriString("https://www.googleapis.com/books/v1/volumes")
                .queryParam("q", query)
                .queryParam("maxResults", 5)
                .queryParam("key", apiKey)
                .build()
                .encode()
                .toUriString();

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Google Books HTTP status: " + e.getStatusCode());
            System.out.println("Google Books response: " + e.getResponseBodyAsString());
            throw e;
        }
    }
}
