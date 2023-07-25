package com.example.redis.repository

import com.example.redis.common.Log
import com.example.redis.model.NoticeDto
import org.springframework.stereotype.Service

@Service
class NoticeRepository {

    companion object: Log

    private val noticeList = mutableListOf<NoticeDto>()

    fun getNotice(id: Long?): NoticeDto? {
        log.info("repository get notice method call : {}", id)
        return noticeList.filter { it -> it.id == id }.firstOrNull()
    }

    fun addNotice(notice: NoticeDto?): NoticeDto? {
        log.info("repository add notice method call : {}", notice)

        return notice?.apply {
            this.id = (noticeList.size + 1).toLong()
        }?.apply {
            noticeList.add(this)
        }?.also {
            log.info("save dto : {}", it)
        }

    }

}