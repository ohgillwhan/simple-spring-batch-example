package com.example.simplespringbatchexample

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@EnableBatchProcessing
@Configuration
class BatchConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {

    @Bean
    fun exampleJob(step: Step): Job {
        return jobBuilderFactory["exampleJob"]
            .start(step)
            .build()
    }

    @Bean
    fun step(): Step {
        return stepBuilderFactory["step"]
            .tasklet { _: StepContribution, _: ChunkContext ->
                println("Step1")
                RepeatStatus.FINISHED
            }
            .build()
    }
}