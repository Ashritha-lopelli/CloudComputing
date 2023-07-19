<h1>Movie Recommendation with MLlib - Collaborative Filtering</h1>

<h2>Introduction</h2>

The MovieLens dataset is widely used as a benchmark for evaluating recommendation systems. The program utilizes PySpark, a Python library designed for distributed data processing, to leverage collaborative filtering techniques. This Python program showcases the implementation of a recommendation engine that utilizes the ALS (Alternating Least Squares) model on the MovieLens dataset. By applying collaborative filtering, the program generates personalized movie recommendations for users based on their preferences and historical ratings.

![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/c52dd259-cf31-43b2-ba43-df5fb9370ae0)


<h2>Implementation</h2>

<h3>Steps on Colab:</h3>

1. Download the recommendation_movielens1.py file, movies.csv, rating.csv, tags.csv files.
2. Open and login to your Google colab.
3. Upload the recommendation_movielens1 file to the colab.
4. Also add the movies.csv, rating.csv, tags.csv files to the folder of the colab.
   
   ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/baf4025f-e518-449c-8f50-620ead66a281)

6. Run all the command on the recommendation_movielens1 file and then Download this file as .py file.
   
  ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/687f2b42-2503-49b6-b181-6c8345ce8e49)

<h3>Steps on GCP:</h3>

1. Create a bucket on the GCP.
   * Upload the movies.csv, rating.csv, tags.csv files to the above created bucket.
   * Also upload the Downloaded .py file (recommendation_movielens1.py) to the bucket.

     ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/0e1046e5-37e7-4457-b003-e6dde4f16a98)

2. Now create a dataproc cluster.
   * In the Navigation menu, click on "Dataproc".
   * Click on the "Create cluster" button to create a new cluster.
   * Give the neccessary details such as Cluster name, Region, Zone and Cluster type.

     ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/3ff3c17d-c2b1-43c5-bfe5-042b0b9bf5af)

   * Click create.
   * The cluster is now created and running.
     
    ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/226fa006-2d1b-484f-a295-3036bf6d571b)

3. Now submit the job throught the dataproc Jobs.
   * In the Navigation menu, click on "Dataproc".
   * Click on the "Jobs" and then on "submit job" tab to create a new Job.

    ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/1743d609-1147-44bf-8e7f-2f571f386ed5)

   * Fill out all the required details like Job id, Region, Cluster and Job type.
   * Also provide the main file path (here it is recommendation_movielens1.py from the bucket above - copy its path and paste it).

   ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/b2fab477-0cdd-46ca-9f4c-c310f6d4676c)
     
   * Now click on "submit" button.
   * And we can see the output diaplayed.
     
  ![image](https://github.com/Ashritha-lopelli/CloudComputing/assets/124090003/6cc3e1de-c030-4d9f-900d-99d478e35a0c)

3. And hence the the implementation is succesfully done.
