package com.xxl.job.executor.service.jobhandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * 命令行任务
 *
 * @author xuxueli 2018-09-16 03:48:34
 */
@JobHandler(value = "commandJobHandler")
@Component
public class CommandJobHandler extends IJobHandler {
    /**
     * shell 参数格式
     * 类型：json
     * 例如：
     * {'msgType':'shell',
     * 'method':'/home/edb/zyy/test.sh',
     * 'params':[
     * {'param':'first'},
     * {'param':'second'},
     * {'param':'third'}]}
     *
     * shell 脚本
     * echo "First param $1"
     * echo "First param $2"
     * echo "First param $3"
     */
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("执行参数："+param+"======================");
        //获取参数
        JSONObject paramJson = JSONObject.parseObject(param);
        String method = paramJson.getString("method");//shell 执行文件
        JSONArray params = paramJson.getJSONArray("params");//参数个数
        TimeUnit.SECONDS.sleep(2);
        //拼装命令
        StringBuffer command = new StringBuffer("sh ");
        command.append(method);
        JSONObject tmpJson = null;
        for (int i = 0; i < params.size(); i++) {
            tmpJson = params.getJSONObject(i);
            command.append(" "+tmpJson.getString("param"));
        }
        System.out.println("执行命令："+command.toString()+"======================");
        Process process = Runtime.getRuntime().exec(command.toString());
        return IJobHandler.SUCCESS;

    }


    /**
     * 原始脚本执行样例
     * @param param
     * @return
     * @throws Exception
     */
    public ReturnT<String> executeOriginal(String param) throws Exception {
        String command = param;
        int exitValue = -1;

        BufferedReader bufferedReader = null;
        try {
            // command process
            Process process = Runtime.getRuntime().exec(command);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            // command log
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                XxlJobLogger.log(line);
            }

            // command exit
            process.waitFor();
            exitValue = process.exitValue();
        } catch (Exception e) {
            XxlJobLogger.log(e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        if (exitValue == 0) {
            return IJobHandler.SUCCESS;
        } else {
            return new ReturnT<String>(IJobHandler.FAIL.getCode(), "command exit value("+exitValue+") is failed");
        }
    }

}
