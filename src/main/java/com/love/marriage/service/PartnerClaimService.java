package com.love.marriage.service;

import com.love.marriage.dataobject.bean.PartnerClaim;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 * <p>
 * 对于意中人的增加和修改
 **/
public interface PartnerClaimService {

    public PartnerClaim create(PartnerClaim partnerClaim);

    public PartnerClaim save(PartnerClaim partnerClaim);

    public PartnerClaim findOneByUserId(int userId);


}
