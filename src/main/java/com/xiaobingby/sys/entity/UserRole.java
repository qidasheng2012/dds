package com.xiaobingby.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * user_role 用户角色关联表
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@TableName("user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id")
	private Long id;
    /**
     * 用户ID
     */
	private Long uid;
    /**
     * 角色ID
     */
	private Long rid;
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

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
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
		return "UserRole{" +
			"id=" + id +
			", uid=" + uid +
			", rid=" + rid +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			"}";
	}
}
