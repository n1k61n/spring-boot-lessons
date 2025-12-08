package com.example.demo.controller

import com.example.demo.entity.Content
import com.example.demo.entity.User
import com.example.demo.repository.AnalyticRepository
import com.example.demo.repository.ContentRepository
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.util.Optional

@Suppress("unused")
@Controller
class WebController {
    @Autowired
    private lateinit var contentRepository: ContentRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var analyticRepository: AnalyticRepository

    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/dashboard")
    fun dashboard(): String {
        return "dashboard"
    }

    @GetMapping("/content")
    fun contentManagement(model: Model): String {
        model.addAttribute("contentList", contentRepository.findAll())
        return "content"
    }

    @GetMapping("/content/new")
    fun newContentForm(model: Model): String {
        model.addAttribute("content", Content())
        return "content-form"
    }

    @PostMapping("/content/new")
    fun saveNewContent(@ModelAttribute content: Content): String {
        contentRepository.save(content)
        return "redirect:/content"
    }

    @GetMapping("/content/edit/{id}")
    fun editContentForm(@PathVariable id: Long, model: Model): String {
        val content: Optional<Content> = contentRepository.findById(id)
        if (content.isPresent) {
            model.addAttribute("content", content.get())
        }
        return "content-form"
    }

    @PostMapping("/content/edit/{id}")
    fun updateContent(@PathVariable id: Long, @ModelAttribute content: Content): String {
        content.id = id
        contentRepository.save(content)
        return "redirect:/content"
    }

    @PostMapping("/content/delete/{id}")
    fun deleteContent(@PathVariable id: Long): String {
        contentRepository.deleteById(id)
        return "redirect:/content"
    }

    @GetMapping("/users")
    fun userManagement(model: Model): String {
        model.addAttribute("userList", userRepository.findAll())
        return "users"
    }

    @GetMapping("/users/new")
    fun newUserForm(model: Model): String {
        model.addAttribute("user", User())
        return "user-form"
    }

    @PostMapping("/users/new")
    fun saveNewUser(@ModelAttribute user: User): String {
        user.roles = "ROLE_USER"
        userRepository.save(user)
        return "redirect:/users"
    }

    @PostMapping("/users/delete/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        userRepository.deleteById(id)
        return "redirect:/users"
    }

    @GetMapping("/analytics")
    fun analytics(model: Model): String {
        model.addAttribute("analyticList", analyticRepository.findAll())
        return "analytics"
    }
}
