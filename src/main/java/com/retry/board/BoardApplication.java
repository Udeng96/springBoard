package com.retry.board;

import com.retry.board.domain.Board;
import com.retry.board.domain.BoardRepository;
import com.retry.board.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class BoardApplication
{
    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository, BoardService boardService){
        return(args ->
        {
            List<Board> boardList = boardRepository.findAll();
            for (int i = 0; i<boardList.size(); i++)
            {
                Board board = boardList.get(i);
            }
        });
    }

}
