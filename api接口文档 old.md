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
| 300      | EMPTY_QUERY           | 查询结果为空         |
| 400      | BAD_REQUEST           | 客户端请求的语法错误 |
| 500      | INTERNAL_SERVER_ERROR | 服务器内部错误       |

### 1.3 token格式

token采用 JWT 格式

payload有两个附加部分

- id：已授权的id
- role：id的用户类型

前端获取token后，统一使用下面的key进行存储：

管理员token：`hncj_management_admin_token`

教师token：`hncj_management_teacher_token`

学生token：`hncj_management_student_token`

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
- 权限：管理员
- 请求参数

| 参数名    | 参数说明       | 类型   | 备注     |
| --------- | -------------- | ------ | -------- |
| page      | 页数           | int    | 不能为空 |
| size      | 个数           | int    | 不能为空 |
| condition | 根据id模糊查询 | string | 可以为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "total": 41,
        "teachers": [
            {
                "teacher_id": 1829171,
                "administrator_id": "root",
                "teacher_name": "茅个也",
                "teacher_sex": 0,
                "teacher_avatar": "avatar",
                "teacher_phone": "13541862228",
                "teacher_email": "315883908@hncj.com",
                "teacher_status": 1
            },
            {
                "teacher_id": 14096088,
                "administrator_id": "root",
                "teacher_name": "庞你国",
                "teacher_sex": 0,
                "teacher_avatar": "avatar",
                "teacher_phone": "13588479572",
                "teacher_email": "220966597@hncj.com",
                "teacher_status": 0
            }
        ]
    }
}
```

<br>

### 根据教师id查询教师

- 请求路径：teacher/selectbyid
- 请求方法：get
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型   | 备注     |
| ------ | -------- | ------ | -------- |
| id     | 教师id   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "teacher_id": "888888888",
        "administrator_id": "root",
        "teacher_name": "张妍琰",
        "teacher_sex": 0,
        "teacher_avatar": "avatar",
        "teacher_phone": "13512345678",
        "teacher_email": "123@qq.com",
        "teacher_status": 1
    }
}
```

<br>

### 添加教师

- 请求路径：teacher/insert
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名   | 参数说明          | 类型   | 备注     |
| -------- | ----------------- | ------ | -------- |
| id       | 教师id            | string | 不能为空 |
| admin_id | 管理员id          | string | 不能为空 |
| name     | 姓名              | string | 不能为空 |
| sex      | 性别  1：男 0：女 | int    | 默认为女 |
| phone    | 电话              | string | 默认为"" |
| email    | 邮箱              | string | 默认为"" |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功",
    "data": {
        "id": "666666667"
    }
}
```

<br>

### 重置教师

- 请求路径：teacher/reset
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注     |
| ------ | -------------- | ------ | -------- |
| id     | 被重置的教师id | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "重置成功"
}
```

<br>

### 删除教师

- 请求路径：teacher/delete
- 请求方法：post
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注     |
| ------ | -------------- | ------ | -------- |
| id     | 被删除的教师id | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 修改教师

- 请求路径：teacher/update
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注         |
| ------ | -------------- | ------ | ------------ |
| id     | 被修改的教师id | string | 不能为空     |
| phone  | 电话           | string | 不能全部为空 |
| email  | 邮箱           | string | 不能全部为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 修改教师状态

- 请求路径：teacher/status
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注             |
| ------ | -------------- | ------ | ---------------- |
| id     | 被修改的教师id | string | 不能为空         |
| status | 状态           | int    | 0：禁用，1：正常 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 修改密码

- 请求路径：teacher/changepwd
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注     |
| ------ | -------------- | ------ | -------- |
| id     | 被修改的教师id | string | 不能为空 |
| oldpwd | 旧密码         | string | 不能为空 |
| newpwd | 新密码         | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 注销

