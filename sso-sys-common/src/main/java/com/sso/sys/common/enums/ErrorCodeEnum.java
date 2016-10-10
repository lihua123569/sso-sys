package com.sso.sys.common.enums;

import com.liebao.lb7881.common.enums.IErrorCodeEnum;

/**
 * @author Administrator
 */
public enum ErrorCodeEnum implements IErrorCodeEnum {
    
    USER_SUB_ACCOUNT_OVER_LIMIT("8021", "子账号数量超出限制"),
	
	USER_SUB_ACCOUNT_REPEAT("8020", "此账户已存在，请重新添加"),
	
	USER_SUB_ACCOUNT_OR_PASSWORD_ERROR("8019", "用户名或密码错误"),
	
	USER_SUB_ACCOUNT_NOT_AVAILABLE("8018", "此账号不可用"),
    
    USER_SUB_ACCOUNT_NOT_EXIST("8017", "子账户不存在"),
    
    BALANCE_LACK("8016", "余额不足"),
    CONFIRM_FINANCE_FAIL("8015","确认财务流水失败"),
    
    CREATE_FINANCE_FAIL("8014","建立财务流水失败"),

    HAS_RETRY("8013", "已经重试"),

    STOCK_LACK("8012", "库存不足"),



    NOT_PERMISSION("8011", "没有操作权限"),

    DATA_UPDATE_ERROR("8010", "数据更新错误"),

    /**
     * 未登陆
     */
    LOGIN_ERROR("9996", "请先登录"),

    /**
     * 登陆失败
     */
    LOGIN_FAIL("8009", "登陆失败"),

    /**
     * 插入数据时校验错误
     */
    DATA_MATCH_ERROR("8007", "数据校验错误"),

    /**
     * 查询数据异常
     */
    DATA_NOT_FOUND("8008", "数据未找到"),

    /**
     * 插入数据时校验错误
     */
    DATA_INSERT_ERROR("8006", "新增数据错误"),

    /**
     * 权限查询失败
     */
    PERMISSION_QUERY_FAIL("8002", "权限查询失败"),

    /**
     * 查询无结果
     */
    QUERY_NO_RESULT("9997", "query no result"),

    /**
     * 参数非法
     */
    ILLEGAL_ARGUMENT("9998", "参数非法"),

    /**
     * 日期格式转换异常
     */
    DATE_PARSE_EXCEPTION("ERROR9997", "日期格式转换异常"),

    /**
     * 成功
     */
    SUCCESS("0000", "success"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR("9999", "当前网络忙，请稍后再试");

    /**
     * 响应码
     */
    private String responseCode;
    /**
     * 描述
     */
    private String responseMsg;

    /**
     * 私有构造函数
     *
     * @param responseCode
     * @param responseMsg
     */
    private ErrorCodeEnum(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }

    @Override
    public String getResponseMsg() {
        return responseMsg;
    }


}
