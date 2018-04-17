# 安居网
#### 装修网是针对装修业主的一站式服务平台。业主将装修信息提交到系统，系统为其分配装修公司。装修公司通过电话等方式联系用户进行洽谈。业主也可以在平台上浏览需要的款式，以及选择装修公司。平台与业主没有直接的经济交易，平台只是为业主提供装修信息。

## 预览
![](https://github.com/printlin/images/blob/master/anjuwang/anjuwang-index.jpg "首页")

## 开发环境
>JDK1.8 mysql5.7 tomcat8.0 myeclipse2017
## 编程技术
>servlet/jsp JDBC html/css/js Ajax 反射 图片验证码 文件上传
## 时间
>2016-11-01 ~ 2017-01-24
<br>

## 问题与解决方案
### 1、怎么记住登录状态，下次免登录？
>当用户选中`记住我`，则向服务器发送记住登录状态请求。服务向客户机写Cookie，内容是经过MD5加密后的用户信息（用户ID&记录时间），并将其存入数据库。等下次访问时`LoginFilter`拦截请求，判断Cookie中有没有用户信息，如果有则查询数据库找出对应用户，否则跳转登录页面。
### 2、怎么创建图片验证码？
>通过`BufferedImage`创建一幅图片，使用`Graphics`在图片上绘制内容。内容是从字符数组中通过`Random`随机取出，当然还要加入一些噪点与干扰线。噪点是通过`Random`随机生成XY坐标与个数，干扰线同理。最后将图片发送给前台，将答案保存在Session中，以便于验证。
### 3、文件的上传
>通过`org.apache.commons.fileupload`工具包来实现文件上传，主要包含项目真实路径的获取、上传文件格式的验证、上传文件大小的验证、上传进度的反馈。
### 4、表单数据的自动封装
```Java
public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
	try{
		T bean=beanClass.newInstance();
		Enumeration<String> e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			BeanUtils.setProperty(bean, name, value);
		}
		return bean;
	}catch(Exception e){
		throw new RuntimeException(e);
	}
}
```
<br>

## 心得总结
在刚学JavaWeb的课程不久就开始了本项目的编写，以便巩固所学知识。通过本项目对JavaWeb有了更加深入的了解，对以往一无所知的网站建设有了初步认识。在编程中遇到问题时先问度娘，再问老师，得到解决方案后应当编写Demo来进行练习巩固。
