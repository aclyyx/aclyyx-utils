# aclyyx-utils
各种开发中使用的小工具类

### StringUtil
* MD5  
  对传入字符串进行MD5编码并返回
* SHA1  
  对传入字符串进行SHA1编码并返回

### DatetimeUtil
* reset  
  当系统时间在应用运行时被改变, 需要调用此方法, 否则格式化后的时间可能出现问题
* long\_2\_HHmmss  
  对传入的long型数据, 格式化为 hh:mm:ss 并返回, 主要对于倒计时等使用
* long\_2\_YYYYMMDD_HHmm  
  对传入的long型数据, 格式化为 yyyy-MM-dd HH:mm 并返回
* long\_2\_DayOfTheWeek  
  对传入的long型数据, 格式化为 周X 并返回
