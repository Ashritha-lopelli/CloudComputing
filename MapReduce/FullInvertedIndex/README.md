# Requirements
GCP Environment

![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/fe5aac99-5877-45f3-951f-b93790eed155)

Hadoop Environment

![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/33bde558-e231-4b74-92cb-643ffca34b59)

# Setup passphraseless ssh

check that you can ssh to the localhost without a passphrase:
```
  $ cd hadoop-3.3.4/
  $ ssh localhost
  ```
If you cannot ssh to localhost without a passphrase, execute the following commands:
```
  $ ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
  $ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
  $ chmod 0600 ~/.ssh/authorized_keys
  $ ssh localhost
  ```
  ```
  $ cd ..
  $ cd hadoop-3.3.4/
  $ bin/hdfs namenode -format
  $ sbin/start-dfs.sh
  $ wget http://localhost:9870/
  ```
  
  # Code preparation for InvertedIndex
  
  ```
  $ vi InvertedIndex.java
$ bin/hadoop com.sun.tools.javac.Main InvertedIndex.java
$ jar cf invertedindex.jar InvertedIndex *.class

```
![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/19256efb-f9e9-4b86-8d4d-3dab3ffa793c)

Copy input/file0, input/file1 and input/file2 of this project and place them inside the input folder of the Hadoop distrubution folder. While you are still there, run the following command to submit the job, get the input files from input folder, generate the inverted index and store its output in the output folder
```
$ hadoop dfs -copyFromLocal .  invertedindex50
```

```
$ bin/hadoop jar invertedindex.jar fullindex invertedindex50 output012
```
![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/e3e6c6ee-4dd6-4ec5-80a2-ddb027b81fcb)


And finally to see the output, run the below command:
```
$ bin/hadoop dfs -cat output012/part-r-00000
```
![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/5e0031bd-28c1-4f75-a82f-7802375d7905)

# Code preparation for Full-InvertedIndex

```
$ vi fullindex.java
$ bin/hadoop com.sun.tools.javac.Main fullindex.java
$ jar cf invertedindex.jar fullindex*.class
```

![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/4896b6f3-77a3-4a98-aeaa-281a5719135d)


Copy input/file0, input/file1 and input/file2 of this project and place them inside the input folder of the Hadoop distrubution folder. While you are still there, run the following command to submit the job, get the input files from input folder, generate the inverted index and store its output in the output folder

```
$ hadoop dfs -copyFromLocal .  invertedindex25
$ bin/hadoop jar fullinvertedindex.jar fullindex invertedindex25 output03
```
![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/616221e5-4e1c-49c0-a083-dcf1c8686680)


And finally to see the output, run the below command:

```
$ bin/hadoop dfs -cat output03/part-r-00000
```
![image](https://github.com/Ashritha-lopelli/Big-Data-Full-Inverted-Index/assets/124090003/eea2a5b7-3a91-45d0-8248-f048311be2f8)




  
