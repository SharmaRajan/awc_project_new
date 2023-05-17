package com.codewithrajan.blogapiapp.repository;


import com.codewithrajan.blogapiapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {
}
