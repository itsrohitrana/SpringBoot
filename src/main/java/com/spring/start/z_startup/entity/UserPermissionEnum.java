package com.spring.start.z_startup.entity;

public enum UserPermissionEnum {

	IS_DASHBOARD(1),
	IS_PUBLISHING(2);
	
	private int id;
	private UserPermissionEnum(int id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public static UserPermissionEnum enumById(int id) {
		UserPermissionEnum[] values = UserPermissionEnum.values();
		for (UserPermissionEnum status : values) {
			if (status.getId() == id)
				return status;
		}
		return null;

	}
}
