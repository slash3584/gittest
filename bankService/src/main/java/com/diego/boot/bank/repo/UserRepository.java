package com.diego.boot.bank.repo;

import org.springframework.data.repository.CrudRepository;

import com.diego.boot.bank.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
