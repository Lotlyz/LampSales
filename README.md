# 项目背景

## 选题与要求
大三下学期，软件设计与开发实训课题：按学号尾数选题

![实训选题](https://lotlyzbolg.oss-cn-shenzhen.aliyuncs.com/lampsales/%E9%80%89%E9%A2%98.png)

![实训选题](https://lotlyzbolg.oss-cn-shenzhen.aliyuncs.com/lampsales/%E8%A6%81%E6%B1%82.png)

# 项目介绍

## 系统目标
本系统主要目的在于掌握SpringBoot和Vue技术的基本使用。

## 实现的功能
1. 新增灯具用品、删除灯具用品、灯具用品信息修改、灯具用品信息查询
2. 新增用户、删除用户、用户信息查询、用户信息修改
3. 购买灯具用品，销售订单查询

## 技术介绍
**前端**： Vue + vue router + Element UI + axios

**后端**： SpringBoot + MyBatis

## 开发环境：
|开发工具|说明|
|-|-|
|IDEA|Java开发工具IDE|
|VSCode|Vue开发工具IDE|
|Navicat|MySQL工具|

|开发环境|版本|
|-|-|
|JDK|1.8|
|MySQL|8.0.20|
|Node.js|14.17.2|


# 快速开始

1. 提前预装好Node.js环境
2. 前端项目位于vue文件夹下，后端项目位于springboot文件夹下，SQL文件位于根目录下的lampsales.sql。可直接导入该项目于本地
3. 修改SpringBoot工程的application.yml中数据库的连接信息，对应为你的数据库用户名和密码
4. 先运行后端项目，再启动前端项目。前端项目导到本地后先在终端执行npm install命令安装项目所需依赖，再执行npm run serve即可启动。

