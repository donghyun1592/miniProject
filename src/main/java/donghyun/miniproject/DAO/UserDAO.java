package donghyun.miniproject.DAO;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "member")
@Entity
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int uid;
    @Column(unique = true)
    @NotNull
    String accountId;           // 이메일 형식
    @NotNull
    String password;
    @NotNull
    String name;
    String phoneNum;

    String role;                // admin, user 구분을 위한 필드

    @NotNull
    Timestamp lastLoginDate;    // 마지막 로그인 날짜
    @NotNull
    Timestamp regDate;          // 생성일자 = 가입일자
    @NotNull
    Timestamp updateDate;       // 정보 변경 날짜
}

