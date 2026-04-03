package org.mpp.embedding;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class EmbeddingConfiguration {

    @ConfigProperty(name = "gemini.key", defaultValue = "")
    String geminiApiKey;

    @Produces
    public EmbeddingModel embeddingModel() {
        return GoogleAiEmbeddingModel.builder()
                .apiKey(geminiApiKey)
                .modelName("gemini-embedding-2-preview")
                .build();
    }
}
