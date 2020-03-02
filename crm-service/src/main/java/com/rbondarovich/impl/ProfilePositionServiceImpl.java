package com.rbondarovich.impl;

import com.rbondarovich.ProfilePositionService;
import com.rbondarovich.beans.ProfilePositionBean;
import com.rbondarovich.dao.ProfilePositionDao;
import com.rbondarovich.dao.entities.ProfilePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfilePositionServiceImpl implements ProfilePositionService {

    private ProfilePositionDao profilePositionDao;

    private EntityBeanConverterImpl converter;

    public ProfilePositionServiceImpl() {
    }

    @Autowired
    public ProfilePositionServiceImpl(ProfilePositionDao profilePositionDao, EntityBeanConverterImpl converter) {
        this.profilePositionDao = profilePositionDao;
        this.converter = converter;
    }

    @Override
    public Iterable<ProfilePositionBean> getAllProfilePositions() {
        List<ProfilePosition> profilePositions = profilePositionDao.findAll();
        List<ProfilePositionBean> profilePositionBean = converter.convertToBeanList(profilePositions, ProfilePositionBean.class);

        return profilePositionBean;
    }

    @Override
    public ProfilePositionBean getProfilePositionById(Integer profilePositionId) {
        ProfilePosition profilePosition = profilePositionDao.getOne(profilePositionId);
        ProfilePositionBean profilePositionBean = converter.convertToBean(profilePosition, ProfilePositionBean.class);
        return profilePositionBean;
    }

    @Override
    public void saveProfilePosition(ProfilePositionBean profilePosition) {
        ProfilePosition profilePositionEntity = converter.convertToEntity(profilePosition, ProfilePosition.class);
        profilePositionDao.save(profilePositionEntity);
    }

    @Override
    public void deleteProfilePosition(Integer profilePositionId) {
        profilePositionDao.deleteById(profilePositionId);
    }
}
