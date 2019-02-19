package com.poc.mongo.changeStream.repo;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;

@Component
public class ChangeListner {

	@PostConstruct
	public void testChangeListner()
	{
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> coll = database.getCollection("documents");		
		MongoCursor<ChangeStreamDocument<Document>> cursor = coll.watch().iterator();		
		while(cursor.hasNext())
		{
			ChangeStreamDocument<Document> next = cursor.next();
			
			System.out.println(next.getFullDocument());
		}
	}
}
