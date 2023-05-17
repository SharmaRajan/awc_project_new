package com.codewithrajan.blogapiapp.service;

import com.codewithrajan.blogapiapp.payloads.CommentDTO;

public interface ICommentService {

    CommentDTO createComment(CommentDTO theCommentDTO, Integer postId);

    void deleteComment(Integer commentId);

}
