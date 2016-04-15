package com.twu.control;


import com.twu.provider.LibraryUsers;
import com.twu.types.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagementUser {
    private List<User> libraryUsers = new ArrayList<>();

    public ManagementUser(){
        this.libraryUsers = new LibraryUsers().createLibraryUsers();
    }

    public boolean loginUser(String userName, String password){

        return this.libraryUsers.stream()
                   .anyMatch(user -> isUserRegistred(user, userName, password) );
    }

    protected boolean isUserRegistred(User user, String userName, String password){
        return isUserNameIsEqualUser(user, userName) && (isPasswordIsEqualPasswordUser(user, password));
    }

    public User getUser(String userName){

        Optional<User> userResult = libraryUsers
                                        .stream()
                                        .filter(user -> isUserNameIsEqualUser(user, userName))
                                        .findFirst();
        return userResult.orElse(null);
    }

    private boolean isUserNameIsEqualUser(User user, String userName) {
        return user.getUserName().equals(userName);
    }

    private boolean isPasswordIsEqualPasswordUser(User user, String password){
        return user.getPassword().equals(password);

    }


}
