package com.micael.url_shortner.Factory;

import com.micael.url_shortner.Model.Url;
import com.micael.url_shortner.Model.Url.Builder;

public class UrlFactory {
    
    public static Url shorternUrl(String link){
        Builder builder = new Builder();
        return builder.id().longUrl(link).setCode().build();
    }
}
