package com.example.week6.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private String userName;

    private String userSurname;

    private String userMail;

}
