package petplaza.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import petplaza.model.dto.AdminDto;
import petplaza.model.dto.MemberDto;

import javax.persistence.*;

@Entity
@Table(name="member")
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString@Builder
public class MemberEntity extends BaseTime{
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


    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.getMno())
                .mid(this.getMid())
                .mpw(this.getMpw())
                .mname(this.getMname())
                .mphone(this.getMphone())
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .build();
    }

}
