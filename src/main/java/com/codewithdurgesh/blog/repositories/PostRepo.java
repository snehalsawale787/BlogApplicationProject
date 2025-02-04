package com.codewithdurgesh.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>
{

	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	
	List<Post> findByTitleContaining(String title);
	//@Query("select  from Post where p.title like :key")
	//List<Post> searchbyTitle(@Param("key") String title);
}
