package GoForm.model.entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="member")
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    @Column(name="mid",length = 20, nullable = false,unique = true)
    private String mid;
    @Column(name="mpw",length = 20, nullable = false, unique = true)
    private String mpw;
    @Column(name="mname", length=10, nullable = false, unique = true)
    private String mname;
    @Column(name="mphone", length = 13, nullable = false, unique = true)
    private String mphone;



}
