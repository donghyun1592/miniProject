package donghyun.miniproject.Controller;

import donghyun.miniproject.Bean.BoardDTO;
import donghyun.miniproject.Controller.Common.BaseController;
import donghyun.miniproject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BoardController extends BaseController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

//    @GetMapping("/board")
//    public ResponseEntity<Object> getBoardList(Pageable pageable) {
//        return ResponseEntity.ok(boardService.getBoardList(pageable));
//    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<Object> getBoard(@PathVariable long boardId){
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @PostMapping("/board")
    public ResponseEntity<Object> createBoard(@RequestBody BoardDTO boardDTO){
        return ResponseEntity.ok(boardService.createBoard(boardDTO, getUserInfo()));
    }

}
