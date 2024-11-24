package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.service.CalendarEventService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;


/**
 * 活动
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "活动", tags = {"活动"})
@RestController
@RequestMapping("calendar/event")
public class CalendarEventController {
    @Autowired
    private CalendarEventService calendarEventService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendarevent:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = calendarEventService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendarevent:info")
    public R info(@PathVariable("id") String id) {
        CalendarEventEntity calendarEvent = calendarEventService.getById(id);

        return R.ok().put("calendarEvent", calendarEvent);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendarevent:save")
    public R save(@RequestBody CalendarEventEntity calendarEvent) {
        calendarEventService.save(calendarEvent);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendarevent:update")
    public R update(@RequestBody CalendarEventEntity calendarEvent) {
        calendarEventService.updateById(calendarEvent);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendarevent:delete")
    public R delete(@RequestBody String[] ids) {
        calendarEventService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 列表
     */
    @ApiOperation("活动列表")
    @PostMapping("/eventList")
    public R eventList(@RequestBody String[] ids) {
        List<LinkedHashMap> data = calendarEventService.getByIds(ids);

        return R.ok().put("data", data);
    }
}
