package com.jantoni1.recruitmentapp.userprovider;

import org.springframework.stereotype.Component;

@Component
class CurrentUserProviderImpl implements CurrentUserProvider {
    public String getDisplayName() {
        return null;
    }

    public User getUser() {
        return null;
    }
}