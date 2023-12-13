import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitializer {
    private DatabaseReference database;

    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://uct-assessment-default-rtdb.firebaseio.com/") 
                .build();

        FirebaseApp.initializeApp(options);
        this.database = FirebaseDatabase.getInstance().getReference();
    }


    public static void checkFirebaseConnection() {
        if (FirebaseApp.getApps().isEmpty()) {
            System.out.println("Firebase is not initialized.");
        } else {
            System.out.println("Firebase is initialized.");


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("test");
            ref.setValue("Firebase connection test!", (error, ref1) -> {
                if (error != null){
                    System.err.println("Data could not be saved: " + error.getMessage());
                } else  {
                    System.out.println("Data written to firebase.");
                }
            });

            // Listening for changes in the Realtime Database
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Object value = dataSnapshot.getValue();
                    System.out.println("Value in 'test' reference changed: " + value);
                    // React to changes here
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    System.err.println("Listener was cancelled: " + error.getMessage());
                }
            });

        }
    }

    public void readData(String path) {
        database.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Object data = dataSnapshot.getValue();
                    // Process the retrieved data
                } else {
                    // Data doesn't exist at this path
                    System.err.println("Data does not exist ");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle errors
            }
        });
    }


    public void writeData(String path, Map<String, Object> data) {
        database.child(path).updateChildren(data, (databaseError, databaseReference) -> {
            if (databaseError == null) {
                // Data successfully written
                System.out.println("Data at " + path + " successfully inserted");
            } else {
                // Handle failure to write data
                System.err.println("Failed to insert data at " + path + ": " + databaseError.getMessage());
            }
        });
    }



    public void updateData(String path, Map<String, Object> updates) {
        database.updateChildren(updates, (databaseError, databaseReference) -> {
            if (databaseError == null) {
                // Data successfully updated
                System.out.println("Data at " + path + " successfully updated");
            } else {
                // Handle failure to update data
                System.err.println("Failed to update data at " + path + ": " + databaseError.getMessage());
            }
        });
    }



    public void deleteData(String path) {
        database.child(path).removeValue((databaseError, databaseReference) -> {
            if (databaseError == null) {
                // Data successfully deleted
                System.out.println("Data at " + path + " successfully deleted");
            } else {
                // Handle failure to delete data
                System.err.println("Failed to delete data at " + path + ": " + databaseError.getMessage());
            }
        });
    }

    public void main(String[] args) {
        try {
            initialize();
            checkFirebaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
