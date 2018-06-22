package com.lrn.sb.restservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrn.sb.restservices.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
