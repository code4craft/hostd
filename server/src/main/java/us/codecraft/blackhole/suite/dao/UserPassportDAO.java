package us.codecraft.blackhole.suite.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import us.codecraft.blackhole.suite.model.UserPassport;

/**
 * @author
 * @date 2012-3-29
 */
public interface UserPassportDAO {

    @Select("select * from User_Passport where username=#{username}")
    public UserPassport getByUsername(@Param("username") String username);

    @Select("select * from User_Passport where ticket=#{ticket}")
    public UserPassport getByTicket(@Param("ticket") String ticket);

    @Insert("insert into User_Passport (`username`,`passwordSalt`,`salt`,`ticket`) values"+
            " (#{username},#{passwordSalt},#{salt},#{ticket})")
    public int insert(UserPassport userPassport);

    @Update("update User_Passport set `username`=#{username},`passwordSalt`=#{passwordSalt},"+
            "`salt`=#{salt},`ticket`=#{ticket} where `id`=#{id}")
    public int update(UserPassport userPassport);

}
