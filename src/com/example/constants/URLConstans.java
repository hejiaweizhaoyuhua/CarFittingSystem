package com.example.constants;

public class URLConstans {
	public static String BASE_URL = "http://39.106.37.84/";
	
	/**
	 * �ӿ�1����ȡ�������Ϣ
	 * GET��ʽ �޲���
	 */
	public static String URL_CAR_TYPE = BASE_URL + "api/type.php";
	
	/**
	 * �ӿ�2�����ݳ�code�͵�����ȡ��Ӧ�����ĳ��б�����
	 * GET��ʽ 
	 * ���� car_code��area �ɽӿ�1��ȡ
	 */
	public static String URL_CAR_CODE_AREA = BASE_URL + "api/type.php";
	
	/**
	 * �ӿ�3������type_id��ȡ��Ӧ������model����
	 * GET��ʽ 
	 * ���� type_id �ɽӿ�2��ȡ
	 */
	public static String URL_MODEL = BASE_URL + "api/model.php";
	
	/**
	 * �ӿ�4������model_id��ȡgroup����
	 * GET��ʽ 
	 * ���� model_id �ɽӿ�3��ȡ
	 */
	public static String URL_GROUP = BASE_URL + "api/group.php";
	
	/**
	 * �ӿ�5������group_id��ȡsub_group����
	 * GET��ʽ 
	 * ���� group_id �ɽӿ�4��ȡ
	 */
	public static String URL_SGROUP = BASE_URL + "api/sgroup.php";
	
	/**
	 * �ӿ�6������sgroup_id��ȡparts����
	 * GET��ʽ 
	 * ���� sgroup_id �ɽӿ�5��ȡ
	 */
	public static String URL_PARTS = BASE_URL + "api/parts.php";
	
	/**
	 * ��¼�ӿ�
	 * POST��ʽ
	 * ���� username password
	 */
	public static String URL_LOGIN = BASE_URL + "api/login.php";
}
