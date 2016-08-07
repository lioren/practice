read me 

檔案  LCW 裡面有2個資料夾  r_tree 跟 kd_tree ，兩資料夾都已編譯好執行檔名稱 a.out

兩個程式輸入格式為: 

./a.out  inputfilename  

自行產生的隨機10萬比data在資料夾裡 名稱為 10wdata.txt，故輸入

./a.out 10wdata.txt 即可進行測試，學長也可以用自己的測資測，input file格式為學長給的格式


r_tree 直接輸出   skyline point

kd_tree 需先輸入1個point p(例如  100 100) 再輸入一個 距離 d(例如100)，程式會輸出距離 p點(100,100) 100單位以內的所有點


另外 r_tree 是使用網路上開放原始碼下去做修正，我自己實作bbs演算法 位於 RTree.h 檔案裡 622行至691行
