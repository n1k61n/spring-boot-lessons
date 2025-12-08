package com.example.demo.controller

import com.example.demo.entity.Analytic
import com.example.demo.repository.AnalyticRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/analytics")
class AnalyticController {
    @Autowired
    private val analyticRepository: AnalyticRepository? = null

    @get:GetMapping
    val allAnalytics: MutableList<Analytic?>
        get() = analyticRepository!!.findAll()
}
