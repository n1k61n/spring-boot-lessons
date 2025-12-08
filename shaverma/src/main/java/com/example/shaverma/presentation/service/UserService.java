package com.example.shaverma.presentation.service;

import com.example.shaverma.domain.interractor.UserInterractor;
import com.example.shaverma.domain.repo.UserRepo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserService extends UserInterractor implements ApplicationContextAware {

    private ApplicationContext ctx;
    private UserRepo repo;

    public UserService(UserRepo userRepo) {
        super(null);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
        this.repo = ctx.getBean(UserRepo.class);
        super.setRepo(repo);
    }
}
