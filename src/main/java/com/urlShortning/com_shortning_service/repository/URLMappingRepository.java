package com.urlShortning.com_shortning_service.repository;

import com.urlShortning.com_shortning_service.model.ShortUrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLMappingRepository extends JpaRepository<ShortUrlMapping,Integer> {

    Optional<ShortUrlMapping> findByShortUrl(String shortUrl);
}
