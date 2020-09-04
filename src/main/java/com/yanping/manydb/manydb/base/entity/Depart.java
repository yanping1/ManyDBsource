package com.yanping.manydb.manydb.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author Mr.AG
 * @email 463540703@qq.com
 * @version 2018-02-04 19:06:43
 */
@Table(name = "base_depart")
@Data
public class Depart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
	@GeneratedValue(generator = "UUID")
    private String id;
	
	    //组织名称
    @Column(name = "name")
    private String name;
	
	    //编码
    @Column(name = "code")
    private String code;
	
	    //路劲
    @Column(name = "parent_ids")
    private String parentIds;
	
	    //部门类型
    @Column(name = "type")
    private String type;
    
    private Integer orderNum;


	//创建人
	@Column(name = "crt_user_name")
	private String crtUserName;

	//创建人ID
	@Column(name = "crt_user_id")
	private String crtUserId;

	//创建时间
	@Column(name = "crt_time")
	private Date crtTime;

	//最后更新人
	@Column(name = "upd_user_name")
	private String updUserName;

	//最后更新人ID
	@Column(name = "upd_user_id")
	private String updUserId;

	//最后更新时间
	@Column(name = "upd_time")
	private Date updTime;

	//
	@Column(name = "parent_id")
	private String parentId;

	@Column(name = "tenant_id")
	private String tenantId;
	


}