- 请求路径：teacher/cancel
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名   | 参数说明       | 类型   | 备注     |
| -------- | -------------- | ------ | -------- |
| id       | 被修改的教师id | string | 不能为空 |
| password | 密码           | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "注销成功"
}
```

<br>

## 4 学生

### 查询所有学生

- 请求路径：student/all
- 请求方法：get
- 权限：管理员
- 请求参数

| 参数名    | 参数说明       | 类型   | 备注     |
| --------- | -------------- | ------ | -------- |
| page      | 页数           | int    | 不能为空 |
| size      | 个数           | int    | 不能为空 |
| condition | 根据id模糊查询 | string | 可以为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "total": 41,
        "students": [
            {
                "student_id": "068307974",
                "administrator_id": "root",
                "student_name": "祝在生",
                "student_sex": 0,
                "student_avatar": "avatar",
                "student_phone": "13586213072",
                "student_email": "369591871@hncj.com",
                "student_status": 1
            },
            {
                "student_id": "069013628",
                "administrator_id": "root",
                "student_name": "臧要你",
                "student_sex": 1,
                "student_avatar": "avatar",
                "student_phone": "13576310912",
                "student_email": "528746772@hncj.com",
                "student_status": 1
            }
        ]
    }
}
```

### 根据学生id查询学生

- 请求路径：student/selectbyid
- 请求方法：get
- 权限：学生
- 请求参数

| 参数名 | 参数说明 | 类型   | 备注     |
| ------ | -------- | ------ | -------- |
| id     | 教师id   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "student_id": "081417137",
        "administrator_id": "root",
        "student_name": "吴硕",
        "student_sex": 1,
        "student_avatar": "avatar",
        "student_phone": "15139744921",
        "student_email": "1234@qq.com",
        "student_status": 1
    }
}
```

<br>

### 根据班级查询所有学生

- 请求路径：student/selectbyclassid
- 请求方法：get
- 权限：教师
- 请求参数

| 参数名   | 参数说明 | 类型 | 备注     |
| -------- | -------- | ---- | -------- |
| class_id | 班级id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "total": 1,
        "students": [
            {
                "student_id": "081417137",
                "administrator_id": "root",
                "student_name": "吴硕",
                "student_password": "670B14728AD9902AECBA32E22FA4F6BD",
                "student_sex": 1,
                "student_avatar": "avatar",
                "student_phone": "15139744921",
                "student_email": "1234@qq.com",
                "student_wx": "",
                "student_status": 1
            }
        ]
    }
}
```

<br>

### 添加学生

- 请求路径：student/insert
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名   | 参数说明          | 类型   | 备注     |
| -------- | ----------------- | ------ | -------- |
| id       | 学生id            | string | 不能为空 |
| admin_id | 管理员id          | string | 不能为空 |
| name     | 姓名              | string | 不能为空 |
| sex      | 性别  1：男 0：女 | int    | 默认为女 |
| phone    | 电话              | string | 默认为"" |
| email    | 邮箱              | string | 默认为"" |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功",
    "data": {
        "id": "111111111"
    }
}
```

<br>

### 重置学生

- 请求路径：student/reset
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注     |
| ------ | -------------- | ------ | -------- |
| id     | 被重置的学生id | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "重置成功"
}
```

<br>

### 删除学生

- 请求路径：student/delete
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注     |
| ------ | -------------- | ------ | -------- |
| id     | 被删除的学生id | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 修改学生

- 请求路径：student/update
- 请求方法：post
- 权限：学生
- 请求参数

| 参数名   | 参数说明       | 类型   | 备注         |
| -------- | -------------- | ------ | ------------ |
| id       | 被修改的学生id | string | 不能为空     |
| password | 新密码         | string | 不能全部为空 |
| avatar   | 新头像         | string | 不能全部为空 |
| phone    | 新电话         | string | 不能全部为空 |
| email    | 新邮箱         | string | 不能全部为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 修改学生状态

- 请求路径：student/status
- 请求方法：post
- 权限：管理员
- 请求参数

| 参数名 | 参数说明       | 类型   | 备注             |
| ------ | -------------- | ------ | ---------------- |
| id     | 被修改的学生id | string | 不能为空         |
| status | 状态           | int    | 0：禁用，1：正常 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

## 5 课程

### 根据教师id查询课程

- 请求路径：course/findbyteacherid
- 请求方法：get
- 权限：教师
- 请求参数

