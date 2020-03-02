package com.rbondarovich.impl;

import com.rbondarovich.GroupService;
import com.rbondarovich.beans.GroupBean;
import com.rbondarovich.dao.GroupDao;
import com.rbondarovich.dao.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    private EntityBeanConverterImpl converter;

    public GroupServiceImpl() {
    }

    @Autowired
    public GroupServiceImpl(GroupDao groupDao, EntityBeanConverterImpl converter) {
        this.groupDao = groupDao;
        this.converter = converter;
    }

    @Override
    public Iterable<GroupBean> getAllGroups() {
        List<Group> groups = groupDao.findAll();
        List<GroupBean> groupBeans = converter.convertToBeanList(groups, GroupBean.class);

        return groupBeans;
    }

    @Override
    public GroupBean getGroupById(Integer groupId) {
        Group group = groupDao.getOne(groupId);
        GroupBean groupBean = converter.convertToBean(group, GroupBean.class);
        return groupBean;
    }

    @Override
    public void saveGroup(GroupBean group) {
        Group groupEntity = converter.convertToEntity(group, Group.class);
        groupDao.save(groupEntity);
    }

    @Override
    public void deleteGroup(Integer groupId) {
        groupDao.deleteById(groupId);
    }
}
