package com.jantoni1.recruitmentapp.userprovider;

public interface CurrentUserProvider {
    String getDisplayName();
    User getUser();
}