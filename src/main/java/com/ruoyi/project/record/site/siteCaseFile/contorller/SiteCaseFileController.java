package com.ruoyi.project.record.site.siteCaseFile.contorller;

import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 12:57
 */


@Controller
@RequestMapping("/record/site")
public class SiteCaseFileController extends BaseController {

    private String prefix = "record/site";


    @GetMapping()
    public String offsite() {
        return prefix + "/site";
    }


}