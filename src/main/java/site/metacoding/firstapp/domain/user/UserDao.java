package site.metacoding.firstapp.domain.user;

import site.metacoding.firstapp.web.dto.request.UserJoinDto;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;

public interface UserDao {

    public User findByUserId(String userId); // 회원Id찾기

    public User findByUserName(String userName); // 회원이름찾기

    public void join(UserJoinDto userJoinDto); // 회원가입

    public User login(UserLoginDto userLoginDto); // 로그인

    public void logout(User user); // 로그아웃

}
