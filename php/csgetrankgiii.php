<?php

$term = $_GET["term"];
$Rno = $_GET["rno"];
include 'csdbconfig.php';

$query="select  * from srkrankcardgiii where term ="."'".$term."'"."AND rno="."'".$Rno."'ORDER BY sno DESC";


$result=mysqli_query($con,$query);
$respones=array();
$respones1=array();
while($row=mysqli_fetch_array($result))
{
	
	
	array_push($respones,array("tamil"=>$row[1],"english"=>$row[2],"eco"=>$row[3],"com"=>$row[4],"acc"=>$row[5],"cs"=>$row[6],"total"=>$row[7],"rank"=>$row[8]));
	
	
}


echo json_encode($respones);

?>
