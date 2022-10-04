package donghyun.miniproject.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Board {
    @Id
    @Column(name="board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long boardId;
    private String title;
    private String price;

    @ColumnDefault("false")
    private boolean onSale;
    private Date create_date;
    private Date update_date;
    private String contents;

    @ColumnDefault("0")
    private int hit;

    @ManyToOne
    @JoinColumn
    private Member member;

    @ManyToOne
    @JoinColumn
    private Category category;

    private String filepath1;
    private String filepath2;
    private String filepath3;
}
