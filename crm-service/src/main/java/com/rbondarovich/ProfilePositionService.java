package com.rbondarovich;


import com.rbondarovich.beans.ProfilePositionBean;

public interface ProfilePositionService {

    Iterable<ProfilePositionBean> getAllProfilePositions();

    ProfilePositionBean getProfilePositionById(Integer profilePositionId);

    void saveProfilePosition(ProfilePositionBean profilePosition);

    void deleteProfilePosition(Integer profilePositionId);
}
