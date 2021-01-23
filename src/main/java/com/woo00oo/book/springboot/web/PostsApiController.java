package com.woo00oo.book.springboot.web;

import com.woo00oo.book.springboot.service.posts.PostService;
import com.woo00oo.book.springboot.web.dto.PostsResponseDto;
import com.woo00oo.book.springboot.web.dto.PostsSaveRequestDto;
import com.woo00oo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto
                     requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findByid(@PathVariable Long id){
        return postService.findById(id);
    }
}
