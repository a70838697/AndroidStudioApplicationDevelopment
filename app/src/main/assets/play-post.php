<?php
  header("Content-Type: text/html;charset=utf-8");// 设置页面显示的文字编码
  echo "POST:  ";
  print_r($_POST);
  $ssid=$_POST["sid"];
  $sname=$_POST["name"];
  $semail=$_POST["email"];
  print_r("POST给服务器的值为数组\n" );
  print_r($ssid );
  print_r("\n");
  print_r($sname);
  print_r("\n");
  print_r($semail);
  print_r("\n");
?>
