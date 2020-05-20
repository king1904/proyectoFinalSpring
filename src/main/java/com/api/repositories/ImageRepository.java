package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clases.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
