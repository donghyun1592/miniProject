package donghyun.miniproject.Service;

import donghyun.miniproject.Bean.BoardDTO;
import donghyun.miniproject.Entity.Board;
import donghyun.miniproject.Entity.Member;
import donghyun.miniproject.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

//    public Page<Board> getBoardList(Pageable pageable){
//        return boardRepository.findAllOrderByHitDesc(pageable);
//    }

    public Board getBoard(long boardId){
        return boardRepository.findBoardByBoardId(boardId).get();
    }

    public Board createBoard(BoardDTO boardDTO, Member member) {

        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .price(boardDTO.getPrice())
                .onSale(false)
                .contents(boardDTO.getContents())
                .member(member)
                .category(boardDTO.getCategory())
                .build();
        return boardRepository.save(board);
    }
}
