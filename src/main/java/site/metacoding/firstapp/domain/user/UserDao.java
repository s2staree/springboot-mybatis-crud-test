package site.metacoding.firstapp.domain.user;

import site.metacoding.firstapp.web.dto.request.UserJoinDto;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;

public interface UserDao {

    public void join(UserJoinDto userJoinDto); // 회원가입

    public User login(UserLoginDto userLoginDto); // 로그인

    public void logout(User user); // 로그아웃

    public User findById(Integer userId); // 유저Id 찾기

}
