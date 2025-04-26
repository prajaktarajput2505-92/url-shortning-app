package com.urlShortning.com_shortning_service.controller;


import com.urlShortning.com_shortning_service.service.URLMappingService;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class URLShortningController {


    private URLMappingService urlMappingService;


    public URLShortningController(URLMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }


    @PostMapping("/createShortUrl")
    public ResponseEntity<String> createShortUrl(@RequestParam String longUrl)
    {
        String shortUrl = urlMappingService.createShortUrl(longUrl);
        return new ResponseEntity<>(shortUrl, HttpStatus.CREATED);
    }


    @GetMapping("/fetchLongUrl/{shortCode}")
    public ResponseEntity<Void> fetchOriginalUrl(@PathVariable String shortCode)
    {
        String longUrl = urlMappingService.fetchShortUrl(shortCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(longUrl));
        return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302 redire
    }
}
