package com.urlShortning.com_shortning_service.service;

import com.urlShortning.com_shortning_service.repository.URLMappingRepository;
import com.urlShortning.com_shortning_service.model.ShortUrlMapping;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.random.RandomGenerator;

@Service
public class URLMappingService {

    URLMappingRepository urlMappingRepository;

    public URLMappingService(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String createShortUrl(String longUrl) {
        RandomGenerator randomGenerator=RandomGenerator.getDefault();
        StringBuilder stringBuilder=new StringBuilder(7);

        for(int i=0;i<7;i++)
        {
            int index=randomGenerator.nextInt(longUrl.length());
            stringBuilder.append(longUrl.charAt(index));
        }
        ShortUrlMapping shortUrlMapping=new ShortUrlMapping();
        shortUrlMapping.setShortUrl(stringBuilder.toString());
        shortUrlMapping.setLongUrl(longUrl);
        urlMappingRepository.save(shortUrlMapping);
        return stringBuilder.toString();
    }

    public String fetchShortUrl(String shortCode) {
        Optional<ShortUrlMapping> shortUrlData= urlMappingRepository.findByShortUrl(shortCode);
        if(shortUrlData.isPresent())
        {
            return shortUrlData.get().getLongUrl();
        }
        return "";
    }
}