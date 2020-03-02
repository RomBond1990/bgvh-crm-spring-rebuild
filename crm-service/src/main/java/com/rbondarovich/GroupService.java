package com.rbondarovich;

import com.rbondarovich.beans.GroupBean;

public interface GroupService  {

    Iterable<GroupBean> getAllGroups();

    GroupBean getGroupById(Integer groupId);

    void saveGroup(GroupBean group);

    void deleteGroup(Integer groupId);
}
