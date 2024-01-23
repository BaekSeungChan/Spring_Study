package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloContoller {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // 화면 이름
    }
}
