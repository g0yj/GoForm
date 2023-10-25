package GoForm.model.dto;

import lombok.*;


@AllArgsConstructor@NoArgsConstructor
@Setter@Getter@Builder@ToString
public class MemberDto {
    private int mno;
    private String mid;
    private String mpw;
    private String mname;
    private String mphone;


}
