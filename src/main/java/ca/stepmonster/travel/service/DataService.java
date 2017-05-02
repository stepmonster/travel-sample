package ca.stepmonster.travel.service;

import ca.stepmonster.travel.model.Trip;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
/**
 * Created by judy on 4/28/17.
 */
public class DataService {

    private static MongoClient mongoClient = new MongoClient();
    private static final String DATABASE_NAME = "TRAVEL";

    public DataService(){
    }

    public List<Trip> queryItinerariesForUser(String username){
        MongoDatabase db = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection collection = db.getCollection("itineraries");

        List<Trip> itineraries = new ArrayList<>();
        Block<Document> translate = new Block<Document>() {
            @Override
            public void apply(Document document) {
                itineraries.add(getItinerary(document));

            }

            private Trip getItinerary(Document document){

                return  new Trip( document.getString("description"),
                        document.getString("name"), new Date(
                        document.getLong("startDate")),
                        new Date(document.getLong("endDate")),
                        document.getString("userName"));


            }
        };

        collection.find( Filters.eq("userName", username)).
                forEach(translate);

        return itineraries;

    }




}
