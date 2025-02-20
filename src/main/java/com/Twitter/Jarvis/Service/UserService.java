package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

import java.util.List;

public interface UserService {

    UserConfigurationModel findUserById(Long userId) throws UserException;

}
