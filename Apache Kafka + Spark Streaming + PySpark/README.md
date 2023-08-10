<h1>Kafka + Spark Streaming + PySpark</h1>

<h2>Introduction</h2>

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/91763a58-ac6d-4412-b701-0f3068f45d92)

<h3>Apache Kafka:</h3> Apache Kafka is a distributed streaming platform that is designed to handle high-throughput, fault-tolerant, and real-time data streaming. It uses a publish-subscribe model to allow producers to send data to topics, and consumers can subscribe to these topics to receive the data.

<h3>Spark Streaming:</h3> Spark Streaming is a component of the Apache Spark ecosystem that enables real-time stream processing. It ingests data from various sources, processes the data using micro-batch processing, and produces results in near real-time.

<h3>PySpark:</h3> PySpark is the Python API for Apache Spark, enabling you to write Spark applications using Python. It provides the same capabilities as the Scala and Java APIs of Spark.

<h3>Results and Output:</h3> Processed results can be stored in external data stores, databases, or files. You can also use various output sinks to visualize or monitor the processed data.

<h2>Implementation</h2>
<h3>1.	Create the Dataproc cluster</h3>

* Navigate to the Dataproc and create a cluster and the cluster is active and running

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/72c7ac6f-104b-440e-b300-d34996b8fe6c)

<h3>2. Check the pyspark</h3>

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/a61f0467-d65a-4485-8000-a96eb594e807)

<h3>3. Download and Extract Kafka </h3>

```
$ wget https://downloads.apache.org/kafka/3.5.1/kafka_2.12-3.5.1.tgz
$ tar -xvf kafka_2.12-3.3.1.tgz
```
<h3>4.	Setup Spark</h3>

```
$ pip3 install msgpack
$ pip3 install kafka-python
```

<h3>5. Start Zookeeper</h3>

```
cd kafka_2.12-3.5.1/
bin/zookeeper-server-start.sh config/zookeeper.properties
```

* Now open another ssh terminal by again clicking the vm instances -> ssh this will be terminal 2

<h3>6. Start Kafka broker</h3>

```
cd kafka_2.12-3.5.1/
bin/kafka-server-start.sh config/server.properties
```

* Now again open a new terminal and in this we create the kafka topic

<h3>7. Create kafka topic</h3>

```
cd kafka_2.12-3.5.1/
bin/kafka-topics.sh --create --topic input_event --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

<h3>8. Create Consumer.py</h3>

* In this same terminal now we Create and Run the Kafka Consumer
* We create a Python script named consumer.py and implement the consumer logic using the kafka-python library and run it


```
vi consumer.py
python3 consumer.py
```

* Code in Consumer.py

```
consumer = KafkaConsumer('input_event', bootstrap_servers=['localhost:9092'])
for msg in consumer:
    print(msg)
```

* Open a new terminal  terminal 4 now we Create and Run the Kafka Producer

<h3>9. Create Producer.py</h3>

* We create a Python script named consumer.py and implement the consumer logic using the kafka-python library and run it

```
vi producer.py
python3 producer.py
```

* Code in Producer.py

```
from kafka import KafkaProducer
producer = KafkaProducer(bootstrap_servers='localhost:9092')
producer.send('input_event', b'(1, Main Menu), (2, Phone), (3, Smart Phone), (4, iPhone)')
producer.close()
```


<h3>10. Result</h3>

* when the producer code in ran we see the output in the consumer terminal i.e., terminal 3

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/5cf73ebd-b885-4e09-a3f8-9bf562046bc9)

* Hence, we can see that the message sent from the producer is correctly received by the consumer




















