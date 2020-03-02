package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileStatusDao extends JpaRepository<ProfileStatus, Integer> {
}
