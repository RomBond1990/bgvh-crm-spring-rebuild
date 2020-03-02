package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Integer> {
}
