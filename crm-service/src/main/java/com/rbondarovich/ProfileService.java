package com.rbondarovich;

import com.rbondarovich.beans.ProfileBean;

public interface ProfileService {

    Iterable<ProfileBean> getAllProfiles();

    ProfileBean getProfileById(Integer profileId);

    void saveProfile(ProfileBean profile);

    void deleteProfile(Integer profileId);
}
