package com.estore.domain.user;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="USER_GROUPS")
public class UserGroup 
{
	@Id
	//@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private Long groupId;
	
	@Column(name="NAME")
	private String groupName;
	
	@Column(name="DESCRIPTION")
	private String desc;
	
	UserGroup()
	{
		
	}
	/*//@JoinColumn(name = "ID", referencedColumnName = "GROUP_ID")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="group")
	private List<User> users;*/

	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long id) {
		this.groupId = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDesc() {
		return desc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGroup other = (UserGroup) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	/*public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}*/
	
	
}
