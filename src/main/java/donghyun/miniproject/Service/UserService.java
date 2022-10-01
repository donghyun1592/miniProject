package donghyun.miniproject.Service;


import donghyun.miniproject.Bean.User;
import donghyun.miniproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // String을 return 하는 이유 :
    // 회원가입 완료창에서 "<name>님의 회원가입이 완료되었습니다." 문구를 위해
    public HashMap<String, Object> signUp(User user){

        HashMap<String, Object> returnResult = new HashMap<>();

        // 유효성 검사
        //|| user.getAccountId().matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
        if(user.getAccountId() == null || user.getAccountId().length() > 50 || user.getAccountId().equals("") ) {
            returnResult.put("status", false);
            returnResult.put("failure reason", "account id");
            return returnResult;
        }
        // || user.getName().matches("^[가-힣A-Za-z]$")
        if(user.getName() == null || user.getName().length() > 20 || user.getName().equals("")) {
            returnResult.put("status", false);
            returnResult.put("failure reason", "name");
            return returnResult;
        }
        //|| user.getPhoneNum().matches("^[0-9]$")
        if(user.getPhoneNum() == null || user.getPhoneNum().length() > 12 || user.getPhoneNum().equals("") ) {
            returnResult.put("status", false);
            returnResult.put("failure reason", "phone number");
            return returnResult;
        }

        /* TO DO :: 비밀번호 Encode */

        try{
            userRepository.save(user);
            returnResult.put("status", true);
            returnResult.put("user", userRepository.findByAccountId(user.getAccountId()));
        } catch (DataAccessException e){
            returnResult.put("status", false);
            returnResult.put("failure reason", "unknowable reason");
        }

        return returnResult;
    }
}
