host="127.0.0.1"         
port=4446             
from socket import *        
s=socket(AF_INET, SOCK_STREAM)    
s.connect((host,port))
while 1:
	data=raw_input("Enter data to be send: ")
	s.send(data);
	msg=s.recv(1024)        
	print "Message from server : " + msg       
s.close()         
