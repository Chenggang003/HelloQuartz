package com.imooc.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    private String message;
    private Float FloatJobValue;
    private Double DoubleTriggerValue;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //执行具体的逻辑
        /*JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println(jobDetail.getKey().getName() + ":" + jobDetail.getKey().getGroup());
        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println(trigger.getKey().getName() + ":" + trigger.getKey().getGroup());*/

        /*JobDataMap jobDataMap = jobDetail.getJobDataMap();
        System.out.println(jobDataMap.getString("message"));
        System.out.println(jobDataMap.getFloat("FloatJobValue"));

        JobDataMap triggerJobDataMap = trigger.getJobDataMap();
        System.out.println(triggerJobDataMap.getString("message"));
        System.out.println(triggerJobDataMap.getDouble("DoubleTriggerValue"));*/

        /*JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println(mergedJobDataMap.getString("message"));
        System.out.println(mergedJobDataMap.getFloat("FloatJobValue"));
        System.out.println(mergedJobDataMap.getDouble("DoubleTriggerValue"));*/

        /*System.out.println(message);
        System.out.println(FloatJobValue);
        System.out.println(DoubleTriggerValue);*/

        /*JobKey jobKey = trigger.getJobKey();
        System.out.println(jobKey.getGroup());
        System.out.println(jobKey.getName());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trigger.getStartTime()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trigger.getEndTime()));*/
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");

    }












    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return DoubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        DoubleTriggerValue = doubleTriggerValue;
    }
}
