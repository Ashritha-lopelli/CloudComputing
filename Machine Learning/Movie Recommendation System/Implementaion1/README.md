<h1>Movie Recommendation with MLlib - Collaborative Filtering</h1>

<h2>Introduction</h2>

The MovieLens dataset is widely used as a benchmark for evaluating recommendation systems. The program utilizes PySpark, a Python library designed for distributed data processing, to leverage collaborative filtering techniques. This Python program showcases the implementation of a recommendation engine that utilizes the ALS (Alternating Least Squares) model on the MovieLens dataset. By applying collaborative filtering, the program generates personalized movie recommendations for users based on their preferences and historical ratings.

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/4e6e89fb-ac10-4092-9389-1ab3bd999c0b)

<h2>Implementation</h2>

<h3>Steps:</h3>

1. Create a bucket on the GCP and load the movielens.txt file to the bucket.

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/5d9bc702-0722-4c83-b31c-f39a0582e819)

2. On the cloud shell Download this movielens.txt file

```
gsutil cp gs://cs570_mllib/input/movielens.txt .
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/f03c27e0-7df3-4015-9abd-b32c3b76180a)

3. Convert the file to the desired format. This format has only the userid, movieid, rating from the movielens.txt file.

```
cat movielens.txt | while read userid movieid rating timestamp; do echo "${userid},${movieid},${rating}"; done > converted_data.txt
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/24ca5a25-5161-4635-8e0d-74f82939f1aa)

4. To check if the file is converted to the desired format run the command:

```
cat converted_data.txt
```
![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/9086050a-c5ae-473b-976f-91c4206284a5)

5. Now create the dataproc cluster.
   * In the Navigation menu, click on "Dataproc".
   * Click on the "Create cluster" button to create a new cluster.
   * Give the neccessary details such as Cluster name, Region, Zone and Cluster type.

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/840fa22f-5c4a-451a-b944-ae01e0c6e852)

   * Click create.
   * The cluster is now created and running.

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/441b65ef-967d-47ea-aa66-424d44f90487)

7. Now click on the activate cloud shell and open the editor window, in where we have to insert the code (the code file is attached in the folder and also chnage the path of the .txt file).

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/4a5cffe4-0b2b-4bed-83ea-49c7f52f7b69)


8. To execute for the output Run the command on the cloud shell

```
gcloud dataproc jobs submit pyspark milib.py --cluster-cluster-ef2d --region us-centrall
```

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/53615e37-8f82-45b4-9b86-f716cbfc575f)

9. And now the implementation is done succesfully.

