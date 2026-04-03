package org.mpp.embedding;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

import java.util.List;

@ApplicationScoped
public class EmbeddingService {

    @Inject
    EmbeddingModel embeddingModel;

    @Produces
    public List<Double> embedData(String data) {
        Response<Embedding> embeddings = embeddingModel.embed(data);


    }
}
