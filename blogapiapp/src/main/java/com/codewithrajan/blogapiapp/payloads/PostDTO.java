package com.codewithrajan.blogapiapp.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Integer postId;

    private String title;

    private String content;

    private String imageName = "default.png";

    private Date addedDate;

    // to resolve recursion we changed Category to CategoryDTO
    // and User to UserDTO

    private CategoryDTO category;

    private UserDTO user;

    private List<CommentDTO> comments;

}
