# 项目所用技术

- 使用spring boot使优化架构
- 使用spring mvc作为控制层框架
- 使用tk-mapper，提高效率
- 使用pagehelper分页
- 使用dubbo作为rpc框架
- 使用shiro作为安全控制框架


# 项目划分

| 模块名 | 说明 | 端口 |
| ------ | ------ | ------ |
| common-document | 公共文档 | 无 |
| common-util | 公共工具类 | 无 |
| common-core | 公共核心业务，比如service层的抽象 | 无 |
| common-config | 公共配置 | 无 |
| service-admin-api | 管理模块接口 | 无 |
| service-admin | 管理模块 | 10001 |
| service-business-api | 核心业务模块接口 | 无 |
| service-business | 核心业务模块 | 10002 |
| service-delivery-api | 外送模块接口 | 无 |
| service-delivery | 外送模块 | 10003 |
| service-font-user-api | 平台用户模块接口 | 无 |
| service-font-user | 平台用户模块 | 10004 |
| service-reporter-api | 报表模块接口 | 无 |
| service-reporter | 报表模块 | 10005 |
| web-all-admin | 后台管理web接口模块 | 8800 |
| web-delivery-admin | 外送web接口模块 | 8801 |
| web-shop-admin | 店铺web接口模块 | 8802 |
| web-portal | 平台用户web接口模块 | 8803 |

#关于server层异常处理

>1.server层不抛出异常，增删改接口统一返回   ResponseCode

>>@Service<br/>
>>public ResponseCode add(Object o) { <br/>
>>>if(fales){<br/>
return ResponseCode.OTHER_ERROR;<br/>
}<br/>
return ResponseCode.SUCCESS;<br/>
}

>2.controller层判断操作是否成功，失败统一抛出 BizException(ResponseCode)异常

>>@Controller<br/>
 public ResponseUtils add(Object o) {<br/>
>>  ResponseCode responseCode = addService.add(new Object);<br/>
    if (!ResponseCode.SUCCESS.equals(responseCode)) {<br/>
    throw new BizException(responseCode);<br/>
    }<br/>
    return ResponseUtils.setSuccess(responseCode);<br/>
    }

>3.controller层判断参数是否为空可以使用Assert
>>Assert.hasText(username, "用户名不能为空");//返回
Assert.hasText(username);
