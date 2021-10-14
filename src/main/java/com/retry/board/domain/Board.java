package com.retry.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;


/**
 * Spring 게시판
 *
 * @name Board
 * @author 장유정
 * @version 1.0.0
 * @since 2021-10
 */
// 테이블임을 나타내준다.
@Entity
// lombok annotation Getter 자동 생성성
@Getter
@Table
@NoArgsConstructor // 기본 생성자를 대신 생성해 준다.
public class Board extends Timestamped
{
    //자동으로 증가할 수 있게 한다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Primary Key를 나타낸다.
    @Id
    private Long id;

    //컬럼 값이고 반드시 존재해야 한다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contents;

    public Board(String title, String name, String contents, LocalDateTime createdAt)
    {
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    public Board(BoardDto boardDto)
    {
        this.title = boardDto.getTitle();
        this.name = boardDto.getWriter();
        this.contents = boardDto.getContents();
    }

    public void update(BoardDto boardDto)
    {
        this.name = boardDto.getWriter();
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
    }
}
