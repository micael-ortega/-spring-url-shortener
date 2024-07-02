package com.micael.url_shortner.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micael.url_shortner.Model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, UUID> {
    Optional<Url> findByCode(String code);

}
