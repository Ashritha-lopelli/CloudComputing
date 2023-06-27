<h1>PageRank + PySpark + GCP </h1>
<h2>Setup Pyspark on GCP</h2>

steps:   

1. Enable the Google Cloud Compute Engine API    
2. Create, Configure and Launch a Google Cloud Dataproc cluster

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/3ac5195e-f9a1-4f75-8c3f-d4d09ac005c2)

3. Connect to the SSH in browser

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/b020ae93-f7ad-4d0f-845c-e25c16436a13)

<h2>Do this question using PySpark</h2>

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/ff58f0b1-ca35-46f1-a521-d82a11089903)

1. Manually calculate the first 2 iteration of the PageRank

Frist iteration A = 1 B = (1/2) = 0.5 C = 1 + (1/2) = 1.5 PageRank (A) = 1 – 0.85 + 0.85 * 1 = 1 PageRank (B) = 1 – 0.85 + 0.85 * 1 = 0.575 PageRank (C) = 1 – 0.85 + 0.85 * 1.5 = 1.425

Second iteration A = 1 B = (1/2) = 0.5 C = 0.575 + (1/2) = 1.075 PageRank (A) = 1 – 0.85 + 0.85 * 1.425 = 1.36125 PageRank (B) = 1 – 0.85 + 0.85 * 0.5 = 0.575 PageRank (C) = 1 – 0.85 + 0.85 * 1.075 = 1.06375

<h2>Running the program and obtaining the Result</h2>

1. create a .py file with the code (pagerank.py)

```
vi pi.py
```
To get the result for first iteration:
```
Python3 pi.py gs://cs570-pagerank-python/input/pagerank.txt 1
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/e0d8ac6b-4f01-4d32-aa87-4e71d9742af3)

To get the result for 2 iteration:
```
Python3 pi.py gs://cs570-pagerank-python/input/pagerank.txt 2
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/4c489d63-292b-4429-9632-d23d1230ee6a)

<h1>PageRank + Scala + GCP</h1>

<h2>Set up Scala on GCP</h2>

steps:

1. Create a Cloud Storage bucket
 
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/5aa352ee-36d4-444b-8d57-8e66dc812f86)

2. Create a Dataproc cluster

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/69f25365-d73a-4c59-92b3-3eeb39ed3b4d)

3. Connect to the SSH in browser

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/b020ae93-f7ad-4d0f-845c-e25c16436a13)

4. Install scala

```
curl -fL https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs && ./cs setup
export SCALA_HOME=/usr/local/share/scala 
export PATH=$PATH:$SCALA_HOME/
```

<h2>Do this question using Scala</h2>

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/ff58f0b1-ca35-46f1-a521-d82a11089903)

1. Prepare the data

Insert the data manually

```
vi pagerank_data.txt
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/8a392275-8c7b-4916-bc30-47811331dbfb)

Input has the data:

```
A B
A C
B C
C A
```

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/7016b8bd-0253-4a1c-9bc6-a84507048b64)

2. create a directory (folder) to store the data:

```
hdfs dfs -mkdir hdfs:///mydata 
hdfs dfs -put pagerank_data.txt hdfs:///mydata
```

To verify that the file is located in the mydata folder, run the following command:

```
hdfs dfs -ls hdfs:///mydata
```

<h2>Running the program and obtaining the Result</h2>

```
spark-shell
```
1. Run the code(pagerank.scala) on scala for 1 iteration

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/fe918907-9a1e-48af-8857-f8f4aeb622ac)

2. Run the code(pagerank.scala) on scala for 2 iteration (to get the result for 2 iteration schange the value in the for loop)

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/a49a46b2-5ebe-4216-a696-ee418663bcf3)

<h1>Shut down the cluster</h1>

Select the cluster you want to shut dowm click on the stop and delete

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/482de418-1f39-450c-ad25-75f748c8e0f8)

<h1>Presentation</h1>

[PageRank on Spark](https://docs.google.com/presentation/d/1QD1vApRnZymI3LMzDdzRfiUcDd22tGMser92CN6nN9U/edit#slide=id.p)
