package com.rbondarovich.controllers;

import com.rbondarovich.ProfileService;
import com.rbondarovich.beans.ProfileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/profiles",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileApi  {
    
    private ProfileService profileService;

    public ProfileApi() {
    }

    @Autowired
    public ProfileApi(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ProfileBean>> getAllProfiles() {
        Iterable<ProfileBean> allProfiles = profileService.getAllProfiles();
        ResponseEntity<Iterable<ProfileBean>> response = new ResponseEntity<>(allProfiles, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileBean> getProfileById(@PathVariable("profileId") Integer profileId) {
        ProfileBean profileBean = profileService.getProfileById(profileId);
        ResponseEntity<ProfileBean> response = new ResponseEntity<>(profileBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<ProfileBean> saveProfile (@RequestBody ProfileBean profileBean) {
        profileService.saveProfile(profileBean);
        ResponseEntity<ProfileBean> response = new ResponseEntity<>(profileBean, HttpStatus.OK);

        return response;
    }

    @PutMapping("{profileId}")
    public ResponseEntity<Void> updateProfile (@PathVariable("profileId") @RequestBody ProfileBean profileBean) {

        profileService.saveProfile(profileBean);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("profileId") Integer profileId){
        profileService.deleteProfile(profileId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
