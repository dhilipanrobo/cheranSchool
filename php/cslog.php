<?php

$term = $_GET["term"];
include 'csdbconfig.php';

$query="select password,class from srklog where username ="."'".$term."'";
$result=mysqli_query($con,$query);
$respones=array();
$respones1=array();
while($row=mysqli_fetch_array($result))
{
	
	
	array_push($respones,array("pass"=>$row[0],"class"=>$row[1]));
	
	
}


echo json_encode($respones);

?>
