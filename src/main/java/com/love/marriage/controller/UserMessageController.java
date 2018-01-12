package com.love.marriage.controller;

import com.love.marriage.dataobject.bean.UserMessage;
import com.love.marriage.enums.ResultEnum;
import com.love.marriage.exception.LoveException;
import com.love.marriage.form.UserMessageForm;
import com.love.marriage.service.UserMessageService;
import com.love.marriage.utils.ResultVOUtils;
import com.love.marriage.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 **/

@RestController
@RequestMapping("/user/message")
@Slf4j
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("/create")
    public ResultVO<UserMessage> createUserMessage(@Valid UserMessageForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【参数不正确】,userMessageForm={}", form);
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        UserMessage userMessage = new UserMessage();
        BeanUtils.copyProperties(form, userMessage);
        UserMessage userSava = userMessageService.save(userMessage);
        return ResultVOUtils.success(userSava);
    }

    @PutMapping("/save")
    public ResultVO<UserMessage> saveUserMessage(@Valid UserMessageForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【参数不正确】,userMessageForm={}", form);
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        UserMessage userMessage = userMessageService.findOneByUserId(Integer.parseInt(form.getUserId()));
        BeanUtils.copyProperties(form, userMessage);
        UserMessage userSava = userMessageService.save(userMessage);
        return ResultVOUtils.success(userSava);
    }

    @GetMapping("/detail")
    public ResultVO<UserMessage> findOneUserMessage(@RequestParam(value = "userId") Integer userId) {
        UserMessage userMessage = userMessageService.findOneByUserId(userId);
        if (userMessage == null) {
            throw new LoveException(ResultEnum.NOT_USERMESSAGE_ERROR.getCode(), ResultEnum.NOT_USERMESSAGE_ERROR.getMessage());
        }
        return ResultVOUtils.success(userMessage);
    }

    @PutMapping("/nickname")
    public ResultVO updateNickByUserId(@RequestParam(value = "userId") Integer userId,
                                       @RequestParam(value = "name") String name) {
        UserMessage userMessage = userMessageService.findOneByUserId(userId);
        if (userMessage == null) {
            throw new LoveException(ResultEnum.NOT_USERMESSAGE_ERROR.getCode(), ResultEnum.NOT_USERMESSAGE_ERROR.getMessage());
        }
        userMessageService.updateNickName(userId, name);
        return ResultVOUtils.success();
    }


    @PutMapping("/avater")
    public ResultVO updateAvaterByUserId(@RequestParam(value = "userId") Integer userId,
                                         @RequestParam(value = "avater") String avater) {
        UserMessage userMessage = userMessageService.findOneByUserId(userId);
        if (userMessage == null) {
            throw new LoveException(ResultEnum.NOT_USERMESSAGE_ERROR.getCode(), ResultEnum.NOT_USERMESSAGE_ERROR.getMessage());
        }
        userMessageService.updateAvaterByUserId(userId, avater);
        return ResultVOUtils.success();
    }

    @PutMapping("/introduction")
    public ResultVO updateSelfIntroduction(@RequestParam(value = "userId") Integer userId,
                                           @RequestParam(value = "introduction") String introduction) {
        UserMessage userMessage = userMessageService.findOneByUserId(userId);
        if (userMessage == null) {
            throw new LoveException(ResultEnum.NOT_USERMESSAGE_ERROR.getCode(), ResultEnum.NOT_USERMESSAGE_ERROR.getMessage());
        }
        userMessageService.updateSelfIntroduction(userId, introduction);
        return ResultVOUtils.success();
    }

    @PutMapping("/video")
    public ResultVO updateIntroduceVideo(@RequestParam(value = "userId") Integer userId,
                                         @RequestParam(value = "videoUrl") String updateIntroduceVideo) {
        UserMessage userMessage = userMessageService.findOneByUserId(userId);
        if (userMessage == null) {
            throw new LoveException(ResultEnum.NOT_USERMESSAGE_ERROR.getCode(), ResultEnum.NOT_USERMESSAGE_ERROR.getMessage());
        }
        userMessageService.updateIntroduceVideo(userId, updateIntroduceVideo);
        return ResultVOUtils.success();
    }

}
