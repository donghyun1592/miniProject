package donghyun.miniproject.Bean;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String name;
    private String email;
    private String password;
    private String address;
    private String address_detail;
    private String phone;
}