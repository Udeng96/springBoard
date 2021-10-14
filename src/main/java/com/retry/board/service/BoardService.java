package com.retry.board.service;

import com.retry.board.domain.Board;
import com.retry.board.domain.BoardDto;
import com.retry.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Spring 게시판 서비스
 *
 * @name BoardService
 * @author 장유정
 * @version 1.0.0
 * @since 2021-10
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //Todo:얘가 뭐하는 애인지 알아보기
    @Transactional


    public Long update(Long id, BoardDto boardDto)
    {
        Board board = boardRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        board.update(boardDto);
        return id;
    }

}
