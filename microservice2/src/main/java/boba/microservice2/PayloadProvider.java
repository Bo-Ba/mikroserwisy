package boba.microservice2;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
@Service
public class PayloadProvider {
    private final Map<Integer, Map<Integer, String>> payloadMaps = new HashMap<>();
    private final ResourceLoader resourceLoader;

    public PayloadProvider(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        loadPayloads();
    }

    @PostConstruct
    private void loadPayloads() {
        int[] sizes = {1, 5, 10, 100};
        for (int size : sizes) {
            Map<Integer, String> sizeMap = new HashMap<>();
            payloadMaps.put(size, sizeMap);
            for (int i = 1; i <= 5; i++) {
                String path = "classpath:payloads/" + size + "KB/" + size + "KB" + i + ".txt";
                Resource resource = resourceLoader.getResource(path);
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    sizeMap.put(i, content.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getRandomPayload(int size) {
        Map<Integer, String> sizeMap = payloadMaps.get(size);
        if (sizeMap == null || sizeMap.isEmpty()) {
            throw new IllegalArgumentException("No payloads available for size: " + size);
        }
        int randomIndex = new Random().nextInt(sizeMap.size()) + 1;
        return sizeMap.get(randomIndex);
    }
}
