package petplaza.model.dto;

import lombok.*;
import petplaza.model.entity.AdminEntity;
import petplaza.model.entity.MemberEntity;

import java.time.LocalDateTime;


@AllArgsConstructor@NoArgsConstructor
@Setter@Getter@Builder@ToString
public class MemberDto {
    private int mno;
    private String mid;
    private String mpw;
    private String mname;
    private String mphone;

    private LocalDateTime cdate;
    private LocalDateTime udate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(this.getMno())
                .mid(this.getMid())
                .mpw(this.getMpw())
                .mname(this.getMname())
                .mphone(this.getMphone())
                .build();
    }
}
