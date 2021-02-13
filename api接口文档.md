# 课程助手 API 接口文档

## 1 API V1 接口说明

- 接口基准地址：`http://127.0.0.1:8686`
- 服务端已开启 CORS 跨域支持
- API 认证统一使用 Token 认证
- 需要授权的 API ，必须在 Headers 中提供 `token` 令牌
- 使用 HTTP Status Code 标识状态
- 数据返回格式统一使用 JSON

### 1.1 支持的请求方法

- GET（SELECT）：从服务器取出资源。
- POST（CREATE）：在服务器增删改资源

### 1.2 通用返回状态说明 

| *状态码* | *含义*                | *说明*               |
| -------- | --------------------- | -------------------- |
| 200      | OK                    | 请求成功             |
| 400      | BAD REQUEST           | 客户端请求的语法错误 |
| 500      | INTERNAL SERVER ERROR | 内部错误             |

### 1.3 token格式

token采用 JWT 格式

payload有两个附加部分

- id：已授权的id
- type：id的用户类型

<br>

## 2. 登录验证

### 用户登录

- 请求路径：login
- 请求方法：post
- 请求参数

| 参数名   | 参数说明                                    | 类型   | 备注     |
| -------- | ------------------------------------------- | ------ | -------- |
| username | 用户名                                      | string | 不能为空 |
| password | 密码                                        | string | 不能为空 |
| type     | 登录类型<br>1：管理员<br>2：教师<br>3：学生 | int    | 不能为空 |

- 响应参数（data）

| 参数名 | 参数说明    | 备注            |
| ------ | ----------- | --------------- |
| id     | 用户 ID     |                 |
| type   | 用户角色 ID |                 |
| token  | 令牌        | 基于 jwt 的令牌 |

- 响应数据

```json
{
    "code": 200,
    "msg": "登录成功",
    "data": {
        "id": "root",
        "type": 1,
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6InJvb3QifQ.3j7-CnhdSrRpwxFx9sewue3i4L0MPBltD2fwQF1jaVA"
    }
}
```

<br>

### 验证token

- 请求路径：authentication
- 请求方法：post
- 请求参数

| 参数名 | 参数说明                                    | 类型   | 备注     |
| ------ | ------------------------------------------- | ------ | -------- |
| token  | token                                       | string | 不能为空 |
| type   | 登录类型<br>1：管理员<br>2：教师<br>3：学生 | int    | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "验证成功"
}
```

<br>

## 3 教师

### 查询所有教师

- 请求路径：teacher/all
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| start  | 起始位置 | int  | 不能为空 |
| size   | 个数     | int  | 不能为空 |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| data   | 教师数组 |      |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "teacher_id": 888888888,
            "administrator_id": "root",
            "teacher_name": "张妍琰",
            "teacher_sex": 0,
            "teacher_avatar": "avatar",
            "teacher_phone": "13512345678",
            "teacher_email": "123@qq.com",
            "teacher_Status": 1
        }
    ]
}
```

