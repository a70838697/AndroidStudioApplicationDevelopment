<?php
  header("Content-Type: text/html;charset=utf-8");// 设置页面显示的文字编码
  echo "GET:  ";
  print_r($_GET);
  $ssid=$_GET["sid"];
  $sname=$_GET["name"];
  $semail=$_GET["email"];
  print_r("GET给服务器的值为数组\n" );
  print_r($ssid );
  print_r("\n");
  print_r($sname);
  print_r("\n");
  print_r($semail);
  print_r("\n");
?>
