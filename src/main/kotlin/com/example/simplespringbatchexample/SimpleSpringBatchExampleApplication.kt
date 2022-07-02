package com.example.simplespringbatchexample

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleSpringBatchExampleApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpringBatchExampleApplication>(*args)
}