| 参数名 | 参数说明                                                     | 类型   | 备注     |
| ------ | ------------------------------------------------------------ | ------ | -------- |
| id     | 教师id                                                       | string | 不能为空 |
| page   | 页数                                                         | int    | 不能为空 |
| size   | 数量                                                         | int    | 不能为空 |
| status | 状态<br>1：正在进行<br>2：已结束<br>3：已删除<br>0或不传：所有课程 | int    | 可以为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "course_id": "1",
            "teacher_id": "888888888",
            "teacher_name": "张妍琰",
            "course_name": "测试课程01",
            "course_cover": "covver"
        }
    ]
}
```

<br>

### 根据学生id查询课程

- 请求路径：course/findbystudentid
- 请求方法：get
- 权限：学生
- 请求参数

| 参数名 | 参数说明                                                     | 类型   | 备注     |
| ------ | ------------------------------------------------------------ | ------ | -------- |
| id     | 教师id                                                       | string | 不能为空 |
| page   | 页数                                                         | int    | 不能为空 |
| size   | 数量                                                         | int    | 不能为空 |
| status | 状态<br>1：正在进行<br>2：已结束<br>3：已删除<br>0或不传：所有课程 | int    | 可以为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "course_id": "1",
            "teacher_id": "888888888",
            "teacher_name": "张妍琰",
            "course_name": "网站建设",
            "course_cover": "http://p.ananas.chaoxing.com/star3/240_130c/b7b9a80175b2d80938d72fcbfdabce24.jpg",
            "course_status": 1
        },
        {
            "course_id": "9",
            "teacher_id": "888888889",
            "teacher_name": "赵老师",
            "course_name": "程序设计基础",
            "course_cover": "https://p.ananas.chaoxing.com/star3/origin/f23a4b313e1aa0a7a840ab81aabc918f.jpg",
            "course_status": 1
        },
        {
            "course_id": "10",
            "teacher_id": "888888889",
            "teacher_name": "赵老师",
            "course_name": "计算机网络",
            "course_cover": "https://p.ananas.chaoxing.com/star3/origin/a597b7c95a3e72dbbdb21f17011ce85f.jpg",
            "course_status": 1
        }
    ]
}
```

<br>

### 根据课程id查询课程

- 请求路径：course/findbyid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型   | 备注     |
| ------ | -------- | ------ | -------- |
| id     | 课程id   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "course_id": "1",
        "teacher_id": "888888888",
        "teacher_name": "张妍琰",
        "course_name": "测试课程01",
        "course_cover": "http://p.ananas.chaoxing.com/star3/240_130c/b7b9a80175b2d80938d72fcbfdabce24.jpg"
    }
}
```

<br>

### 添加课程

- 请求路径：course/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名      | 参数说明   | 类型   | 备注     |
| ----------- | ---------- | ------ | -------- |
| teacher_id  | 教师id     | string | 不能为空 |
| name        | 课程名     | string | 不能为空 |
| cover       | 课程封面   | string | 不能为空 |
| week        | 周数       | int    | 不能为空 |
| odd_lesson  | 单周学时数 | int    | 不能为空 |
| even_lesson | 双周学时数 | int    | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 修改课程

- 请求路径：course/update
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名     | 参数说明 | 类型   | 备注               |
| ---------- | -------- | ------ | ------------------ |
| course_id  | 课程id   | int    | 不能为空           |
| teacher_id | 教师id   | string | 不能为空           |
| name       | 课程名   | string | 后面三个不能全为空 |
| cover      | 课程封面 | string | 后面三个不能全为空 |
| status     | 状态     | int    | 后面三个不能全为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 删除课程

- 请求路径：course/delete
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

## 6 班级

### 查询班级

- 请求路径：class/findbycourseid
- 请求方法：get
- 权限：教师
- 请求参数

| 参数名    | 参数说明 | 类型 | 备注     |
| --------- | -------- | ---- | -------- |
| course_id | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "class_id": 1,
            "course_id": 1,
            "class_name": "一班"
        },
        {
            "class_id": 2,
            "course_id": 1,
            "class_name": "二班"
        },
        {
            "class_id": 3,
            "course_id": 1,
            "class_name": "三班"
        }
    ]
}
```

<br>

### 根据班级id查询班级

- 请求路径：class/findbyclassid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名   | 参数说明 | 类型 | 备注     |
| -------- | -------- | ---- | -------- |
| class_id | 班级id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "class_id": 1,
        "course_id": 1,
        "class_name": "一班"
    }
}
```

<br>

### 查询班级的学生人数

- 请求路径：class/countbycourseid
- 请求方法：get
- 权限：教师
- 请求参数

| 参数名   | 参数说明 | 类型 | 备注     |
| -------- | -------- | ---- | -------- |
| class_id | 班级id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "count": 2
    }
}
```

<br>

### 创建班级

- 请求路径：class/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名    | 参数说明 | 类型   | 备注     |
| --------- | -------- | ------ | -------- |
| course_id | 课程id   | int    | 不能为空 |
| name      | 班级名称 | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 删除班级

