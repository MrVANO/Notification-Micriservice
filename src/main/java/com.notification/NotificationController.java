package com.notification;

import com.requests.EmailMessageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotificationController {
    @ResponseBody
    @RequestMapping(value = "/sendEmailMessage", method = RequestMethod.POST, produces = "application/json")
    public String sendEmailMessage(@RequestBody EmailMessageRequest request) {
        SendEmailSMTP emailSMTP = new SendEmailSMTP();
        return emailSMTP.sendMessage(request.getRecipientAddress(), request.getSubject(), request.getText());
    }
}