package com.retry.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Spring 게시판 Dto
 *
 * @name BoardDto
 * @author 장유정
 * @version 1.0.0
 * @since 2021-10
 */
@Getter
public class BoardDto
{
    private Long id;
    private String writer;
    private String title;
    private String contents;
}


