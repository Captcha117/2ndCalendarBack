package io.oken1.modules.calendar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.calendar.entity.CalendarGameRewardEntity;
import io.oken1.modules.calendar.service.CalendarGameRewardService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;



/**
 * 游戏奖励
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 01:20:02
 */
@Api(value = "游戏奖励", tags = {"游戏奖励"})
@RestController
@RequestMapping("calendar/reward")
public class CalendarGameRewardController {
    @Autowired
    private CalendarGameRewardService calendarGameRewardService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendargamereward:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = calendarGameRewardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendargamereward:info")
    public R info(@PathVariable("id") String id){
		CalendarGameRewardEntity calendarGameReward = calendarGameRewardService.getById(id);

        return R.ok().put("calendarGameReward", calendarGameReward);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendargamereward:save")
    public R save(@RequestBody CalendarGameRewardEntity calendarGameReward){
		calendarGameRewardService.save(calendarGameReward);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendargamereward:update")
    public R update(@RequestBody CalendarGameRewardEntity calendarGameReward){
		calendarGameRewardService.updateById(calendarGameReward);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendargamereward:delete")
    public R delete(@RequestBody String[] ids){
		calendarGameRewardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 根据游戏id获取奖励列表
     */
    @ApiOperation("根据游戏id获取类目列表")
    @GetMapping("/getRewardListByGameId")
    // @RequiresPermissions("calendar:calendareventcategory:categoryList")
    public R getRewardListByGameId(@RequestParam String gameId) {
        List<CalendarEventRewardEntity> data = calendarGameRewardService.getRewardListByGameId(gameId);

        return R.ok().put("data", data);
    }
}
