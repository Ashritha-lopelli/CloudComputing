# Requirment
GCP Environment

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/9cf028a2-c4b5-4778-92f8-a8f65c0fda82)

Hadoop Environment

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/1ee28c20-e5e2-4975-a555-fdaef0b9e7a1)

# Prepare input data

Commands:
```
  $ mkdir PiCalculation
  $ cd PiCalculation
  $ vi GenerateRandomNumbers.java
  $ javac GenerateRandomNumbers.java
  $ java -cp . GenerateRandomNumbers
  ```

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
 ![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/1cfdcb79-2c74-4540-b118-39e17e06bdf2)

# Make the HDFS directories required to execute MapReduce jobs(Copy input data to HDFS)
```
  $ cd ..
  $ cd hadoop-3.3.4/
  $ bin/hdfs namenode -format
  $ sbin/start-dfs.sh
  $ wget http://localhost:9870/
  $ bin/hdfs dfs -mkdir /user
  $ bin/hdfs dfs -mkdir /user/alopelli777
  $ bin/hdfs dfs -mkdir /user/ alopelli777/picalculate
  $ bin/hdfs dfs -mkdir /user/ alopelli777/picalculate/input
  $ bin/hdfs dfs -put ../PiCalculation/PiCalculationInput /user/ alopelli777/picalculate/input
```

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/64648a9f-b841-4aff-bfa9-9b44fe6590b8)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/acda0ca7-7361-4ce7-a620-b0b0f94894b4)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/3d69f49c-adf8-4516-be6d-b4d0a63be321)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/07d64bff-a124-4c78-8c58-91fde0660d38)


# Code preparation

Build PiCalculation java file
```
  $ cd /hadoop-3.3.4
  $ vi PiCalculation.java    
  ```
Compile PiCalculation.java and create a jar
```
  $ bin/hadoop com.sun.tools.javac.Main PiCalculation.java
  $ jar cf wc.jar PiCalculation*class 
```
![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/64653fce-154e-4a4f-a107-3097d7d3952d)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/8bde7f1a-2e0b-428c-beeb-7df201ed7294)
  
# Run

Execute
```
  $ bin/hadoop jar wc.jar PiCalculation /user/alopelli777/picalculate/input /user/alopelli777/picalculate/output7
```
Output
```
  $ bin/hdfs dfs -ls /user/alopelli777/picalculate/output7
  $ bin/hdfs dfs -cat /user/alopelli777/picalculate/output7/part-r-00000
```
  
![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/607d10e3-f1ea-43ae-9201-518ba9ba833d)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/04e852c5-4be2-4a87-80c0-faa4cbca8737)

![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/35344a0d-06fe-496d-80e0-fdca85193196)


Stop
```
  $ sbin/stop-dfs.sh
```
![image](https://github.com/Ashritha-lopelli/Big-Data-PiCalculation/assets/124090003/6b21ad68-a07c-4384-8735-a5bbb7aacf75)



