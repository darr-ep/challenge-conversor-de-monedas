import java.util.Map;

public record MonedaExchange(String base_code, Map<String, Double> conversion_rates) {
}
