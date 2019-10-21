package com.xxl.job.admin.core.trigger;

import com.xxl.job.admin.core.util.I18nUtil;

/**
 * 任务触发类型
 */
public enum TriggerTypeEnum {

    MANUAL(I18nUtil.getString("jobconf_trigger_type_manual")),//手动触发
    CRON(I18nUtil.getString("jobconf_trigger_type_cron")),//定时Cron触发
    RETRY(I18nUtil.getString("jobconf_trigger_type_retry")),//失败重试触发
    PARENT(I18nUtil.getString("jobconf_trigger_type_parent")),//父任务触发
    API(I18nUtil.getString("jobconf_trigger_type_api"));//API触发

    private TriggerTypeEnum(String title){
        this.title = title;
    }
    private String title;
    public String getTitle() {
        return title;
    }

}
