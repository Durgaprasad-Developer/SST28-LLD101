import java.nio.charset.StandardCharsets;

public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public abstract ExportResult export(ExportRequest req);
}
