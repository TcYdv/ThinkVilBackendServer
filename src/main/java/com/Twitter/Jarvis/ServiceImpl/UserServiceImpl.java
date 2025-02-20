package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Config.JwtProvider;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Repository.UserRepository;
import com.Twitter.Jarvis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public UserConfigurationModel findUserById(Long userId) throws UserException {
        UserConfigurationModel user = userRepository.findById(userId).orElseThrow(()-> new UserException("user not found with id "+userId));
        return user;
    }
}
