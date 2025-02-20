package com.Twitter.Jarvis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserConfigurationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String location;
    private String website;
    private String dateOfBirth;
    private String email;
    private String password;
    private String mobile;
    private String image;
    private String backGroundImage;
    private String bio;
    private boolean req_user;
    private boolean login_with_google;

    @JsonIgnore
    @ManyToMany
    private List<UserConfigurationModel> followers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<UserConfigurationModel> followings = new ArrayList<>();

    @Override
    public String toString() {
        return "UserConfigurationModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", image='" + image + '\'' +
                ", backGroundImage='" + backGroundImage + '\'' +
                ", bio='" + bio + '\'' +
                ", req_user=" + req_user +
                ", login_with_google=" + login_with_google +
                '}';
    }
}