- 请求路径：class/delete
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名   | 参数说明 | 类型 | 备注     |
| -------- | -------- | ---- | -------- |
| class_id | 班级id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 学生选课

- 请求路径：class/selection
- 请求方法：post
- 权限：学生
- 请求参数

| 参数名      | 参数说明   | 类型   | 备注     |
| ----------- | ---------- | ------ | -------- |
| student_id  | 学生id     | string | 不能为空 |
| invite_code | 课程邀请码 | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "选课成功"
}
```

<br>

### 教师给学生选课

- 请求路径：class/selectionbyteacher
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名     | 参数说明 | 类型   | 备注     |
| ---------- | -------- | ------ | -------- |
| student_id | 学生id   | string | 不能为空 |
| class_id   | 班级id   | int    | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "选课成功"
}
```

<br>

## 7 周

### 根据课程id查询所有周

- 请求路径：week/select
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_id": 1,
            "course_id": 1,
            "week_name": "第01周",
            "week_status": 1
        },
        {
            "week_id": 2,
            "course_id": 1,
            "week_name": "第02周",
            "week_status": 2
        },
        {
            "week_id": 3,
            "course_id": 1,
            "week_name": "第03周",
            "week_status": 3
        }
    ]
}
```

<br>

### 根据周id查询周

- 请求路径：week/selectbyid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周id     | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "week_id": 1,
        "course_id": 1,
        "week_name": "第01周",
        "week_status": 1
    }
}
```

<br>

### 添加周

- 请求路径：week/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型   | 备注     |
| ------ | -------- | ------ | -------- |
| id     | 课程id   | int    | 不能为空 |
| name   | 周名称   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

## 8 课

### 根据课程id查询周和课

- 请求路径：lesson/selectbycourseid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_id": 1,
            "week_name": "第01周",
            "lessons": [
                {
                    "lesson_id": 1,
                    "week_id": 1,
                    "lesson_name": "第01课",
                    "lesson_index": 1,
                    "lesson_type": 1,
                    "lesson_status": 1
                },
                {
                    "lesson_id": 2,
                    "week_id": 1,
                    "lesson_name": "第02课",
                    "lesson_index": 2,
                    "lesson_type": 2,
                    "lesson_status": 2
                }
            ]
        },
        {
            "week_id": 2,
            "week_name": "第02周",
            "lessons": [
                {
                    "lesson_id": 3,
                    "week_id": 2,
                    "lesson_name": "第03课",
                    "lesson_index": 3,
                    "lesson_type": 1,
                    "lesson_status": 2
                },
                {
                    "lesson_id": 4,
                    "week_id": 2,
                    "lesson_name": "第04课",
                    "lesson_index": 4,
                    "lesson_type": 1,
                    "lesson_status": 2
                }
            ]
        }
    ]
}
```

<br>

<br>

## 9 周任务

### 查询周任务

- 请求路径：weekmission/selectweek
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名    | 参数说明 | 类型 | 备注     |
| --------- | -------- | ---- | -------- |
| course_id | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "student_ok_num": 1,
        "student_total_num": 4,
        "week_published_num": 1,
        "week_total_num": 2,
        "weeks": [
            {
                "week_id": 1,
                "week_name": "第01周",
                "week_status": 1,
                "missions": [
                    {
                        "week_mission_id": 1,
                        "week_id": 1,
                        "week_name": "第01周",
                        "week_mission_name": "任务01",
                        "week_mission_content": "与现实生活一致：与现实生活的流程、\n逻辑保持一致，遵循用户习惯的语言和概念；",
                        "ok_num": 2,
                        "week_goals": [
                            {
                                "week_goal_id": 1,
                                "week_mission_id": 1,
                                "week_goal_title": "记忆目标",
                                "week_goal_content": "HTML、CSS、JavaScript"
                            },
                            {
                                "week_goal_id": 2,
                                "week_mission_id": 1,
                                "week_goal_title": "理解目标",
                                "week_goal_content": "JQuery等前端库"
                            }
                        ]
                    },
                    {
                        "week_mission_id": 2,
                        "week_id": 1,
                        "week_name": "第01周",
                        "week_mission_name": "任务02",
                        "week_mission_content": "2与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；\n在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等",
                        "ok_num": 1,
                        "week_goals": [
                            {
                                "week_goal_id": 10,
                                "week_mission_id": 2,
                                "week_goal_title": "测试目标",
                                "week_goal_content": "啦啦啦啦啦啦啦啦啦啦"
                            }
                        ]
                    }
                ]
            },
            {
                "week_id": 2,
                "week_name": "第02周",
                "week_status": 2,
                "missions": [
                    {
                        "week_mission_id": 3,
                        "week_id": 2,
                        "week_name": "第02周",
                        "week_mission_name": "任务01",
                        "week_mission_content": "与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；\n 在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等",
                        "ok_num": 0,
                        "week_goals": []
                    },
                    {
                        "week_mission_id": 4,
                        "week_id": 2,
                        "week_name": "第02周",
                        "week_mission_name": "任务02",
                        "week_mission_content": "与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；\n 在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等",
                        "ok_num": 0,
                        "week_goals": []
                    }
                ]
            }
        ]
    }
}
```

