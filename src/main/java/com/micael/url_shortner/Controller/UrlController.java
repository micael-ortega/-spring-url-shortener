package com.micael.url_shortner.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.micael.url_shortner.Model.Url;
import com.micael.url_shortner.Service.UrlService;

@RestController
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody UrlRequest urlRequest) {

        Optional<Url> result = urlService.saveUrl(urlRequest.getLongUrl());

        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get().getShortUrl());
        } else {
            return ResponseEntity.status(500).body("Error persisting new record");
        }
    }

    @GetMapping("/{code}")
    public RedirectView getUrl(@PathVariable("code") String code) {
        Optional<Url> result = urlService.getUrl(code);

        System.out.println(result.get().getUrl());

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(result.get().getUrl());
        

        return redirectView;

    }
}
