package com.example.demo.controller

import com.example.demo.entity.Content
import com.example.demo.repository.ContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("unused")
@RestController
@RequestMapping("/api/content")
class ContentController {
    @Autowired
    private lateinit var contentRepository: ContentRepository

    @get:GetMapping
    val allContent: List<Content>
        get() = contentRepository.findAll()

    @GetMapping("/{id}")
    fun getContentById(@PathVariable id: Long): ResponseEntity<Content> {
        return contentRepository.findById(id).map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createContent(@RequestBody content: Content): Content {
        return contentRepository.save(content)
    }

    @PutMapping("/{id}")
    fun updateContent(@PathVariable id: Long, @RequestBody contentDetails: Content): ResponseEntity<Content> {
        return contentRepository.findById(id).map { content ->
            val updatedContent = content.apply {
                title = contentDetails.title
                body = contentDetails.body
                author = contentDetails.author
                type = contentDetails.type
            }
            ResponseEntity.ok(contentRepository.save(updatedContent))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteContent(@PathVariable id: Long): ResponseEntity<Void> {
        return contentRepository.findById(id).map { content ->
            contentRepository.delete(content)
            ResponseEntity.noContent().build<Void>()
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/search")
    fun searchContent(@RequestParam("query") query: String): List<Content> {
        return contentRepository.findAll().filter { it.title?.contains(query, ignoreCase = true) == true }
    }
}
