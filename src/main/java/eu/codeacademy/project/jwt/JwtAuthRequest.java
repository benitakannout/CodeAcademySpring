package eu.codeacademy.project.jwt;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class JwtAuthRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

}
