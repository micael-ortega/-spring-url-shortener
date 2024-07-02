package com.micael.url_shortner.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Url {

    @Id
    private UUID id;
    private String longUrl, code;

    public Url() {
    }

    public Url(UUID id, String longUrl, String code) {
        this.id = id;
        this.longUrl = longUrl;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return longUrl;
    }

    public void setUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl(){
        return "http://🌜/" + this.code;
    }

    public static class Builder {
        private UUID id;
        private String longUrl;
        private String code;

        public Builder id() {
            this.id = UUID.randomUUID();
            return this;
        }

        public Builder longUrl(String longUrl) {
            this.longUrl = longUrl;
            return this;
        }

        public Builder setCode() {
            code = this.id.toString().replaceAll("-", "").substring(0, 9);
            return this;
        }

        public Url build() {
            return new Url(id, longUrl, code);
        }
    }
}
