package com.api.services;

import java.util.List;
 
import com.api.clases.Post;
import com.api.clases.PostRequest;
import com.api.clases.PostResponse;

public interface PostService {
	
	List<Post> getPostsByProductId(int id);
	Post addPost(PostRequest post);
	Post updatePost(Post post);
	

}