<br>







### 根据周id查询周任务

- 请求路径：weekmission/selectbyweekid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周id     | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_mission_id": 1,
            "week_mission_name": "任务01",
            "week_mission_type": 1,
            "week_mission_status": 1,
            "teacher_name": "张妍琰",
            "views": 2
        },
        {
            "week_mission_id": 2,
            "week_mission_name": "任务02",
            "week_mission_type": 2,
            "week_mission_status": 2,
            "teacher_name": "张妍琰",
            "views": 0
        }
    ]
}
```

<br>

### 根据周任务id查询周任务

- 请求路径：weekmission/selectbymissionid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周任务id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "week_mission_id": 1,
        "week_id": 1,
        "week_name": "第01周",
        "week_mission_name": "任务01",
        "week_mission_content": "与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；\n在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等",
        "week_goals": [
            {
                "week_goal_id": 1,
                "week_mission_id": 1,
                "week_goal_title": "记忆目标",
                "week_goal_content": "HTML、CSS、JavaScriptweek_goal"
            },
            {
                "week_goal_id": 2,
                "week_mission_id": 1,
                "week_goal_title": "理解目标",
                "week_goal_content": "JQuery等前端库"
            }
        ]
    }
}
```

<br>

### 添加周任务

- 请求路径：weekmission/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| week_id | 周id     | int    | 不能为空 |
| name    | 任务名称 | string | 不能为空 |
| type    | 类型     | int    | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 删除周任务

- 请求路径：weekmission/delete
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明     | 类型      | 备注     |
| ------ | ------------ | --------- | -------- |
| ids    | 周任务id数组 | int array | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 修改周任务内容

- 请求路径：weekmission/updatecontent
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| id      | 周任务id | int    | 不能为空 |
| content | 新内容   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 发布周任务

- 请求路径：weekmission/issue
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明     | 类型      | 备注     |
| ------ | ------------ | --------- | -------- |
| ids    | 周任务id数组 | int array | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "发布成功"
}
```

<br>

## 10 周目标

### 给周添加周目标

- 请求路径：weekgoal/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| id      | 周id     | int    | 不能为空 |
| title   | 标题     | string | 不能为空 |
| content | 内容     | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 删除周目标

- 请求路径：weekgoal/delete
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周目标id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 修改周目标

- 请求路径：weekgoal/update
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| id      | 周id     | int    | 不能为空 |
| title   | 标题     | string | 可以为空 |
| content | 内容     | string | 可以为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

## #####################################





## 7 周和学时

### 根据课程id查询周和学时

- 请求路径：weekperiod/select
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_id": 1,
            "week_name": "第01周",
            "periods": [
                {
                    "period_id": 1,
                    "week_id": 1,
                    "period_name": "第01学时",
                    "period_content": "内容",
                    "period_type": 1,
                    "period_status": 1
                },
                {
                    "period_id": 2,
                    "week_id": 1,
                    "period_name": "第02学时",
                    "period_content": "内容",
                    "period_type": 1,
                    "period_status": 1
                }
            ]
        }
    ]
}
```

<br>

### 根据学时id查询学时

