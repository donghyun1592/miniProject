package donghyun.miniproject.Bean;

import donghyun.miniproject.Entity.Category;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private String title;
    private String contents;
    private String price;
    private Category category;
}
