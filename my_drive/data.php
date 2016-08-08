<!doctype html>
<html>
<head>

<title> mydatabase </title>
<script type = "text/javascript">
function wireDragEvents( ) {
		var div = document.getElementById('dropDiv');
		div.addEventListener( 'drop', handleDrop, false );
		div.addEventListener( 'dragenter', handleEnter, false ); 
		div.addEventListener( 'dragover', handleDragOver, false );
}
function handleEnter( e ) {
		document.getElementById('dropDiv').textContent = "";
		e.stopPropagation();
		e.preventDefault();
}
function handleDrop( e ) {
		e.stopPropagation();
		e.preventDefault();
		var files = e.dataTransfer.files;
		var file = files[0];
		document.getElementById('dropDiv').innerHTML += " <br/>" +
				"File name:" + file.name + " <br/> " +
				"&nbsp;&nbsp;&nbsp;&nbsp;File size:" + file.size + "<br/> " +
				"&nbsp;&nbsp;&nbsp;&nbsp;Last time:" + file.lastModifiedDate;

		var formData = new window.FormData();
		formData.append( 'myile', file );

		var xhr = new XMLHttpRequest();
		xhr.open( 'POST', '/project1/upload.php' );
		xhr.onload = function () {
				if (xhr.status === 200) {
						alert('success');
				} else {
						alert('fail');
				}
		};
		xhr.send(formData);

}
function handleDragOver( e ) { 
		e.stopPropagation();
		e.preventDefault();
		e.dataTransfer.dropEffect = 'copy';
}
function delete1(name)
{
		var r = confirm("Sure to delete?");
				if (r == true){
									Form.submit();
				}
}
function rename1(name1)
{
	var name2=prompt("new name","");
	var url = "/project1/rename.php?A="+name1+"&B="+name2;
	location.href=url;

}
window.addEventListener( "DOMContentLoaded" , wireDragEvents , false );
</script>
</head>
<body>
<!--
<div id = "dropDiv" dropzone = "copy" style = "width: 200px; height: 200px; padding: 50px;
border: solid 2px black;" >
</div>
-->
<form id="upload" action="/project1/upload.php" method="post" enctype="multipart/form-data">

<fieldset>
<legend></legend>
<!--
<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />
-->
<div>
<label for="fileselect">Files to upload:</label>
<input type="file" id="fileselect" name="fileselect" multiple="multiple" />

<div id="submitbutton">
<button type="submit">Upload Files</button>
</div>

</fieldset>

</form>
</body>

<body>

<?php
$delimiter = "\n";
$i=1;
$fp=fopen('my.db','r');
echo '<form name= "form1" method="post" action="/project1/delete.php">';
echo '<table width=600>';
echo '<caption>My Database</caption>';
echo '<tr>';
echo "<th>ID</th><th>NAME</th><th>SIZE</th><th>TIME</th>";
echo "<th>";
echo "<input type=\"submit\" value=\"delete it!!\" </button>";
echo "</th>";
echo "<th>";
echo "RENAME";
echo "</th>";
echo '</tr>';
echo '<tr>';
while(!feof($fp))
{
		$buffer =stream_get_line($fp,1024,$delimiter);
		if(strcmp( $buffer ,"@id:")==0){
				$buffer='';
				$tmp0 =stream_get_line($fp,1024,$delimiter);
				//echo '<td align="center">' . $buffer . '</td>';		
		}
		else if(strcmp( $buffer ,"@name:")==0){
				$buffer='';
				$tmp1 =stream_get_line($fp,1024,$delimiter);
				//echo '<td align="center">'. $buffer . '</td>';		
		}
		else if(strcmp( $buffer ,"@size:")==0){
				$buffer='';
				$tmp2 =stream_get_line($fp,1024,$delimiter);
				//echo '<td align="center">'. $buffer .'</td>';
				//echo '<td align="center">'. $tmp .'</td>';


				echo '</tr>';
		}
		else if(strcmp( $buffer ,"@time:")==0){
				$buffer='';
				$tmp3 =stream_get_line($fp,1024,$delimiter);
		}
		else if(strcmp( $buffer,"@exist:")==0){
				$buffer='';
				$tmp4= stream_get_line($fp,1024,$delimiter);
				if(strcmp($tmp4,'1')==0){						
						echo '<td align="center">' . $tmp0 . '</td>';	
						echo '<td align="center">' . 

								"<a href =\"/project1/download.php?A=$tmp1\">" . $tmp1 . '</a>'	

								. '</td>';	
						echo '<td align="center">' . $tmp2 . '</td>';	
						echo '<td align="center">' . $tmp3 . '</td>';	
						echo '<td align="center">' ;
						echo "<input type='checkbox' value=$tmp1 name='tmp[]' >";
						echo '</td>';
						echo '<td align="center">';
							
						echo '<input type="button" onclick="rename1(\''.$tmp1.'\')" value="rename"</input>';
						echo '</td>';
				}
		}




		$i++;
		$buffer='';
}
echo '</table>';
echo '</form>';
?>
</body>
<body>
<?php
// echo  shell_exec("./a.out")

?>
</body>
</html>
