package io.oken1.modules.calendar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.oken1.modules.calendar.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarEventDao;
import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.service.CalendarEventService;


@Service("calendarEventService")
public class CalendarEventServiceImpl extends ServiceImpl<CalendarEventDao, CalendarEventEntity> implements CalendarEventService {

    @Autowired
    private CalendarEventDao calendarEventDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventEntity> page = this.page(
                new Query<CalendarEventEntity>().getPage(params),
                new QueryWrapper<CalendarEventEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getPageList(Map<String, Object> params) {
        Page<EventModel> page = new Query<EventModel>().getMyPage(params);
        // 注意：一定要手动关闭 SQL 优化，不然查询总数的时候只会查询主表
        page.setOptimizeCountSql(false);
        QueryWrapper<EventModel> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("e.game_id", "0a49b2bda7f211ef80c47c8ae194797e");

        IPage<EventModel> page1 = calendarEventDao.getPageEventList(page, queryWrapper);

        System.out.println("总记录数：" + page1.getTotal());
        System.out.println("总共多少页：" + page1.getPages());
        System.out.println("当前页码：" + page1.getCurrent());
        System.out.println("查询数据：" + page1.getRecords());

//        IPage<EventModel> page = this.page(
//                new Query<EventModel>().getPage(params),
//                new QueryWrapper<EventModel>()
//        );

        return new PageUtils(page);
    }

    @Override
    public List<EventModel> getByIds(String[] ids) {
        return calendarEventDao.getEventListByGameIds(ids);
    }
}