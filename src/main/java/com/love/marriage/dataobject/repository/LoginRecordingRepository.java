package com.love.marriage.dataobject.repository;

import com.love.marriage.dataobject.bean.LoginRecording;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/
public interface LoginRecordingRepository extends JpaRepository<LoginRecording, Integer> {

    Page<LoginRecording> findByUserId(int userId, Pageable pageable);

}
