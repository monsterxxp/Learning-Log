package com.smallking.common;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query<T> {

    private long pageNo = 1;

    private long pageSize = 20;

    private String params;

    private String sortField;

    private String sortOrder;

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public Query() {
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Object getBean(Class clazz) {
        return JSONUtil.toBean(params, clazz);
    }

    public Page getPageable() {
        Page<T> pageable = new Page<>();
        pageable.setCurrent(pageNo);
        pageable.setSize(pageSize);
        if (StringUtils.isNotEmpty(sortField)) {
            List<OrderItem> orderItems = new ArrayList<>();
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(humpToLine(sortField));
            if ("ascend".equals(sortOrder)) {
                orderItem.setAsc(true);
            } else {
                orderItem.setAsc(false);
            }
            orderItems.add(orderItem);
            pageable.setOrders(orderItems);
        }
        return pageable;
    }

    /** 驼峰转下划线*/
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