- 请求路径：weekperiod/selectperiodbyperiodid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 学时id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "period_id": 1,
        "week_id": 1,
        "period_name": "第01学时",
        "period_content": "内容",
        "period_type": 1,
        "period_status": 1
    }
}
```

<br>

### 添加周（附带周任务）

- 请求路径：weekperiod/addweek
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名    | 参数说明 | 类型   | 备注     |
| --------- | -------- | ------ | -------- |
| course_id | 课程id   | int    | 不能为空 |
| name      | 周名字   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 添加学时

- 请求路径：weekperiod/addperiod
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| week_id | 周id     | int    | 不能为空 |
| name    | 学时名字 | string | 不能为空 |
| type    | 学时类型 | int    | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 修改学时

- 请求路径：weekperiod/updateperiod
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注           |
| ------- | -------- | ------ | -------------- |
| id      | 学时id   | int    | 不能为空       |
| name    | 学时名   | string | 后面不能全为空 |
| content | 学时内容 | string | 后面不能全为空 |
| type    | 学时类型 | int    | 后面不能全为空 |
| status  | 学时状态 | int    | 后面不能全为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 修改周

- 请求路径：weekperiod/updateweek
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型   | 备注     |
| ------ | -------- | ------ | -------- |
| id     | 周id     | int    | 不能为空 |
| name   | 周名字   | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "修改成功"
}
```

<br>

### 删除学时

- 请求路径：weekperiod/deleteperiod
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 学时id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

### 删除周

- 请求路径：weekperiod/deleteweek
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周id     | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

## 8 周任务

### 根据课程id查询所有周任务

- 请求路径：weekmission/selectbycourseid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 课程id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_mission_id": 1,
            "week_mission_name": "第01周 任务"
        },
        {
            "week_mission_id": 2,
            "week_mission_name": "第02周 任务"
        },
        {
            "week_mission_id": 3,
            "week_mission_name": "第03周 任务"
        }
    ]
}
```

<br>

### 根据周任务id查询周任务

- 请求路径：weekmission/selectbyid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周任务id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "week_mission_id": 1,
        "week_id": 1,
        "week_mission_name": "第01周 任务",
        "week_mission_content": "任务1 任务2",
        "week_mission_status": 1
    }
}
```

<br>

### 根据周id查询周任务

- 请求路径：weekmission/selectbyweekid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周id     | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "week_mission_id": 1,
        "week_id": 1,
        "week_mission_name": "第01周 任务",
        "week_mission_content": "任务1 任务2",
        "week_mission_status": 1
    }
}
```

<br>



## 9 随堂测试

### 根据学时id查询随堂测试

- 请求路径：periodtest/selecttestbyperiodid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 学时id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "period_test_id": 1,
            "period_id": 1,
            "period_test_name": "第01学时 测试1",
            "period_test_status": 2
        },
        {
            "period_test_id": 2,
            "period_id": 1,
            "period_test_name": "第01学时 测试2",
            "period_test_status": 1
        }
    ]
}
```

<br>

### 给学时添加随堂测试

- 请求路径：periodtest/inserttest
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明   | 类型   | 备注     |
| ------ | ---------- | ------ | -------- |
| id     | 学时id     | int    | 不能为空 |
| name   | 测试的名字 | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>

### 发布随堂测试

- 请求路径：periodtest/issue
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明     | 类型 | 备注     |
| ------ | ------------ | ---- | -------- |
| id     | 随堂测试的id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "发布成功"
}
```

<br>

### 删除随堂测试

- 请求路径：periodtest/delete
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明     | 类型 | 备注     |
| ------ | ------------ | ---- | -------- |
| id     | 随堂测试的id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

## 10 课堂讨论评论

### 根据学时id查询课堂讨论

- 请求路径：discussioncomment/selectdissbyperiodid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 学时id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "discussion_id": 1,
            "discussion_title": "讨论标题11",
            "discussion_content": "这是内容....这是内容......",
            "discussion_date": "2021-02-23T16:00:00.000+00:00"
        },
        {
            "discussion_id": 2,
            "discussion_title": "讨论标题22",
            "discussion_content": "这是内容....这是内容......",
            "discussion_date": "2021-02-23T16:00:00.000+00:00"
        }
    ]
}
```

<br>

### 根据讨论id查询课堂讨论

- 请求路径：discussioncomment/selectdissbydisscussionid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 讨论id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "discussion_id": 1,
        "discussion_title": "机器学习的应用讨论",
        "discussion_content": "请举例说明机器学习与深度学习的应用案例。",
        "discussion_date": "2021-02-23T16:00:00.000+00:00",
        "teacher_name": "张妍琰",
        "teacher_avatar": "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
    }
}
```

<br>

### 根据讨论id查询评论

- 请求路径：discussioncomment/selectcommentsbydisscussionid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 讨论id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "comment_id": 1,
            "comment_content": "这是评论11",
            "comment_date": "2021-02-28T16:00:00.000+00:00",
            "student_name": "吴硕",
            "student_avatar": "avatar"
        },
        {
            "comment_id": 2,
            "comment_content": "这是评论12",
            "comment_date": "2021-02-28T16:00:00.000+00:00",
            "student_name": "吴硕",
            "student_avatar": "avatar"
        }
    ]
}
```

