# Mongo DB Change Stream

Change stream application uses new mongo 3.6 feature "change stream" which can watch any changes happening on db collection, database etc.

To achieve this feature mongo DB has to configure on replica model 

Download mongoDB version above 3.6
create folder where data replica can be stored (eg: c:\replica\rs0-0)
execute below command


mongod --port 27017 --dbpath c:\replica\rs0-0 --replSet rs0 --smallfiles --oplogSize 128

mongod --port 27018 --dbpath c:\replica\rs0-1 --replSet rs0 --smallfiles --oplogSize 128

Once both instance are running, use below command to add/set replica

Connect to mongo shell 

mongo --host localhost --port 27017

rs.add("localhost:27018")

Create a data base "test"
Create collection "documents"

For testing
add new document, modify documents
