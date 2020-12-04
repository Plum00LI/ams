package ams.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ams.entity.User;

@Mapper
@Repository
public interface ILoginDao {

	User login(User user);

}
