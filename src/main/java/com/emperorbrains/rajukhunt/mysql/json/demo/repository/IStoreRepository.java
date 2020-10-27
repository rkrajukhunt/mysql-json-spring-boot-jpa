package com.emperorbrains.rajukhunt.mysql.json.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.emperorbrains.rajukhunt.mysql.json.demo.entity.Store;

public interface IStoreRepository extends CrudRepository<Store, Integer>{

}
