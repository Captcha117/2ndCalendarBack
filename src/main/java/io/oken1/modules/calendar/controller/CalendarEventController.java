package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.model.EventModel;
import io.oken1.modules.calendar.service.CalendarEventRewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.service.CalendarEventService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;

import static io.oken1.common.utils.MyUtils.*;


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
    @Autowired
    private CalendarEventRewardService calendarEventRewardService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendarevent:list")
    public R list(@RequestBody Map<String, Object> params) {
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
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/saveEvent")
    // @RequiresPermissions("calendar:calendarevent:saveEvent")
    public R saveEvent(@RequestBody EventModel event) {
//        String eventId = myUUID();
//        event.setId(eventId);
        calendarEventService.save(event);
//        List<CalendarEventRewardEntity> rewardList = event.getRewardList();
//        rewardList.forEach(x -> {
//            x.setEventId(eventId);
//            x.setId(myUUID());
//        });
//        calendarEventRewardService.saveBatch(rewardList);

        return R.ok();
    }

    /**
     * 活动分页列表
     */
    @ApiOperation("活动分页列表")
    @PostMapping("/eventList")
    public R eventPageList(@RequestBody Map<String, Object> params) {
        PageUtils data = calendarEventService.getPageList(params);

        return R.ok().put("data", data);
    }


    /**
     * 活动分页列表
     */
    @ApiOperation("根据游戏id活动分页列表")
    @PostMapping("/eventListByGameIds")
    public R eventListByGameIds(@RequestBody String[] ids) {
        List<EventModel> data = calendarEventService.getByIds(ids);

        return R.ok().put("data", data);
    }
}
