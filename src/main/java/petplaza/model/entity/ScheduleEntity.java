package petplaza.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import petplaza.model.dto.ScheduleDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Schedule")
@AllArgsConstructor@NoArgsConstructor
@Setter@Getter@ToString@Builder
public class ScheduleEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    @Column(nullable = false)
    @ColumnDefault("'기타'")
    private String sclass; //분류

    @Column(nullable = false)
    private String stitle; //제목

    @Column(columnDefinition = "longtext", nullable = true)
    private String scontent; //내용

    @Column
    private boolean sstate; //상태

    @Column
    private String sstart; //시작일

    @Column
    private String send; //종료일

    public ScheduleDto ToDto(){
        return ScheduleDto.builder()
                .sno(this.sno)
                .sclass(this.sclass)
                .stitle(this.stitle)
                .scontent(this.scontent)
                .sstate(this.sstate)
                .sstart(this.sstart)
                .send(this.send)
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .build();
    }

    // 일정 전체 출력
    public ScheduleDto allScheduleToDto(){
        return ScheduleDto.builder()
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
