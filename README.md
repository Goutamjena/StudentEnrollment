# Student Enrollment Application Deployment Guide

## 1. Setup Kubernetes Cluster

Ensure that you have a Kubernetes cluster ready. You can choose one of the following methods:

- **Minikube:**
  - Install Docker
  - Install kubectl
  - Install Minikube
  - Start Minikube: `minikube start`

- **Kubeadm:**
  - Install Docker
  - Install kubectl
  - Setup Kubernetes using kubeadm

- **EKS (Amazon Elastic Kubernetes Service):**
  - Follow the AWS documentation for setting up EKS

## 2. Setup Environment for Building War File and Docker Image

Ensure your development environment is set up with the necessary tools:

- Install JDK
- Install Maven
- Install Git

Set the PATH environment variable based on your operating system.

## 3. Clone the Repository

```bash
git clone https://github.com/Goutamjena/StudentEnrollment.git

4. Build War File
Navigate to the project folder "StudentEnrollment" and run:

bash
Copy code
mvn package
5. Build Docker Image
bash
Copy code
docker build -t studentapp .
6. Push to Docker Hub
bash
Copy code
docker tag studentapp goutam14339919/student_enrollment:5.0
docker push goutam14339919/student_enrollment:5.0
Note: Update the path based on your Docker repository.

7. Deploy Application to Kubernetes Cluster
bash
Copy code
kubectl apply -f studentapp-deployment.yml
kubectl apply -f studentapp-service.yml
kubectl apply -f mysql-deployment.yml
kubectl apply -f mysql-service.yml
8. Database Setup
Login to the database cluster and create the 'std' table, and insert some dummy data. Refer to the instructions provided in the references.

9. Access the Application (Minikube on Windows)
If using Minikube on Windows, obtain the URL to access the application:

bash
Copy code
minikube service servlet-service --url
For example, the URL is http://127.0.0.1:61192/StudentEnrollment/

Feel free to update and customize this README file based on your specific project details and preferences.











Reference to login to database conatiner for and create the table std for the first time which contains the data

The following command will change in case based upton the OS, for if you have installed minicube on windows use the following command to login to the cluster



"winpty kubectl exec -it mysql-deployment-65f57894b7-mgwx6 -- sh" 
$ kubectl exec -it mysql-deployment-65f57894b7-mgwx6 -- bash
Unable to use a TTY - input is not a terminal or the right kind of file


sss@DESKTOP-3AHQDKE MINGW64 /f/Goutam/myapp/StudentEnrollment (master)
$ winpty kubectl exec -it mysql-deployment-65f57894b7-mgwx6 -- sh
sh-4.4# mysql -uroot -p
Enter password:
ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES)
sh-4.4# mysql -uroot -pPassword@2023
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.2.0 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mydatabase         |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> use mydatabase;
Database changed
mysql> create table std(name varchar(20), rollno int(20), addrs varchar(20));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'std(name varchar(20), rollno int(20),
 addrs varchar(20))' at line 1
mysql> CREATE TABLE `std` (
    ->   `name` VARCHAR(20),
    ->   `rollno` INT(20),
    ->   `addrs` VARCHAR(20)
    -> );
Query OK, 0 rows affected, 1 warning (0.09 sec)

mysql> insert into std values('Goutam', 101 , 'Banglore');
Query OK, 1 row affected (0.02 sec)

mysql> insert into std values('shaswat', 102 , 'Banglore');
Query OK, 1 row affected (0.02 sec)

mysql> select * from std;
+---------+--------+----------+
| name    | rollno | addrs    |
+---------+--------+----------+
| Goutam  |    101 | Banglore |
| shaswat |    102 | Banglore |
+---------+--------+----------+
2 rows in set (0.00 sec)

mysql> exit
