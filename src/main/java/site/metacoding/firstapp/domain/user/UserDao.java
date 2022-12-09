package site.metacoding.firstapp.domain.user;

public interface UserDao {

    public User findByUserId(String userId); // 회원Id찾기

    public User findByUserName(String userName); // 회원이름찾기

    public void join(User user); // 회원가입

    public void login(User user); // 로그인

    public void logout(User user); // 로그아웃

}
