package com.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.clases.Post;
import com.api.clases.PostRequest;
import com.api.repositories.PostRepository;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioRepository;
 
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository userRepo;
	@Autowired
	private ProductoRepository productRepo;

	@Override
	public List<Post> getPostsByProductId(int id) {
		// TODO Auto-generated method stub

		return this.postRepository.findAllByProductId(id);

	}

	@Override
	public  List <Post> addPost(PostRequest post) {
		// TODO Auto-generated method stub
		Post newPost=new Post();
		newPost.setUser(this.userRepo.findById(post.getUser_id()).get());
		if(post.getReplay_id() !=null ) newPost.setReplyTo(this.postRepository.findById(post.getReplay_id()).get());
		newPost.setText(post.getText());
		newPost.setLikes(0);
		newPost.setProduct(this.productRepo.findById(post.getProduct_id()).get());
		
		  this.postRepository.save(newPost);
		  return this.postRepository.findAllByProductId(post.getProduct_id());
//		  this.postRepository.insertPost(post.getLikes(), post.getText(), post.getProduct_id(), post.getUser_id(),
//				post.getReplay_id());
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		Post updatedPost = this.postRepository.findById(post.getId()).get();

		updatedPost.setLikes(post.getLikes());

		return this.postRepository.saveAndFlush(updatedPost);
	}

}
