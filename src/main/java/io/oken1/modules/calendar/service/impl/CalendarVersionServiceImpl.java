package io.oken1.modules.calendar.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarVersionDao;
import io.oken1.modules.calendar.entity.CalendarVersionEntity;
import io.oken1.modules.calendar.service.CalendarVersionService;


@Service("calendarVersionService")
public class CalendarVersionServiceImpl extends ServiceImpl<CalendarVersionDao, CalendarVersionEntity> implements CalendarVersionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarVersionEntity> page = this.page(
                new Query<CalendarVersionEntity>().getPage(params),
                new QueryWrapper<CalendarVersionEntity>()
        );

        return new PageUtils(page);
    }

}