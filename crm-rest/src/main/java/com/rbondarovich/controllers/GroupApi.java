package com.rbondarovich.controllers;

import com.rbondarovich.GroupService;
import com.rbondarovich.beans.GroupBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/groups",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupApi {

    private GroupService groupService;

    public GroupApi() {
    }

    @Autowired
    public GroupApi(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<Iterable<GroupBean>> getAllGroups() {
        Iterable<GroupBean> allGroups = groupService.getAllGroups();
        ResponseEntity<Iterable<GroupBean>> response = new ResponseEntity<>(allGroups, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupBean> getGroupById(@PathVariable("groupId") Integer groupId) {
        GroupBean groupBean = groupService.getGroupById(groupId);
        ResponseEntity<GroupBean> response = new ResponseEntity<>(groupBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<GroupBean> saveGroup (@RequestBody GroupBean groupBean) {
        groupService.saveGroup(groupBean);
        ResponseEntity<GroupBean> response = new ResponseEntity<>(groupBean, HttpStatus.OK);

        return response;
    }

    @PutMapping("{groupId}")
    public ResponseEntity<Void> updateGroup (@PathVariable("groupId") GroupBean groupBeanFromDB, @RequestBody GroupBean groupBean) {

        BeanUtils.copyProperties(groupBean, groupBeanFromDB);
        groupService.saveGroup(groupBeanFromDB);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("groupId") Integer groupId){
        groupService.deleteGroup(groupId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
