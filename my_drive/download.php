<?php
	$get_name= $_GET["A"];
//	echo $get_name;
	system("./a.out get $get_name");

	$file_name = $get_name;
 	$file_path = "$get_name";
 	$file_size = filesize($file_path);
 	header('Pragma: public');
 	header('Expires: 0');
 	header('Last-Modified: ' . gmdate('D, d M Y H:i ') . ' GMT');
 	header('Cache-Control: must-revalidate, post-check=0, pre-check=0');
	header('Cache-Control: private', false);
 	header('Content-Type: application/octet-stream');
 	header('Content-Length: ' . $file_size);
 	header('Content-Disposition: attachment; filename="' . $file_name);
 	header('Content-Transfer-Encoding: binary');
 	readfile($file_path);

//	echo '<meta http-equiv=REFRESH CONTENT=0.01;url=data.php>';
	
?>
