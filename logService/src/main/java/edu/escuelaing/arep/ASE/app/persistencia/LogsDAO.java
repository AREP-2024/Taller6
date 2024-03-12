package edu.escuelaing.arep.ASE.app.persistencia;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.util.Collection;

public class LogsDAO implements CRUD<String, String>{

    public static LogsDAO getLogsDAO( String dataBaseName, String collectionName){
        MongoDatabase database = MongoUtil.getDB(dataBaseName);
        return new LogsDAO(database,collectionName);
    }

    private MongoCollection<Document> logsCollection;

    public LogsDAO(MongoDatabase database, String collectionNameString){
        this.logsCollection = database.getCollection(collectionNameString);

    }    

    public void guardar(String identificador, String info){
        Document nuevoLog = new Document("_id", identificador)
                                .append("log", info);
        logsCollection.insertOne(nuevoLog);

    }

    public void eliminar(String identificador){
        logsCollection.deleteOne(eq("_id",identificador));

    }

    public String buscar(String identificador){
        return logsCollection.find(eq("_id", identificador)).toString();

    }

    public Collection<String> buscarTodos(){
        return logsCollection.find().map((document)->document.toJson()).into(new java.util.ArrayList<String>());

    }


}
