<?php

$delete_name = $_POST['tmp'];

foreach($delete_name as $select){
	    system("./a.out delete $select");
		echo "<br>";
}
echo '<meta http-equiv=REFRESH CONTENT=0.01;url=data.php>';
echo "test";

?>
