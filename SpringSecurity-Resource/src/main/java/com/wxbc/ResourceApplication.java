package com.wxbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResourceApplication {

    @RequestMapping("/msg")
    @ResponseBody
    public Message home(HttpServletRequest request) {
        Object name = request.getAttribute("name");
        Object password = request.getAttribute("password");
        System.out.println(name.toString() + ":" + password.toString());
        return new Message("msg");
    }

    @PostMapping("/insert")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void insert(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "password", required = false) String password,
                       @RequestBody Message message) {
        System.out.println(name);
        System.out.println(password);
        System.out.println(message);

    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

}

@Getter
@Setter
@ToString
class Message {
    private String id = UUID.randomUUID().toString();
    private String content;
    private String name;
    private String password;

    Message() {
    }

    public Message(String content) {
        this.content = content;
    }
}