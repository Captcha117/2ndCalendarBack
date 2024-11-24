package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarVersionEntity;
import io.oken1.modules.calendar.service.CalendarVersionService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;



/**
 * 版本
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "版本", tags = {"版本"})
@RestController
@RequestMapping("calendar/version")
public class CalendarVersionController {
    @Autowired
    private CalendarVersionService calendarVersionService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendarversion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = calendarVersionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendarversion:info")
    public R info(@PathVariable("id") String id){
		CalendarVersionEntity calendarVersion = calendarVersionService.getById(id);

        return R.ok().put("calendarVersion", calendarVersion);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendarversion:save")
    public R save(@RequestBody CalendarVersionEntity calendarVersion){
		calendarVersionService.save(calendarVersion);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendarversion:update")
    public R update(@RequestBody CalendarVersionEntity calendarVersion){
		calendarVersionService.updateById(calendarVersion);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendarversion:delete")
    public R delete(@RequestBody String[] ids){
		calendarVersionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
