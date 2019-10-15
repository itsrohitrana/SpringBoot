package com.spring.start.z_startup.configuration;

import java.util.Locale;

public class Constants {

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "kalbos123";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_AUTH = "Authorization";
	public static final String HEADER_USER_ID = "UserId";

	public static final String BASIC_TOKEN_PREFIX = "Basic ";
	public static final String COLLON_PREFIX = ":";

	// mail constants
	public static final String FROM_MAIL = "from";
	public static final String To_MAIL = "to";
	public static final String SUBJECT_MAIL = "subject";
	public static final String HTML_MAIL = "html";
	public static final String TEXT_MAIL = "text";

	public static final String FACEBOOK_BASE_URL = "https://graph.facebook.com/v3.0/";

	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String lower = upper.toLowerCase(Locale.ROOT);

	public static final String digits = "0123456789";

	public static final String alphanum = upper + lower + digits;

	public static final String TWITTER_EXCEPTION_CODE = "187";

	public static final String TWITTER_CLOUD_FILE = "profileIdsFile5.txt";

	public static final String COMMA_SEPARATOR = ",";
	public static final Integer THREAD_CORE_POOL_SIZE = 50;
	public static final Integer THREAD_MAX_POOL_SIZE = 100;
	public static final Integer THREAD_QUEUE_POOL_SIZE = 100;
	
	public static final String ALGORITHM = "HmacSHA1";
	
	public static final String TWITTER_FILE_NAME = "twitter.txt";
	
	public static final String TWITTER_FOLDER_NAME = "twitter";
	
	public static final String KALBOS_RESOURCE_SAVE_MEDIA_BY_URL = "https://app.kalbos.io/KalbosResources/file/saveMediaByUrl";
	public static final String KALBOS_RESOURCE_SAVE_MEDIA_BY_FILES = "https://app.kalbos.io/KalbosResources/file/saveMediaByFiles";
	public static final String KALBOS_RESOURCE_DELETE_MEDIA_BY_URL = "https://app.kalbos.io/KalbosResources/file/deleteMedia";
	
	
}
