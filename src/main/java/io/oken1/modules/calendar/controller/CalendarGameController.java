package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarGameEntity;
import io.oken1.modules.calendar.service.CalendarGameService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;


/**
 * 游戏
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "游戏", tags = {"游戏"})
@RestController
@RequestMapping("calendar/game")
public class CalendarGameController {
    @Autowired
    private CalendarGameService calendarGameService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendargame:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = calendarGameService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendargame:info")
    public R info(@PathVariable("id") String id) {
        CalendarGameEntity calendarGame = calendarGameService.getById(id);

        return R.ok().put("calendarGame", calendarGame);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendargame:save")
    public R save(@RequestBody CalendarGameEntity calendarGame) {
        calendarGameService.save(calendarGame);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendargame:update")
    public R update(@RequestBody CalendarGameEntity calendarGame) {
        calendarGameService.updateById(calendarGame);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendargame:delete")
    public R delete(@RequestBody String[] ids) {
        calendarGameService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
