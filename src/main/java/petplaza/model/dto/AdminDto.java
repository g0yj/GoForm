package petplaza.model.dto;

import lombok.*;
import petplaza.model.entity.AdminEntity;

import java.time.LocalDateTime;


@AllArgsConstructor@NoArgsConstructor
@Setter@Getter@Builder@ToString
public class AdminDto {
    private int ano;
    private String aid;
    private String apw;
    private String aname;
    private String aphone;
    private String arole;

    private LocalDateTime cdate;
    private LocalDateTime udate;

    public AdminEntity toEntity(){
        return AdminEntity.builder()
                .ano(this.getAno())
                .aid(this.getAid())
                .apw(this.getApw())
                .aname(this.getAname())
                .aphone(this.getAphone())
                .arole(this.getArole())
                .build();
    }
}
