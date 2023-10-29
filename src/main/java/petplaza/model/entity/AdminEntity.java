package petplaza.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import petplaza.model.dto.AdminDto;

import javax.persistence.*;

@Entity
@Table(name="admin")
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString@Builder
public class AdminEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;
    @Column(name="aid",length = 20, nullable = false,unique = true)
    private String aid;
    @Column(name="apw",length = 20, nullable = false, unique = true)
    private String apw;
    @Column(name="aname", length=10, nullable = false, unique = true)
    private String aname;
    @Column(name="aphone", length = 13, nullable = false, unique = true)
    private String aphone;
    @ColumnDefault("'ceo'")
    private String arole;

    public AdminDto toDto(){
        return AdminDto.builder()
                .ano(this.getAno())
                .aid(this.getAid())
                .apw(this.getApw())
                .aname(this.getAname())
                .aphone(this.getAphone())
                .arole(this.getArole())
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .build();
    }

}
