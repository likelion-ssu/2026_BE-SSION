package likelion_be.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(Model model) {

        /*
            TODO: 이름, 학과, 이메일, 관심 분야를 해당하는 내용으로 교체해주세요
                ex) model.addAttribute("name", "조멋사");
         */
        model.addAttribute("name", "강성욱");
        model.addAttribute("major", "컴퓨터학부");
        model.addAttribute("email", "kkcc4104@soongsil.ac.kr");
        model.addAttribute("interest", "헬스");
        /*
            TODO: 기술스택에 해당하는 내용을 추가해주세요
                ex) List.of(
                "Java",
                "Spring Boot",
                "Python",
                "Django");
         */
        model.addAttribute("skills", List.of(
                "Java",
                "Spring Boot",
                "Thymeleaf"
        ));

        return "profile";
    }
}

