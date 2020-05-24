package com.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Post;
import com.api.clases.PostRequest;
import com.api.clases.PostResponse;
import com.api.clases.Usuario;
import com.api.services.PostServiceImpl;
import com.api.services.ProductoServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/backend/service/posts")
public class PostsController {

	@Autowired
	private   PostServiceImpl postService;
	
	 
	
	@GetMapping("/{id}")
	public List<Post> getPostsByProductId(@PathVariable int id){
		
		return this.postService.getPostsByProductId(id);
	}
	
	@PostMapping
	
	public List<Post> addPostToProduct(@RequestBody PostRequest post) {
		
		return  this.postService.addPost(post); 
		 
			 

	}
	
	@PatchMapping
	
	public Post updatePost(@RequestBody Post post) {
		
		return this.postService.updatePost(post);
	}
	
 
}
