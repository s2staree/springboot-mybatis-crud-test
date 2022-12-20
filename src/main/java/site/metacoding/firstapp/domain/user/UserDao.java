package site.metacoding.firstapp.domain.user;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.UserJoinDto;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;

public interface UserDao {

    public void join(UserJoinDto userJoinDto); // 회원가입

    public User login(UserLoginDto userLoginDto); // 로그인

    public void logout(User user); // 로그아웃

    public List<User> findAll(); // 전체회원 찾기

    public List<User> findByRole(String userRole); // 회원Role로 찾기

}
