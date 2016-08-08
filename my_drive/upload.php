<?php
if ($_FILES["file"]["error"] > 0)
{
		echo "Error: " . $_FILES["file"]["error"] . "<br />";
}
else
{
//		foreach($_FILES["fileselect"]["error"] as $key){
		$filename = $_FILES["fileselect"]["name"];
		$filetype = pathinfo($filename,PATHINFO_EXTENSION);
		$filesize = $_FILES["fileselect"]["size"];
		$uploaddir= '../project1/';
		$uploadfile = $uploaddir.basename($filename);
		echo $uploadfile."<br>";
	        echo $filename. "<br>".$filetype. "<br>".$filesize. "<br>";	
		if(move_uploaded_file($_FILES["fileselect"]["tmp_name"],$uploadfile)){
		echo "successfully";
		}
		else{
		echo "fail";
		}
		system("./a.out save $filename");
//		}
		echo '<meta http-equiv=REFRESH CONTENT=0.01;url=data.php>';
		

}
?>
