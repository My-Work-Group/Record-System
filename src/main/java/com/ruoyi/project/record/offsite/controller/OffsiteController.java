package com.ruoyi.project.record.offsite.controller;


import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.AuthorizationUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.offsite.service.ICaseService;
import com.ruoyi.project.system.post.service.IPostService;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.role.service.IRoleService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/record/offsite")
public class OffsiteController extends BaseController {

    private String prefix = "/record/offsite";

    @Autowired
    private ICaseService caseService;

    @RequiresPermissions("record:offsite:view")
    @GetMapping()
    public String offsite() {
        return prefix + "/offsite";
    }


//    /**
//     * 新增案件
//     */
//    @GetMapping("/add")
//    public String add(ModelMap mmap) {
//        mmap.put("roles", roleService.selectRoleAll().stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
//        mmap.put("posts", postService.selectPostAll());
//        return prefix + "/add";
//    }


    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)

    {
        return prefix + "/add";
    }


    /**
     * 新增保存用户
     */
    @RequiresPermissions("record:offsite:add")
    //@Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OffSiteCase offSiteCase) {
//        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user.getLoginName()))) {
//            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
//        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
//                && UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
//            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
//        } else if (StringUtils.isNotEmpty(user.getEmail())
//                && UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
//            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
//        }
        System.out.println(offSiteCase.toString());
        return toAjax(caseService.insertCase(offSiteCase));
    }


    public void addSave1(OffSiteCase offSiteCase) {
        caseService.selectCaseList(offSiteCase);
    }
    public void addSave2(OffSiteCase offSiteCase) {
        caseService.updateCase(offSiteCase);

    }
    public void addSave3(OffSiteCase offSiteCase) {
        caseService.updateCaseInfo(offSiteCase);
    }
    public void addSave4(OffSiteCase offSiteCase) {

    }





}

