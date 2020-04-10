package com.smallking.dto;

import com.smallking.model.SysDept;

/**
* 描述：组织结构表DTO
* @author WangShaoXiong
* @date 2019/11/16
*/
public class SysDeptDTO extends SysDept{

    private String leaderName;

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
