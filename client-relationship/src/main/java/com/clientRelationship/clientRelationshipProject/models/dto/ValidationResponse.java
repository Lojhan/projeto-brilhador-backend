package com.clientRelationship.clientRelationshipProject.models.dto;

import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;

public class ValidationResponse {
    boolean valid;
    UserResponse user;

    public ValidationResponse(
        boolean valid,
        UserResponse user
    ) {
        this.valid = valid;
        this.user = user;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
