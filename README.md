1. Setup the Kubernetes cluseter
-Install Docker
-install kubectl
-install Minikube /setup the Kubenet cluster via kubeadm/EKS

2.Setup the Environment for Building the war file and docker image
-install jdk
-install maven
-Install Git

Set the PATH in env variable based upon OS
3.Clone the repository
# git clone https://github.com/Goutamjena/StudentEnrollment.git

4.Build war file
Go top the project folder "StudentEnrollment" and run the following command
# mvn package

5.Build the docker image
# docker build -t studentapp .
6.Push to docke hub
# docker tag  studentapp  goutam14339919/student_enrollment:5.0
# docker push  goutam14339919/student_enrollment:5.0
Note: Bsed upon your docker repo change the path

7.The command to Deploye the application to Kubernetes cluster
# kubectl apply -f studenetapp-deployement.yml
# kubectl apply -f studentapp-service.yml
# kubectl apply -f mysql-deployment.yml
# kubectl apply -f mysql-service.yml

8.Login to the database cluster and create the std table and insert some dummy data
Please refer the instruction given in reference

9.If you have used minikube in Windows deployement get the url to access the application
Run the floowing copmmand to get the url
# minikube service servlet-service --url
For eg- the url is http://127.0.0.1:61192/StudentEnrollment/












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
