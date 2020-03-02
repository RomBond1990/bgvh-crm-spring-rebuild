package com.rbondarovich.dao;
import com.rbondarovich.dao.entities.ProfilePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePositionDao extends JpaRepository<ProfilePosition, Integer> {
}
