package com.spring.start.z_startup.entity;

public enum UserStatusEnum {

	INACTIVE(1), ACTIVE(2);

	private int id;

	private UserStatusEnum(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public static UserStatusEnum enumById(int id) {
		UserStatusEnum[] values = UserStatusEnum.values();
		for (UserStatusEnum status : values) {
			if (status.getId() == id)
				return status;
		}
		return null;

	}
}
