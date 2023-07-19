<h1>Movie Recommendation with MLlib - Collaborative Filtering</h1>

<h2>Introduction</h2>

The MovieLens dataset is widely used as a benchmark for evaluating recommendation systems. The program utilizes PySpark, a Python library designed for distributed data processing, to leverage collaborative filtering techniques. This Python program showcases the implementation of a recommendation engine that utilizes the ALS (Alternating Least Squares) model on the MovieLens dataset. By applying collaborative filtering, the program generates personalized movie recommendations for users based on their preferences and historical ratings.

<h2>Implementation</h2>

<h3>Steps on Colab:</h3>

1. Download the recommendation_movielens1.py file, movies.csv, rating.csv, tags.csv files.
2. Open and login to your Google colab.
3. Upload the recommendation_movielens1 file to the colab.
4. Also add the movies.csv, rating.csv, tags.csv files to the folder of the colab.
5. Run all the command on the recommendation_movielens1 file and then Download this file as .py file.

<h3>Steps on GCP:</h3>

1. Create a bucket on the GCP.
   * Upload the movies.csv, rating.csv, tags.csv files to the above created bucket.
   * Also upload the Downloaded .py file (recommendation_movielens1.py) to the bucket.
2. Now create a dataproc cluster.
   * In the Navigation menu, click on "Dataproc".
   * Click on the "Create cluster" button to create a new cluster.
   * Give the neccessary details such as Cluster name, Region, Zone and Cluster type.
   * Click create.
   * The cluster is now created and running.
3. Now submit the job throught the dataproc Jobs.
   * In the Navigation menu, click on "Dataproc".
   * Click on the "Jobs" tab to create a new Job.
   * Fill out all the required details like Job id, Region, Cluster and Job type.
   * Also provide the main file path (here it is recommendation_movielens1.py from the bucket above - copy its path and paste it).
   * Now click on "submit" button.
   * And we can see the output diaplayed.
4. And hence the the implementation is succesfully done.
