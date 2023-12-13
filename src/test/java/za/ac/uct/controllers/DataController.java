package za.ac.uct.controllers;


import za.ac.uct.controllers.DataObject;
import za.ac.uct.controllers.FirebaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

    @Autowired
    private FirebaseServices firebaseServices; // Service class to interact with Firebase

    @PostMapping("/addData")
    public ResponseEntity<String> addData(@RequestBody DataObject newData) {
        try {
            FirebaseServices.addDataToFirebase(newData); // Call the method in FirebaseService to add data to Firebase
            return ResponseEntity.ok("Data added successfully to Firebase");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding data to Firebase: " + e.getMessage());
        }
    }
}
