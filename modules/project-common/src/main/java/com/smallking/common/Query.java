package com.smallking.common;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class Query<T> {

    private long page = 1;

    private long limit = 20;

    private String params;

    private String sortItem;

    private boolean asc;

    public Query() {
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSortItem() {
        return sortItem;
    }

    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public Object getBean(Class clazz) {
        return JSONUtil.toBean(params, clazz);
    }

    public Page getPageable() {
        Page<T> pageable = new Page<>();
        pageable.setCurrent(page);
        pageable.setSize(limit);
        if (StringUtils.isNotEmpty(sortItem)) {
            List<OrderItem> orderItems = new ArrayList<>();
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(sortItem);
            orderItem.setAsc(asc);
            orderItems.add(orderItem);
            pageable.setOrders(orderItems);
        }
        return pageable;
    }
}
