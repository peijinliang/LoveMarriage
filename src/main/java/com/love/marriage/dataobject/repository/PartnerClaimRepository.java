package com.love.marriage.dataobject.repository;

import com.love.marriage.dataobject.bean.PartnerClaim;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 */
public interface PartnerClaimRepository extends JpaRepository<PartnerClaim, Integer> {

    PartnerClaim findByUserId(int userId);

}


