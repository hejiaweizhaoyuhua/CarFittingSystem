package com.example.constants;

public class URLConstans {
	public static String BASE_URL = "http://39.106.37.84/";
	
	/**
	 * 接口1、获取大分类信息
	 * GET方式 无参数
	 */
	public static String URL_CAR_TYPE = BASE_URL + "api/type.php";
	
	/**
	 * 接口2、根据车code和地区获取对应地区的车列表数据
	 * GET方式 
	 * 参数 car_code、area 由接口1获取
	 */
	public static String URL_CAR_CODE_AREA = BASE_URL + "api/type.php";
	
	/**
	 * 接口3、根据type_id获取对应地区的model数据
	 * GET方式 
	 * 参数 type_id 由接口2获取
	 */
	public static String URL_MODEL = BASE_URL + "api/model.php";
	
	/**
	 * 接口4、根据model_id获取group数据
	 * GET方式 
	 * 参数 model_id 由接口3获取
	 */
	public static String URL_GROUP = BASE_URL + "api/group.php";
	
	/**
	 * 接口5、根据group_id获取sub_group数据
	 * GET方式 
	 * 参数 group_id 由接口4获取
	 */
	public static String URL_SGROUP = BASE_URL + "api/sgroup.php";
	
	/**
	 * 接口6、根据sgroup_id获取parts数据
	 * GET方式 
	 * 参数 sgroup_id 由接口5获取
	 */
	public static String URL_PARTS = BASE_URL + "api/parts.php";
	
	/**
	 * 登录接口
	 * POST方式
	 * 参数 username password
	 */
	public static String URL_LOGIN = BASE_URL + "api/login.php";
}
