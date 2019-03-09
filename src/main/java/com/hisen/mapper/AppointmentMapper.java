package com.hisen.mapper;

import com.hisen.entity.Appointment;
import com.hisen.entity.AppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int countByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int deleteByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int insert(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int insertSelective(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    List<Appointment> selectByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    Appointment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int updateByPrimaryKeySelective(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    int updateByPrimaryKey(Appointment record);
}