package donghyun.miniproject.Entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String name;
    private String description;
}
