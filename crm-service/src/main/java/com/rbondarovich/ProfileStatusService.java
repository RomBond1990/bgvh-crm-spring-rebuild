package com.rbondarovich;

import com.rbondarovich.beans.ProfileStatusBean;

public interface ProfileStatusService {

    Iterable<ProfileStatusBean> getAllProfileStatuses();

    ProfileStatusBean getProfileStatusById(Integer profileStatusId);

    void saveProfileStatus(ProfileStatusBean profile);

    void deleteProfileStatus(Integer profileStatusId);
}
