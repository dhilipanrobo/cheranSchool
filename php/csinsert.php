<?php
include 'csdbconfig.php';
$user_sno = $_POST["sno"];
$user_date = $_POST["date"];
$user_title = $_POST["title"];
$user_mater = $_POST["mater"];
$user_teacher = $_POST["tech"];


$sql = "insert into srknotice values('".$user_sno."','".$user_date."','".$user_title."','".$user_mater."','".$user_teacher."');";
if(mysqli_query($con,$sql)){
	
	echo "data insert .....";
}
else {
	
	echo "error insert data ....";
}
mysqli_close($con);

?>