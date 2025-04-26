package com.urlShortning.com_shortning_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UrlRecord")
public class ShortUrlMapping
{
        @Id
        int id;

        public ShortUrlMapping() {
        }

        public ShortUrlMapping(int id, String longUrl, String shortUrl) {
                this.id = id;
                this.longUrl = longUrl;
                this.shortUrl = shortUrl;
        }

        String shortUrl;

        public String getLongUrl() {
                return longUrl;
        }

        public void setLongUrl(String longUrl) {
                this.longUrl = longUrl;
        }

        public String getShortUrl() {
                return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
                this.shortUrl = shortUrl;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        String longUrl;

}