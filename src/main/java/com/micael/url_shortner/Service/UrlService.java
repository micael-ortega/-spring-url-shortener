package com.micael.url_shortner.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micael.url_shortner.Factory.UrlFactory;
import com.micael.url_shortner.Model.Url;
import com.micael.url_shortner.Repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository repository;

    @Autowired
    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public Optional<Url> saveUrl(String link) {
        Url newUrl = UrlFactory.shorternUrl(link);
        try {
            repository.save(newUrl);
            return Optional.of(newUrl);
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error persisting new record: " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Url> getUrl(String code) {
        return repository.findByCode(code);
    }
}
