package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.ZycJobRunning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 自定义任务执行实例
 */
@Mapper
public interface ZycJobRunningDao {
    public int save(ZycJobRunning jobRunning);
    public ZycJobRunning loadById(@Param("id") int id);
    public int update(ZycJobRunning jobRunning);
    public int delete(@Param("id") long id);

    /**
     * 根据任务执行id与任务Id查询其父任务执行失败或者正在执行的个数
     * @param job_excute_id 任务执行id
     * @param job_id 任务id
     * @return
     */
    public int parentJobExcuteFailOrRunnnigNum(@Param("job_excute_id") long job_excute_id,
                                     @Param("job_id") long job_id);
}
