package com.hisen.entity;

public class UserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_number
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    private String userNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_number
     *
     * @return the value of user.user_number
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_number
     *
     * @param userNumber the value for user.user_number
     *
     * @mbggenerated Sat Mar 09 14:54:40 CST 2019
     */
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }
}