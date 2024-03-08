package edu.escuelaing.arep.ASE.app.persistencia;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class LogsDAO implements CRUD<String, String>{

    public static LogsDAO getLogsDAO( String dataBaseName, String collectionName){
        MongoDatabase database = MongoUtil.getDB(dataBaseName);
        return new LogsDAO(database,collectionName);
    }

    private MongoCollection<Document> logsCollection;

    public LogsDAO(MongoDatabase database, String collectionNameString){
        this.logsCollection = database.getCollection(collectionNameString);

    }    

    public void guardar(String identificador, String tipoDato){
        Document nuevoLog = new Document("id", identificador)
                                .append("log", tipoDato);
        logsCollection.insertOne(nuevoLog);

    }

    public void eliminar(String identificador){
        logsCollection.deleteOne(eq("id",identificador));

    }

    public String buscar(String identificador){
        return logsCollection.find(eq("id", identificador)).toString();

    }

    public Collection<String> buscarTodos(){
        return logsCollection.find().toString();

    }


}
