<?php

$term = $_GET["term"];
$Rno = $_GET["rno"];
include 'csdbconfig.php';

$query="select  * from srkrankcard where term ="."'".$term."'"."AND rno="."'".$Rno."'ORDER BY sno DESC";


$result=mysqli_query($con,$query);
$respones=array();
$respones1=array();
while($row=mysqli_fetch_array($result))
{
	
	
	array_push($respones,array("tamil"=>$row[2],"english"=>$row[3],"hindi"=>$row[4],"maths"=>$row[5],"science"=>$row[6],"social"=>$row[7],"cs"=>$row[8],"gk"=>$row[9],"total"=>$row[10],"rank"=>$row[11]));
	
	
}


echo json_encode($respones);

?>
