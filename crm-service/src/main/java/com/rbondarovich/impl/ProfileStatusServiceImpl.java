package com.rbondarovich.impl;

import com.rbondarovich.ProfileStatusService;
import com.rbondarovich.beans.ProfileStatusBean;
import com.rbondarovich.dao.ProfileStatusDao;
import com.rbondarovich.dao.entities.ProfileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileStatusServiceImpl implements ProfileStatusService {

    private ProfileStatusDao profileStatusDao;

    private EntityBeanConverterImpl converter;

    public ProfileStatusServiceImpl() {
    }

    @Autowired
    public ProfileStatusServiceImpl(ProfileStatusDao profileStatusDao, EntityBeanConverterImpl converter) {
        this.profileStatusDao = profileStatusDao;
        this.converter = converter;
    }

    @Override
    public Iterable<ProfileStatusBean> getAllProfileStatuses() {
        List<ProfileStatus> profileStatuses = profileStatusDao.findAll();
        List<ProfileStatusBean> profileStatusBean = converter.convertToBeanList(profileStatuses, ProfileStatusBean.class);

        return profileStatusBean;
    }

    @Override
    public ProfileStatusBean getProfileStatusById(Integer profileStatusId) {
        ProfileStatus profileStatus = profileStatusDao.getOne(profileStatusId);
        ProfileStatusBean profileStatusBean = converter.convertToBean(profileStatus, ProfileStatusBean.class);
        return profileStatusBean;
    }

    @Override
    public void saveProfileStatus(ProfileStatusBean profileStatus) {
        ProfileStatus profileStatusEntity = converter.convertToEntity(profileStatus, ProfileStatus.class);
        profileStatusDao.save(profileStatusEntity);
    }

    @Override
    public void deleteProfileStatus(Integer profileStatusId) {
        profileStatusDao.deleteById(profileStatusId);
    }
}
