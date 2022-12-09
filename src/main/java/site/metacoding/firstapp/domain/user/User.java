package site.metacoding.firstapp.domain.user;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Timestamp createdAt;
}
