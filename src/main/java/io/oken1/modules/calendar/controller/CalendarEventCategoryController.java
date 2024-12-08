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

import io.oken1.modules.calendar.entity.CalendarEventCategoryEntity;
import io.oken1.modules.calendar.service.CalendarEventCategoryService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;


/**
 * 活动类目
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "活动类目", tags = {"活动类目"})
@RestController
@RequestMapping("calendar/category")
public class CalendarEventCategoryController {
    @Autowired
    private CalendarEventCategoryService calendarEventCategoryService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendareventcategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = calendarEventCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendareventcategory:info")
    public R info(@PathVariable("id") String id) {
        CalendarEventCategoryEntity calendarEventCategory = calendarEventCategoryService.getById(id);

        return R.ok().put("calendarEventCategory", calendarEventCategory);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendareventcategory:save")
    public R save(@RequestBody CalendarEventCategoryEntity calendarEventCategory) {
        calendarEventCategoryService.save(calendarEventCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendareventcategory:update")
    public R update(@RequestBody CalendarEventCategoryEntity calendarEventCategory) {
        calendarEventCategoryService.updateById(calendarEventCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendareventcategory:delete")
    public R delete(@RequestBody String[] ids) {
        calendarEventCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 根据游戏id获取类目列表
     */
    @ApiOperation("根据游戏id获取类目列表")
    @GetMapping("/categoryList")
    // @RequiresPermissions("calendar:calendareventcategory:categoryList")
    public R categoryList(@RequestParam String gameId) {
        List<LinkedHashMap> data = calendarEventCategoryService.getCategoryList(gameId);

        return R.ok().put("data", data);
    }
}
