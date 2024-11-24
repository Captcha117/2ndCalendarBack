package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.service.CalendarEventRewardService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;



/**
 * 活动奖励
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "活动奖励", tags = {"活动奖励"})
@RestController
@RequestMapping("calendar/eventReward")
public class CalendarEventRewardController {
    @Autowired
    private CalendarEventRewardService calendarEventRewardService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendareventreward:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = calendarEventRewardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendareventreward:info")
    public R info(@PathVariable("id") String id){
		CalendarEventRewardEntity calendarEventReward = calendarEventRewardService.getById(id);

        return R.ok().put("calendarEventReward", calendarEventReward);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendareventreward:save")
    public R save(@RequestBody CalendarEventRewardEntity calendarEventReward){
		calendarEventRewardService.save(calendarEventReward);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendareventreward:update")
    public R update(@RequestBody CalendarEventRewardEntity calendarEventReward){
		calendarEventRewardService.updateById(calendarEventReward);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendareventreward:delete")
    public R delete(@RequestBody String[] ids){
		calendarEventRewardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
