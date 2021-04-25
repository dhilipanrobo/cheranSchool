<?php
include 'csdbconfig.php';
$sno = $_GET["rno"];
if(! $con ) {
die('Could not connect: ' . mysql_error());
}


$query="select * from srkclasstest where rno ='".$sno."' ORDER BY sno DESC";
$result=mysqli_query($con,$query);
$respones=array();
$respones1=array();
while($row=mysqli_fetch_array($result))
{
	

	
		array_push($respones,array("remark"=>$row[4],"states"=>$row[3],"rno"=>$row[2],"datee"=>$row[1],"sno"=>$row[0]));
	

	
	
}


echo json_encode($respones);


?>
