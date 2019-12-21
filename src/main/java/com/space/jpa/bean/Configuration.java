package com.space.jpa.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "pub_configuration",uniqueConstraints=
@UniqueConstraint(columnNames={"key2", "type"})
)
public class Configuration implements Serializable {

	private static final long serialVersionUID = 1170459379082435536L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "用户名不能为空")
	@Column(name = "key2")
	private String key;
	
	@Column(name = "value2")
	private String value;
	
	/**
	 * 配置所属列别， 可以为空
	 */
	@Column(name = "type")
	private String type="default";
	
	@Column(name = "create_time",nullable=true)
	private Timestamp createTime;

	@Column(name = "update_time",nullable=true)
	private Timestamp updateTime;
	
	@Column(name = "type_name")
	private String typeName;

	@Column(name = "description")
	private String description;

	@Column(name = "data_type")
	private String dataType;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
