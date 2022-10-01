package donghyun.miniproject.Controller;

import donghyun.miniproject.Bean.User;
import donghyun.miniproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:8083")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("STATUS", userService.signUp(user));
        return ResponseEntity.ok(result);
    }
}
