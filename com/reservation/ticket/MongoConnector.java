/*This code is used to Conncet MongoDB Atlas & it contains methods for perfoming Insert operation
*/
package com.reservation.ticket;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Arrays;
import org.bson.*;
public class MongoConnector
{
    private String userName="hero";
    private String password="herowso2";
    private String credential=userName+":"+password;
    private String connectionURI="mongodb://"+credential+"@mhk-shard-00-00-vbfoi.mongodb.net:27017,mhk-shard-00-01-vbfoi.mongodb.net:27017,mhk-shard-00-02-vbfoi.mongodb.net:27017/test?ssl=true&replicaSet=mhk-shard-0&authSource=admin";
    private MongoClient mongoClient;
    private MongoDatabase mDatabase;
    private static final String database="hero";
    private String collection="dummy";
    private MongoCollection<Document> mCollection;
    private MongoClientURI mcUri;

   // private MongoCollection<Document> mCollection;

    MongoConnector()
    {
        try 
        {
            mcUri=new MongoClientURI(connectionURI);
            mongoClient=new MongoClient(mcUri);
        }
        catch (MongoClientException e)
        {
            e.printStackTrace();            
        }
        mDatabase=mongoClient.getDatabase(database);
        mCollection=mDatabase.getCollection(collection);
    }
    public void Insert(String data)
    {
        Document doc=Document.parse(data);
        mCollection.insertOne(doc);
        
     
    }
    public void closeConnection()
    {
        mongoClient.close();
    }

}