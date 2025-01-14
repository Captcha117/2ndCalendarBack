package io.oken1.modules.calendar.controller;

import java.io.IOException;
import java.util.*;

import cn.hutool.core.util.StrUtil;
import io.oken1.common.utils.MyUtils;
import io.oken1.modules.calendar.dao.CalendarEventDao;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.model.EventModel;
import io.oken1.modules.calendar.service.CalendarEventRewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
    @Autowired
    private CalendarEventDao calendarEventDao;

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
//        CalendarEventEntity calendarEvent = calendarEventService.getById(id);
//        List<CalendarEventRewardEntity> reward = calendarEventRewardService.getRewardListByEventId(id);
        EventModel model = calendarEventDao.getEventById(id);
        return R.ok().put("calendarEvent", model);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    // @RequiresPermissions("calendar:calendarevent:save")
    public R save(@RequestBody EventModel calendarEvent) {
        List<CalendarEventRewardEntity> rewardList = calendarEvent.getRewardList();
        calendarEventService.save(calendarEvent);
        
        rewardList.forEach(x -> x.setEventId(calendarEvent.getId()));
        calendarEventRewardService.saveBatch(rewardList);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    // @RequiresPermissions("calendar:calendarevent:update")
    public R update(@RequestBody EventModel calendarEvent) {
        List<CalendarEventRewardEntity> rewardList = calendarEvent.getRewardList();
        rewardList.forEach(x -> x.setEventId(calendarEvent.getId()));
        calendarEventRewardService.deleteRewardByEventId(calendarEvent.getId());

        calendarEventService.updateById(calendarEvent);
        calendarEventRewardService.saveBatch(rewardList);

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
    @PostMapping("/eventPageList")
    public R eventPageList(@RequestBody Map<String, Object> params) {
        PageUtils data = calendarEventService.getPageList(params);

        return R.ok().put("page", data);
    }


    /**
     * 根据游戏id获取活动列表
     */
    @ApiOperation("根据游戏id获取活动列表")
    @PostMapping("/eventListByGameIds")
    public R eventListByGameIds(@RequestBody String[] ids) {
        List<EventModel> data = calendarEventService.getByIds(ids);

        return R.ok().put("data", data);
    }


    /**
     * 根据文章ID获取活动详情
     */
    @ApiOperation("根据文章ID获取活动详情")
    @PostMapping("/getEventDetailByPostId")
    public R getEventDetailByPostId(@RequestBody Map<String, Object> params) throws IOException {
        String postId = StrUtil.toString(params.get("postId"));
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://bbs-api.mihoyo.com/post/wapi/getPostFull?read=1&gids=2&post_id=" + postId;

        Map<String, String> query = new HashMap<>();
        query.put("read", "1");
        query.put("gids", "2");
        query.put("post_id", postId);

        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", "zh-cn");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Host", "api-takumi.mihoyo.com");
        httpGet.setHeader("x-rpc-app_version", "2.11.0");
        httpGet.setHeader("x-rpc-client_type", "4");
//        headers.put("Cookie", cookie);
        httpGet.setHeader("Referer", "https://bbs.mihoyo.com/");
        httpGet.setHeader("DS", MyUtils.GetDS(query, ""));

        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity);
        return R.ok().put("data", str);
    }
}
