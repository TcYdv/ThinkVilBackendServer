package com.Twitter.Jarvis.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController, CustomError {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Your custom error handling logic here

        return "error"; // Assuming "error" is your error view name
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
