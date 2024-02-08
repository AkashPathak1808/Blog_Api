package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	private Integer postId;
	@NotEmpty(message = "Title should not be empty")
	@NotNull
	private String title;
	@NotEmpty(message = "Content should not be empty")
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	private Set<CommentDto> comments = new HashSet<>();
}
