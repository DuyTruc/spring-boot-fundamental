package fpt.m2.FPT_QuocLV1.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String userName;
    private String email;
    private String address;
    private int phoneNumber;
}
