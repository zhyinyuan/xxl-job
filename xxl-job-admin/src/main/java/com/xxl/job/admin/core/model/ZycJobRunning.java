package com.xxl.job.admin.core.model;

import java.util.Date;

/**
 * 任务执行实例
 */
public class ZycJobRunning {
    private int id;//主键
    private int job_excute_id;//任务执行实例Id
    private int job_id;//任务ID
    private int job_child_id;//子任务id
    private int excute_result_state;//执行结果状态 0：成功，1：失败 2：执行中
    private String error_msg;//错误信息
    private Date create_date;//创建时间
    private Date finish_date;//创建时间

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_excute_id() {
        return job_excute_id;
    }

    public void setJob_excute_id(int job_excute_id) {
        this.job_excute_id = job_excute_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_child_id() {
        return job_child_id;
    }

    public void setJob_child_id(int job_child_id) {
        this.job_child_id = job_child_id;
    }

    public int getExcute_result_state() {
        return excute_result_state;
    }

    public void setExcute_result_state(int excute_result_state) {
        this.excute_result_state = excute_result_state;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
