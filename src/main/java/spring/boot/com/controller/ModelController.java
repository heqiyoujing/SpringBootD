package spring.boot.com.controller;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2018/8/14
 * @description:
 */
@Controller
public class ModelController {


    @Autowired
    UserController userController;

    @RequestMapping("/")
    public String index(ModelMap map) {

        String msg = userController.show("百达宁");
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", msg);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }


}
