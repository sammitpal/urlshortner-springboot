package com.shortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortner.model.UrlModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface UrlRepository.
 */
public interface UrlRepository extends JpaRepository<UrlModel, Integer>{

	/**
	 * Find by slug.
	 *
	 * @param slug the slug
	 * @return the url model
	 */
	UrlModel findBySlug(String slug);

}
