package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarEventPlatformEntity;
import io.oken1.modules.calendar.service.CalendarEventPlatformService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;



/**
 * 活动平台
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "活动平台", tags = {"活动平台"})
@RestController
@RequestMapping("calendar/platform")
public class CalendarEventPlatformController {
    @Autowired
    private CalendarEventPlatformService calendarEventPlatformService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendareventplatform:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = calendarEventPlatformService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendareventplatform:info")
    public R info(@PathVariable("id") String id){
		CalendarEventPlatformEntity calendarEventPlatform = calendarEventPlatformService.getById(id);

        return R.ok().put("calendarEventPlatform", calendarEventPlatform);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendareventplatform:save")
    public R save(@RequestBody CalendarEventPlatformEntity calendarEventPlatform){
		calendarEventPlatformService.save(calendarEventPlatform);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendareventplatform:update")
    public R update(@RequestBody CalendarEventPlatformEntity calendarEventPlatform){
		calendarEventPlatformService.updateById(calendarEventPlatform);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendareventplatform:delete")
    public R delete(@RequestBody String[] ids){
		calendarEventPlatformService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
