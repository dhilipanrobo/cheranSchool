<?php
include 'csdbconfig.php';
$user_sno = $_POST["sno"];
$user_tamil = $_POST["tamil"];
$user_english = $_POST["english"];
$user_maths = $_POST["maths"];
$user_science= $_POST["science"];
$user_rno= $_POST["rno"];
$user_social= $_POST["social"];
$user_cs= $_POST["cs"];
$user_gk= $_POST["gk"];
$user_total= $_POST["total"];
$user_remark= $_POST["rank"];
$user_term= $_POST["term"];
$user_hindi= $_POST["hindi"];
$servername = "localhost";
$name = "root";
$password = "1234";
$database = "noticeboard";


$sql = "insert into srkrankcard values('".$user_sno."','".$user_rno."','".$user_tamil."','".$user_english."','".$user_hindi."','".$user_maths."','".$user_science."','".$user_social."','".$user_cs."','".$user_gk."','".$user_total."','".$user_remark."','".$user_term."');";
if(mysqli_query($con,$sql)){
	
	echo "data insert .....";
}
else {
	
	echo "error insert data ....";
}
mysqli_close($con);

