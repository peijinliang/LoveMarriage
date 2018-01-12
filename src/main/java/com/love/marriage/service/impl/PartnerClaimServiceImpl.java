package com.love.marriage.service.impl;

import com.love.marriage.dataobject.bean.PartnerClaim;
import com.love.marriage.dataobject.repository.PartnerClaimRepository;
import com.love.marriage.service.PartnerClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 **/
@Service
public class PartnerClaimServiceImpl implements PartnerClaimService {

    @Autowired
    private PartnerClaimRepository partnerClaimRepository;

    @Override
    public PartnerClaim create(PartnerClaim partnerClaim) {
        return partnerClaimRepository.save(partnerClaim);
    }

    @Override
    public PartnerClaim save(PartnerClaim partnerClaim) {
        return partnerClaimRepository.save(partnerClaim);
    }

    @Override
    public PartnerClaim findOneByUserId(int userId) {
        return partnerClaimRepository.findByUserId(userId);
    }

}
