package com.Controller;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.Entity.User;
import com.Service.userService;
import com.dto.ApiResponse;
import com.dto.UserDto;
import com.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user/action")
public class userController {

    @Autowired
    private userService us;

    @Autowired
    private JavaMailSender jms;

    @PostMapping("/registeruser")
    public ResponseEntity<ApiResponse<UserDto>> registerUser(@Validated @RequestBody User user) {
        log.info("user registered is :- " + user);
        us.getuserInservice(user);
        ApiResponse<UserDto> response =
                new ApiResponse<>("User registered successfully", HttpStatus.CREATED.value(), null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getuserId/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getuserById(@PathVariable("id") int uid) {
        log.info("Fetching user with id :- " + uid);
        UserDto user = us.getuserByidinservice(uid);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id: " + uid);
        }
        ApiResponse<UserDto> response =
                new ApiResponse<>("User exists", HttpStatus.OK.value(), user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        List<UserDto> users = us.getAllUsers();
        ApiResponse<List<UserDto>> response =
                new ApiResponse<>("All users fetched successfully", HttpStatus.OK.value(), users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable int id, @RequestBody User user) {
        UserDto updated = us.updateUser(id, user);
        if (updated == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        ApiResponse<UserDto> response =
                new ApiResponse<>("User updated successfully", HttpStatus.OK.value(), updated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable int id) {
        boolean deleted = us.deleteUser(id);
        if (!deleted) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        ApiResponse<Void> response =
                new ApiResponse<>("User deleted successfully", HttpStatus.OK.value(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/sendmail")
    public ResponseEntity<ApiResponse<Void>> sendEmail() throws MessagingException {
        MimeMessage mm = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm, true);

        helper.setFrom("mayurkeswad8123@gmail.com");
        helper.setTo("mayurkeswad8123@gmail.com");
        helper.setSubject("Mime Message sending :- ");
        helper.setText("Sending Attachments");
        helper.addAttachment("offer letter", new File("C:\\offerletter.pdf"));

        jms.send(mm);

        ApiResponse<Void> response =
                new ApiResponse<>("Mail sent successfully", HttpStatus.OK.value(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
