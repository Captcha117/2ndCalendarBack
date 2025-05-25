package io.oken1.modules.calendar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;
import io.oken1.modules.calendar.dao.CalendarCustomDao;
import io.oken1.modules.calendar.entity.CalendarCustomEntity;
import io.oken1.modules.calendar.service.CalendarCustomService;
import io.oken1.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("calendarCustomService")
public class CalendarCustomServiceImpl extends ServiceImpl<CalendarCustomDao, CalendarCustomEntity> implements CalendarCustomService {

    @Autowired
    CalendarCustomDao calendarCustomDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarCustomEntity> page = this.page(
                new Query<CalendarCustomEntity>().getPage(params),
                new QueryWrapper<CalendarCustomEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LinkedHashMap> getCustomList(Long userId) {
        return calendarCustomDao.getCustomList(userId);
    }

}