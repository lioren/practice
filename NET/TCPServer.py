host="127.0.0.1"            
port=4446            
from socket import *              
s=socket(AF_INET, SOCK_STREAM)
s.bind((host,port))            
s.listen(1)                    
print "Listening for connections.. "
q,addr=s.accept()    
while 1:
	data=q.recv(1024)
	if '+' in data:
		lengh = int(len(data))
		lengh2 = int(data.find('+'))
		data1 = data[0:lengh2:1]
		data2 = data[lengh2+1:lengh+1:1]
		result = int(data1)+int(data2)
	elif '-' in data:
		lengh = int(len(data))
		lengh2 = int(data.find('-'))
		data1 = data[0:lengh2:1]
		data2 = data[lengh2+1:lengh+1:1]
		result = int(data1)-int(data2)
	elif '*' in data:
		lengh = int(len(data))
		lengh2 = int(data.find('*'))
		data1 = data[0:lengh2:1]
		data2 = data[lengh2+1:lengh+1:1]
		result = int(data1)*int(data2)
	elif '/'in data:
		lengh = int(len(data))
		lengh2 = int(data.find('/'))
		data1 = data[0:lengh2:1]
		data2 = data[lengh2+1:lengh+1:1]
		result = int(data1)/int(data2)


	q.send(str(result))
##s.close()
