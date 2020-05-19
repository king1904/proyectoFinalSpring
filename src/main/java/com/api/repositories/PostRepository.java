package com.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.clases.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	@Query("select p from Post  p where p.product.id=:id and p.replyTo=null")
	List<Post> findAllByProductId(@Param("id") int id);

	@Query("select p from Post  p where p.replyTo.id=:postId")
	List<Post> findAllRepliesByPostId(@Param("postId") int id);

	@Modifying
	@Query(value = "insert into Post (likes,text,product_id,user_id,replay_id) values (:likes, :text, :product_id, :user_id, :replay_id)", nativeQuery = true)
	void insertPost(@Param("likes") int likes, @Param("text") String text, @Param("product_id") Integer product_id,
			@Param("user_id") Integer user_id,@Param("replay_id") Integer replay_id );
}
