package org.mpp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.mpp.embedding.EmbeddingService;

import java.util.List;

@Path("/api/embedding")
public class EmbeddingController {

    @Inject
    private EmbeddingService embeddingService;

    @POST
    public List<Double> saveEmbeddings(String data) {
        if (data == null || data.isEmpty()) throw new RuntimeException("Data cannot be null!");

        return embeddingService.embedData(data);
    }
}
