package com.rbondarovich.impl;

import com.rbondarovich.ProfileService;
import com.rbondarovich.beans.ProfileBean;
import com.rbondarovich.dao.ProfileDao;
import com.rbondarovich.dao.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;

    private EntityBeanConverterImpl converter;

    public ProfileServiceImpl() {
    }

    @Autowired
    public ProfileServiceImpl(ProfileDao profileDao, EntityBeanConverterImpl converter) {
        this.profileDao = profileDao;
        this.converter = converter;
    }

    @Override
    public Iterable<ProfileBean> getAllProfiles() {
        List<Profile> profiles = profileDao.findAll();
        List<ProfileBean> profileBeans = converter.convertToBeanList(profiles, ProfileBean.class);

        return profileBeans;
    }

    @Override
    public ProfileBean getProfileById(Integer profileId) {
        Profile profile = profileDao.getOne(profileId);
        ProfileBean profileBean = converter.convertToBean(profile, ProfileBean.class);

        return profileBean;
    }

    @Override
    public void saveProfile(ProfileBean profile) {
        Profile profileEntity = converter.convertToEntity(profile, Profile.class);
        profileDao.save(profileEntity);
    }

    @Override
    public void deleteProfile(Integer profileId) {
        profileDao.deleteById(profileId);
    }
}
