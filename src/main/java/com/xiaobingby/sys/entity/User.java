package com.xiaobingby.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * user 用户表
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id")
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 密码
     */
	private String password;
    /**
     * 盐
     */
	private String salt;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 0、禁用 1、正常
     */
	private Integer status;
	/**
	 * 创建时间
	 */
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	@TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username=" + username +
			", nickname=" + nickname +
			", password=" + password +
			", salt=" + salt +
			", email=" + email +
			", status=" + status +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			"}";
	}
}
