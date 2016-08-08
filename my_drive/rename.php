<?php

$first_name = $_GET['A'];
$second_name = $_GET['B'];

system("./a.out rename $first_name $second_name");

echo '<meta http-equiv=REFRESH CONTENT=0.01;url=data.php>';
?>
