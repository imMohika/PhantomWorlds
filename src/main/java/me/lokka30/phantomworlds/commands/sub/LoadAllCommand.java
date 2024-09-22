package me.lokka30.phantomworlds.commands.sub;

import me.lokka30.microlib.messaging.MultiMessage;
import me.lokka30.phantomworlds.PhantomWorlds;
import me.lokka30.phantomworlds.commands.utils.WorldFolder;
import me.lokka30.phantomworlds.misc.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LoadAllCommand {

    public static void onCommand(final CommandSender sender) {
        HashSet<String> loadedWorlds = Utils.getLoadedWorldsNameList();
        List<WorldFolder> worldFolders = worldFolderList().stream().filter(worldFolder -> !loadedWorlds.contains(worldFolder.getFolder())
        ).toList();

        for (WorldFolder worldFolder : worldFolders) {
            Utils.loadWorld(sender, worldFolder);
        }

        (new MultiMessage(
                PhantomWorlds.instance().messages.getConfig().getStringList(
                        "command.phantomworlds.subcommands.loadall.finished"),
                Arrays.asList(
                        new MultiMessage.Placeholder("prefix", PhantomWorlds.instance().messages.getConfig()
                                .getString("common.prefix", "&b&lPhantomWorlds: &7"), true),
                        new MultiMessage.Placeholder("size", String.valueOf(worldFolders.size()), false)
                ))).send(sender);
    }


    private static List<WorldFolder> worldFolderList() {
        final File directory = Bukkit.getWorldContainer();
        if (!directory.exists()) {
            return List.of();
        }

        String[] subDirs = directory.list((current, name) -> {
            File file = new File(current, name);
            if (!file.isDirectory()) return false;

            File levelDat = new File(file, "level.dat");
            return levelDat.exists();
        });

        if (subDirs == null) {
            return List.of();
        }

        return Arrays.stream(subDirs).map(WorldFolder::new).toList();
    }
}
