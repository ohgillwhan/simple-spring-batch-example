package com.example.simplespringbatchexample

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*


@EnableScheduling
@Component
@Profile("auto")
class BatchScheduler(
    private val jobLauncher: JobLauncher,
    private val exampleJob: Job
) {
    @Scheduled(cron = "* * * * * *")
    fun scheduleExampleJob() {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val parameterMap: Map<String, JobParameter> = mapOf("date" to JobParameter(format.format(Date())))

        val parameters = JobParameters(parameterMap)

        jobLauncher.run(exampleJob, parameters)
    }
}