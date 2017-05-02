package ca.stepmonster.travel.service;

import ca.stepmonster.travel.model.Trip;
import com.google.gwt.junit.client.GWTTestCase;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by judy on 5/1/17.
 */
class DataServiceTest{



    private static MongoClient mongoClient = new MongoClient();
    private static final String DATABASE_NAME = "TRAVEL";

    private DataService dataService;
    private MongoCollection collection;

    @BeforeEach
    void setUp() {
        MongoDatabase db = mongoClient.getDatabase(DATABASE_NAME);
        collection =  db.getCollection("itineraries");
        dataService = new DataService();

    }


    @Test
    void queryItinerariesForUser() {

        final int[] count = {0};

        Block<Document> countUs = new Block<Document>() {
            @Override
            public void apply(Document document) {
                count[0]++;

            }


        };

        collection.find( Filters.eq("userName", "Judy")).forEach(countUs);

        assertEquals(count[0], dataService.queryItinerariesForUser("Judy").size());

    }


}