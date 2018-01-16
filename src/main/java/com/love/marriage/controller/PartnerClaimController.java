package com.love.marriage.controller;

import com.love.marriage.dataobject.bean.PartnerClaim;
import com.love.marriage.enums.ResultEnum;
import com.love.marriage.exception.LoveException;
import com.love.marriage.form.PartnerClaimForm;
import com.love.marriage.service.PartnerClaimService;
import com.love.marriage.utils.ResultVOUtils;
import com.love.marriage.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 **/
@RestController
@RequestMapping("/partner")
@Slf4j
public class PartnerClaimController {

    @Autowired
    private PartnerClaimService partnerClaimService;

    @PostMapping("/create")
    public ResultVO<PartnerClaim> createPartnerClaim(@Valid PartnerClaimForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【参数不正确】,userMessageForm={}", form);
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        PartnerClaim partnerClaim = new PartnerClaim();
        BeanUtils.copyProperties(form, partnerClaim);
        PartnerClaim partner = partnerClaimService.save(partnerClaim);
        return ResultVOUtils.success(partner);
    }

    @PutMapping("/save")
    public ResultVO<PartnerClaim> savePartnerClaim(@Valid PartnerClaimForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【参数不正确】,userMessageForm={}", form);
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        PartnerClaim partnerClaim = partnerClaimService.findOneByUserId(form.getUserId());
        BeanUtils.copyProperties(form, partnerClaim);
        PartnerClaim partner = partnerClaimService.save(partnerClaim);
        return ResultVOUtils.success(partner);
    }

}
