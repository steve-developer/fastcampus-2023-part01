package com.example.redis.controller

import com.example.redis.common.Log
import com.example.redis.model.NoticeDto
import com.example.redis.service.NoticeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notice")
class NoticeApiController(
    private val noticeService: NoticeService
) {
    companion object: Log

    @GetMapping("/get-notice")
    fun getNotice(
        @RequestParam id: Long?
    ): NoticeDto? {
        log.info("notice controller get notice : {}", id)
        val response = noticeService.getNotice(id)
        log.info("notice controller get notice response : {}", response)
        return response
    }

    @GetMapping("/add-notice")
    fun addNotice(
        @RequestParam notice: String?
    ): NoticeDto? {
        log.info("notice controller add notice : {}", notice)
        val response = noticeService.addNotice(NoticeDto(notice = notice))
        log.info("notice controller add notice response : {}", response)
        return response
    }

}