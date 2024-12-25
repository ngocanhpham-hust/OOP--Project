package com.hust.ai.visual_search;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisualSearchClient {

    public List<String> suggestImg(String img) {
        String target = "localhost:50051";

        // Create a communication channel to the server
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext() // IMPORTANT: Disable SSL/TLS for local development
                .build();

        try {
            // Create a stub (client-side proxy)
            VisualSearchGrpc.VisualSearchServiceBlockingStub stub = VisualSearchGrpc.newBlockingStub(channel);

            // Create a request
            VisualSearchOuterClass.VisualSearchRequest request = VisualSearchOuterClass.VisualSearchRequest.newBuilder()
                    .setImageUrl(img)
                    .setText("This is a test query for football.")
                    .build();

            // Call the remote method and get the response
            VisualSearchOuterClass.VisualSearchResponse response = stub.search(request);

            // Print Results
            System.out.println("Similar Images: ");
            List<String> similarImageUrls = response.getSimilarImageUrlsList();
            for (int i = 0; i < similarImageUrls.size(); i++) {
                System.out.println(String.format("%d. %s", i + 1, similarImageUrls.get(i)));
            }
            System.out.println("Similar Text Ids: " + response.getSimilarTextIdsList());
            return similarImageUrls;
        } finally {
            // Shutdown the channel
            channel.shutdownNow();
        }
    }
}