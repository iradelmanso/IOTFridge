package com.iotfridgeapi.IOTFridgeAPI.services;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudVision implements ImageAnalizerInterface {

    public String AnalizeImage(byte[] image) {
        // Instantiates a client
        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

            // Reads the image file into memory
            //Path path = Paths.get(fileName);
            byte[] data = image;// Files.readAllBytes(path);
            ByteString imgBytes = ByteString.copyFrom(data);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Feature.Type.WEB_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feat)
                    .setImage(img)
                    .build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            //List<AnnotateImageResponse> responses = response.getResponsesList();

            AnnotateImageResponse annotateImageResponse = response.getResponses(0);
            return annotateImageResponse.getWebDetection().getWebEntities(0).getDescription();

           // List<AnnotateImageResponse> responses = response.getResponsesList();

//            for (AnnotateImageResponse res : responses) {
//                if (res.hasError()) {
//                    System.out.printf("Error: %s\n", res.getError().getMessage());
//                    return;
//                }
//
//                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
//                    annotation.getAllFields().forEach((k, v) ->
//                            System.out.printf("%s : %s\n", k, v.toString()));
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
