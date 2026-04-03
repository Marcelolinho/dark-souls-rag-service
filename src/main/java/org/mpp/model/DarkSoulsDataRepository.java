package org.mpp.model;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DarkSoulsDataRepository implements PanacheRepository<DarkSoulsDataModel> {

    private Pool pool;

    public Uni<List<DarkSoulsDataModel>> findSimilar(String queryVector, int topK) {
        // O operador <=> calcula a distância
        // TODO: Mudar o algoritmo de busca. Atualmente utilizando o KNN, mudar para outro (pesquisar qual o melhor para o cenário)
        String sql = """
            SELECT id, category, name, description,
                   1 - (embedding <=> CAST($1 AS vector)) AS similarity
            FROM artworks
            ORDER BY embedding <=> CAST($1 AS vector)
            LIMIT $2
            """;

        return pool.preparedQuery(sql)
                .execute(Tuple.of(queryVector, topK))
                .map(rows -> {
                    List<DarkSoulsDataModel> result = new ArrayList<>();
                    for (Row row : rows) {
                        result.add(new DarkSoulsDataModel(
                                row.getLong("id"),
                                row.getString("name"),
                                DarkSoulsCategoryEnum.valueOf(row.getString("category")),
                                row.getString("description"),
                                List.of(row.getDouble("similarity"))
                        ));
                    }
                    return result;
                });
    }
}