<br>

### 发布课堂讨论

- 请求路径：discussioncomment/issuediscussion
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| id      | 学时id   | int    | 不能为空 |
| title   | 讨论标题 | string | 不能为空 |
| content | 讨论内容 | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "发布成功"
}
```

<br>

### 发布课堂讨论的评论

- 请求路径：discussioncomment/issuecomment
- 请求方法：post
- 权限：学生
- 请求参数

| 参数名        | 参数说明 | 类型   | 备注     |
| ------------- | -------- | ------ | -------- |
| discussion_id | 讨论id   | int    | 不能为空 |
| student_id    | 学生id   | int    | 不能为空 |
| content       | 评论内容 | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "发布成功"
}
```

<br>

### 删除课堂讨论

- 请求路径：discussioncomment/deletediscussion
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名 | 参数说明   | 类型 | 备注     |
| ------ | ---------- | ---- | -------- |
| id     | 课堂讨论id | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "删除成功"
}
```

<br>

## 11 周目标

### 根据周id查询所有周目标

- 请求路径：weekgoal/selectbyweekid
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名 | 参数说明 | 类型 | 备注     |
| ------ | -------- | ---- | -------- |
| id     | 周id     | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "week_goal_id": 1,
            "week_id": 228,
            "week_goal_title": "记忆目标",
            "week_goal_content": "HTML、CSS、JavaScript"
        },
        {
            "week_goal_id": 2,
            "week_id": 228,
            "week_goal_title": "理解目标",
            "week_goal_content": "JQuery等前端库"
        }
    ]
}
```

<br>

### 给周添加周目标

- 请求路径：weekgoal/insert
- 请求方法：post
- 权限：教师
- 请求参数

| 参数名  | 参数说明 | 类型   | 备注     |
| ------- | -------- | ------ | -------- |
| id      | 周id     | int    | 不能为空 |
| title   | 标题     | string | 不能为空 |
| content | 内容     | string | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "添加成功"
}
```

<br>



## 12 学时评价

### 查询学时的评价

- 请求路径：periodevaluation/select
- 请求方法：get
- 权限：教师/学生
- 请求参数

| 参数名    | 参数说明 | 类型 | 备注     |
| --------- | -------- | ---- | -------- |
| period_id | 学时id   | int  | 不能为空 |

- 响应数据

```json
{
    "code": 200,
    "msg": "查询成功",
    "data": {
        "avg_quality": "2.0",
        "avg_degree": "1.0",
        "evaluation_count": 2,
        "evaluations": [
            {
                "student_id": "666666666",
                "student_name": "赵同学",
                "student_avatar": "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
                "period_id": 89,
                "period_evaluate_content": "教的还可以",
                "period_evaluate_date": "2021-03-22T16:00:00.000+00:00",
                "period_evaluate_quality": 4,
                "period_evaluate_degree": 4
            },
            {
                "student_id": "666666666",
                "student_name": "赵同学",
                "student_avatar": "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
                "period_id": 89,
                "period_evaluate_content": "老师教的很棒！",
                "period_evaluate_date": "2021-03-22T16:00:00.000+00:00",
                "period_evaluate_quality": 0,
                "period_evaluate_degree": 0
            }
        ]
    }
}
```

<br>

### 发布学时评价

- 请求路径：periodevaluation/issue
- 请求方法：post
- 权限：学生
- 请求参数

| 参数名     | 参数说明 | 类型   | 备注                                 |
| ---------- | -------- | ------ | ------------------------------------ |
| period_id  | 学时id   | int    | 不能为空                             |
| student_id | 学生id   | int    | 不能为空，同一学生只能对学时发布一次 |
| content    | 评价内容 | string | 可以为空                             |
| degree     | 掌握度   | int    | 不能为空（1-5）                      |
| quality    | 教学质量 | int    | 不能为空（1-5）                      |

- 响应数据

```json
{
    "code": 200,
    "msg": "发布成功"
}
```

<br>

