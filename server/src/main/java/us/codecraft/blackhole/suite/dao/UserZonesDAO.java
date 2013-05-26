package us.codecraft.blackhole.suite.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author
 * @date 2012-3-29
 */
public interface UserZonesDAO {

    @Update("update User_Passport set `zones`=#{zones} where `id`=#{userId}")
    public int updateZones(@Param("userId") int userId, @Param("zones") String zones);

    @Select("select zones from User_Passport where `id`=#{userId}")
    public String getZones(@Param("userId") int userId);

}
