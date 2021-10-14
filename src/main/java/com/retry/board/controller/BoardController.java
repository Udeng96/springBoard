package com.retry.board.controller;

import com.retry.board.domain.Board;
import com.retry.board.domain.BoardDto;
import com.retry.board.domain.BoardRepository;
import com.retry.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring 게시판 컨트롤러
 *
 * @name BoardController
 * @author 장유정
 * @version 1.0.0
 * @since 2021-10
 */
@RestController
@RequiredArgsConstructor
public class BoardController {

    //update하는데 필요
    private final BoardRepository boardRepository;
    private final BoardService boardService;


    @GetMapping("/api/lists")
    public List<Board> showlist()
    {
        return boardRepository.findAll();
    }

    @PostMapping("/api/lists")
    public Board createBoard(@RequestBody BoardDto boardDto)
    {
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

    @PutMapping("api/lists/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto)
    {
        boardService.update(id,boardDto);
        return id;
    }

    @DeleteMapping("api/lists/{id}")
    public Long deleteBoard(@PathVariable Long id)
    {
        boardRepository.deleteById(id);
        return id;
    }
}
