# H5唤起原生应用

点击浏览器中的URL链接，启动特定的APP

## 实现方式

### H5实现

#### 链接格式如下

```
<a href="[scheme]://[host]/[path]?[query]"> 唤起应用 </a> 
```

#### 各个项目含义如下所示：

 * scheme：唤起协议	※详细后述
 * host：  唤起指定host
 * path：  协议路径
 * query： 一些参数

#### 终端未安装APP
  
  终端如果已经安装我们的应用，这个时候可以直接唤起原生应用；终端如果没有安装我们的应用，这时我们需要引导用户去安装。

#### JavaScript实现源码

```javascript
<html>
<head>
    <meta http-equiv="Content-Type" charset="GB2312"/>

    <script type="text/javascript">
            function javacalljs(){
                 document.getElementById("showmsg").innerHTML = "JAVA调用了JS的无参函数";

            }

            function javacalljswith(arg){
                 document.getElementById("showmsg").innerHTML = (arg);

            }

        </script>

</head>

<body>
<h3>Web模块</h3>

<h3 id="showmsg">调用js显示结果</h3>

<input type="button" value="Js调用Java代码" onclick="window.android.jsCallAndroid()"/>
<a href="tuiyouqianapp://tuiyouqianapp.com/open/scheme?name=google09&page=1" onclick="true">点击</a>
<input type="button" value="Js调用Java代码并传参数" onclick="window.android.jsCallAndroidArgs('Js传过来的参数')"/>
</body>
</html>
```

### APP实现

#### AndroidManifest中添加配置

```java
<activity android:name=".SchemeActivity">
	<intent-filter>
		<action android:name="android.intent.action.VIEW" />
		<category android:name="android.intent.category.BROWSABLE" />
		<category android:name="android.intent.category.DEFAULT" />
		<data android:scheme="schemedemo" />
	</intent-filter>
</activity>
```

#### DATA标签中匹配原则如下：

 * `android:scheme` : 唤起协议
 * `android:host` : 唤起host，只有置顶的host才可被唤起
 * `android:pathPrefix` : 唤起的路径，对路径进一步的过滤

#### Activity中接受唤起协议的数据：

```java
Uri uri = getIntent().getData();
StringBuilder sb = new StringBuilder();
// 唤起链接
sb.append("string : ").append(getIntent().getDataString()).append("\n");
sb.append("scheme : ").append(uri.getScheme()).append("\n");
sb.append("host : ").append(uri.getHost()).append("\n");
sb.append("port : ").append(uri.getPort()).append("\n");
sb.append("path : ").append(uri.getPath()).append("\n");
// 接收唤起的参数
sb.append("name : ").append(uri.getQueryParameter("name")).append("\n");
sb.append("page : ").append(uri.getQueryParameter("page"));

tv_data.setText(sb.toString());
```


### 开发者

* 李杭坤 微信号- lhk521666

