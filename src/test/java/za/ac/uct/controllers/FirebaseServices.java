// package za.ac.uct.controllers;

// import com.google.firebase.database.DatabaseReference;
// import com.google.firebase.database.FirebaseDatabase;
// import org.springframework.stereotype.Service;

// @Service
// public class FirebaseServices {

//     // Initialize Firebase Database reference
//     private final static DatabaseReference databaseReference;

//     public FirebaseServices() {
//         // Initialize Firebase Database instance and reference to your database
//         FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//         this.databaseReference = firebaseDatabase.getReference("yourFirebaseDatabasePath");
//     }

//     // Method to add data to Firebase Realtime Database
//     public static void addDataToFirebase(DataObject newData) {
//         String key = databaseReference.push().getKey(); // Generate a unique key for the new data
//         databaseReference.child(key).setValue(newData); // Set the value of data at the generated key
//     }
// }
package za.ac.uct.controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseServices {


    // Initialize Firebase Database reference
    private static DatabaseReference databaseReference;

    static {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase.json"); // JSON file path
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://uct-assessment-default-rtdb.firebaseio.com/") // Firebase Realtime Database URL
                    .build();
            FirebaseApp.initializeApp(options);
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("yourFirebaseDatabasePath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add data to Firebase Realtime Database
    public static void addDataToFirebase(DataObject newData) {
        String key = databaseReference.push().getKey(); // Generate a unique key for the new data
        databaseReference.child(key).setValueAsync(newData); // Set the value of data at the generated key
    }
}

