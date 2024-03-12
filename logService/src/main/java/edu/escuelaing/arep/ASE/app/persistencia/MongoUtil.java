package edu.escuelaing.arep.ASE.app.persistencia;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

    private static final String CONNECTION_STRING = "mongodb://LuisaGiron:LuisaGiron123@mongodb:27017/";

    public static MongoDatabase getDB(String dataBaseName) {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        return client.getDatabase(dataBaseName);
    }
    
}
