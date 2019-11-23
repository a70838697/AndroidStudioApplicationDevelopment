<?php
  header("Content-Type: text/html;charset=utf8");// 设置页面显示的文字编码
  $con = mysql_connect("localhost", "root", ""); // 连接数据库
  mysql_query("set names utf8");//设置数据库的编码方式
  // 下面一大段代码是为了拼接出JSON格式的字符串
  echo "[";
  if($con)
  {
    mysql_select_db("testdb", $con); // 选择要使用的数据库
    $query = "SELECT * FROM user";   // 数据库查询语句
    $result = mysql_query($query);	 // 执行查询操作
   $i = 0;							 // 用来判断是否为第一条数据
   while($row = mysql_fetch_array($result))
  {
    if($i != 0){ echo ","; }// 如果是第一条数据，则在数据前不现实逗号分隔符
    else{  $i = 1;   }
    echo '{ "';
    echo 'sid":';
    echo '"';
    echo $row['sid'];
    echo '",';
    echo '"';
    echo 'name":';
    echo '"';
    echo $row['name'];
    echo '",';
    echo '"';
    echo 'email":';
    echo '"';
    echo $row['email'];
    echo '"}';
   }
 }else
 {
   // 如果连接数据库失败，仍然可以返回一条JSON数据
   echo '{ "sid":101,"name":"服务器出错了","email":"123@abc"}';
  }
  echo "]";
  mysql_close($con);
?>
