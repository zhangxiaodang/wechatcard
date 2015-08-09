package cn.com.weixin.api.util;

/**
 * 微信应用常量类.
 */
public class WeixinMsgConstValue {

	/** 获取token URL. */
	public static final String URL_GET_TOKEN = "getTokenUrl";

	/** 发送客服消息URL. */
	public static final String URL_SEND_MESSAGE = "sendMsgUrl";

	/** 创建二维码ticket URL. */
	public static final String URL_GET_TICKET = "getTicketUrl";

	/** 通过ticket换取二维码URL. */
	public static final String URL_GET_QRCODE = "getQRCodeUrl";

	/** 通过提交表单域进行上传图片URL. */
	public static final String URL_POST_PICTURE = "uploadPicture";

	/** 获取微信用户信息接URL. */
	public static final String URL_GET_USERINFO = "getUserInfoURL";

	/** 获取关注用户列表的URL. */
	public static final String URL_GET_USERINFOLIST = "getUserListURL";

	/** 通过code换取网页授权access_token. */
	public static final String URL_GET_OAUTH = "getOAuthAccessTokenUrl";

	/** 发送客服消息. */
	public static final String URL_SEND_MASSAGE = "sendToUserMessageURL";

	/** 通过mediaId获取上传的图片信息 */
	public static final String URL_DOWNLOAD_PICTURE = "downloadPictureURL";

	/** 创建菜单. */
	public static final String URL_CREATE_MENU = "createMenuURL";

	/** 获取菜单. */
	public static final String URL_GET_MENU = "getMenuURL";

	/** 删除菜单. */
	public static final String URL_DELETE_MENU = "deleteMenuURL";

	/** 空值. */
	public static final String EMPTY = "";

	/** 文件不存在. */
	public static final String MSG_FILE = "文件不存在";

	/** 时间Format格式. */
	public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd HH:mm:ss";

	/** 单引号. */
	public static final String SYMBOL_QUOTE = "'";

	/** 双引号. */
	public static final String SYMBOL_QUOTES = "\"";

	/** 消息加密标识. */
	public static final String ENCODING = "encoding";

	/** 消息加解密密钥. */
	public static final String ENCODING_AES_KEY = "encodingaeskey";
}
