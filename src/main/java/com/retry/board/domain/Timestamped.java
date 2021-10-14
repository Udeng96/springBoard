package com.retry.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


/**
 * Spring 게시판 Timestamped
 *
 * @name Timestamped
 * @author 장유정
 * @version 1.0.0
 * @since 2021-10
 */
//상속했을 때, 컬럼으로 인식
@MappedSuperclass
@Getter
//생성시간을 자동으로 생성
@EntityListeners(AuditingEntityListener.class)
public class Timestamped
{
    //생성일자
    @CreatedDate
    private LocalDateTime createdAt;
}
