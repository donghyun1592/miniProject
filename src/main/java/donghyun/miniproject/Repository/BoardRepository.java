package donghyun.miniproject.Repository;

import donghyun.miniproject.Entity.Board;
import donghyun.miniproject.Entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    //전체 검색
//    Page<Board> findAllOrderByHitDesc(Pageable pageable);
    //게시글 상세보기
    Optional<Board> findBoardByBoardId(long boardId);
}
