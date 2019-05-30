package me.bloodmc.playerlogger;

import org.apache.commons.io.FileUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class EventLogManager {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static Path logPath = Paths.get(".", "plugins", "PlayerLogger", "logs");

    public static void logEvent(OfflinePlayer player, Event event, String data) {
        logEvent(player.getUniqueId(), event, data);
    }

    public static void logEvent(UUID uuid, Event event, String data) {
        try {
            final String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
            FileUtils.write(getPlayerLogFile(uuid, event), "Time: [" + timeStamp + "], " + data + "\n", Charset.forName("UTF-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getPlayerLogFile(UUID uuid, Event event) {
        LocalDate localDate = LocalDate.now();
        String date = formatter.format(localDate);
        Path path = logPath.resolve(uuid.toString()).resolve(event.getEventName()).resolve(date + ".log");
        return path.toFile();
    }
}
