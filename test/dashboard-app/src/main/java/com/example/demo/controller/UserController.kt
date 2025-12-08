package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.function.Function

@RestController
@RequestMapping("/api/users")
class UserController {
    @Autowired
    private val userRepository: UserRepository? = null

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User?> {
        user.roles = "ROLE_USER" // По умолчанию новый пользователь получает роль USER
        return ResponseEntity.ok<User?>(userRepository!!.save<User?>(user))
    }

    @get:GetMapping
    val allUsers: MutableList<User?>
        get() = userRepository!!.findAll()

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<*> {
        return userRepository!!.findById(id)
            .map<ResponseEntity<Any?>>(Function { user: User? ->
                userRepository.delete(user)
                ResponseEntity.ok().build<Any?>()
            })
            .orElse(ResponseEntity.notFound().build<Any?>())
    }
}
