package com.imooc.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
//        testSimpleTrigger();
        testCronTrigger();
    }

    private static void testCronTrigger() throws SchedulerException, InterruptedException {
        Date startDate = new Date();
        Date endDate = new Date();
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        startDate.setTime(startDate.getTime() + 3000);
        endDate.setTime(endDate.getTime() + 6000);
        //创建一个JobDetail实例，将该实例与HelloJob class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
                .usingJobData("message","hello myJob1").usingJobData("FloatJobValue",3.14F).build();
        //创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，
        //1.2018年每日的10点15分执行一次(0 40 14 * * ? 2018)
        //2.每天的14和18点整每隔5秒执行一次(0/5 * 14,18 * * ?)
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")).build();
        //创建Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,cronTrigger);
        Thread.sleep(2000);
//        scheduler.standby();
//        scheduler.start();
        scheduler.shutdown(true);
//        scheduler.shutdown(false);
        System.out.println("scheduler is shut down?" + scheduler.isShutdown());

    }

    private static void testSimpleTrigger() throws SchedulerException {
        Date startDate = new Date();
        Date endDate = new Date();
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        startDate.setTime(startDate.getTime() + 3000);
        endDate.setTime(endDate.getTime() + 6000);
        //创建一个JobDetail实例，将该实例与HelloJob class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
                .usingJobData("message","hello myJob1").usingJobData("FloatJobValue",3.14F).build();
        //创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，直到永远
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
                .usingJobData("message","hello myTrigger1").usingJobData("DoubleTriggerValue",2.14D).startAt(startDate).endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(6)).build();
        //创建Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        scheduler.scheduleJob(jobDetail,simpleTrigger);
    }
}
