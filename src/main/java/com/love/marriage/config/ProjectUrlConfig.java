package com.love.marriage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Crete by Marlon
 * Create Date: 1/16/2018
 * Class Describe
 **/

@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 项目前缀
     */
    public String loveMarry;

}
