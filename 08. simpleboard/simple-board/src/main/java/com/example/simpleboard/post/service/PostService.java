package com.example.simpleboard.post.service;

import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(
        PostRequest postRequest
    ){
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get(); // << 임시 고정

        var entity = PostEntity.builder()
            .boardEntity(boardEntity)
            .userName(postRequest.getUserName())
            .password(postRequest.getPassword())
            .email(postRequest.getEmail())
            .status("REGISTERED")
            .title(postRequest.getTitle())
            .content(postRequest.getContent())
            .postedAt(LocalDateTime.now())
            .build()
            ;

        return postRepository.save(entity);
    }

    /**
     * 1. 게시글이 있는가?
     * 2. 비밀번호가 맞는가?
     */
    public PostEntity view(PostViewRequest postViewRequest) {

        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED")
            .map( it -> {
                // entity 존재
                if(!it.getPassword().equals(postViewRequest.getPassword())){
                    var format = "패스워드가 맞지 않습니다 %s vs %s";
                    throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                }

                // 답변글도 같이 적용
/*                var replyList = replyService.findAllByPostId(it.getId());
                it.setReplyList(replyList);*/

                return it;

            }).orElseThrow(
                ()-> {
                    return new RuntimeException("해당 게시글이 존재 하지 않습니다 : "+postViewRequest.getPostId());
                }
            );
    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
            .page(list.getNumber())
            .size(list.getSize())
            .currentElements(list.getNumberOfElements())
            .totalElements(list.getTotalElements())
            .totalPage(list.getTotalPages())
            .build()
            ;

        var response = Api.<List<PostEntity>>builder()
            .body(list.toList())
            .pagination(pagination)
            .build();

        return response;
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
            .map( it -> {
                // entity 존재
                if(!it.getPassword().equals(postViewRequest.getPassword())){
                    var format = "패스워드가 맞지 않습니다 %s vs %s";
                    throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                }

                it.setStatus("UNREGISTERED");
                postRepository.save(it);
                return it;
            }).orElseThrow(
                ()-> {
                    return new RuntimeException("해당 게시글이 존재 하지 않습니다 : "+postViewRequest.getPostId());
                }
            );
    }
}
