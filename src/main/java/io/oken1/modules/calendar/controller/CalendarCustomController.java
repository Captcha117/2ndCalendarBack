package io.oken1.modules.calendar.controller;

import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;
import io.oken1.modules.calendar.dao.CalendarCustomDao;
import io.oken1.modules.calendar.entity.CalendarCustomEntity;
import io.oken1.modules.calendar.service.CalendarCustomService;
import io.oken1.modules.sys.controller.AbstractController;
import io.oken1.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 自定义日历
 *
 * @author oken1
 * @email /
 * @date 2025-05-14 10:38:02
 */
@Api(value = "自定义日历", tags = {"自定义日历"})
@RestController
@RequestMapping("calendar/custom")
public class CalendarCustomController extends AbstractController {
    @Autowired
    private CalendarCustomService calendarCustomService;
    @Autowired
    private CalendarCustomDao calendarCustomDao;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    // @RequiresPermissions("calendar:calendarcustom:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = calendarCustomService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("calendar:calendarcustom:info")
    public R info(@PathVariable("id") String id) {
        CalendarCustomEntity calendarCustom = calendarCustomService.getById(id);
        if (Objects.equals(calendarCustom.getUserId(), getUserId())) {
            return R.ok().put("data", calendarCustom);
        } else {
            return R.error();
        }
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendarcustom:save")
    public R save(@RequestBody CalendarCustomEntity calendarCustom) {
        calendarCustom.setUserId(getUserId());
        calendarCustomService.save(calendarCustom);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendarcustom:update")
    public R update(@RequestBody CalendarCustomEntity calendarCustom) {
        CalendarCustomEntity entity = calendarCustomService.getById(calendarCustom.getId());
        if (Objects.equals(entity.getUserId(), getUserId())) {
            calendarCustomService.updateById(calendarCustom);
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    // @RequiresPermissions("calendar:calendarcustom:delete")
    public R delete(@RequestBody String[] ids) {
        calendarCustomService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/del")
    // @RequiresPermissions("calendar:calendarcustom:delete")
    public R del(@RequestBody String id) {
        calendarCustomDao.delCustom(id);

        return R.ok();
    }

    /**
     * 列表
     */
    @ApiOperation("自定义日历列表")
    @GetMapping("/customList")
    public R customList() {
        List<LinkedHashMap> data = calendarCustomService.getCustomList(getUserId());

        return R.ok().put("data", data);
    }
}
