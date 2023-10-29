package petplaza.model.dto;
import lombok.*;
import petplaza.model.entity.ScheduleEntity;

import java.time.LocalDateTime;
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder@ToString
public class ScheduleDto {
    private int sno;
    private String sclass; //분류
    private String stitle; //제목
    private String scontent; //내용
    private boolean sstate; //상태
    private String sstart; //시작일
    private String send; //종료일

    private LocalDateTime cdate;
    private LocalDateTime udate;


    public ScheduleEntity toEntity(){
        return ScheduleEntity.builder()
                .sno(this.sno)
                .sclass(this.sclass)
                .stitle(this.stitle)
                .scontent(this.scontent)
                .sstate(this.sstate)
                .sstart(this.sstart)
                .send(this.send)
                .build();
    }

}
