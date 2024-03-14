package fr.elite.infinitedungeon;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IDJCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent exécuter cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("idj")) {
            if (args.length < 1) {
                player.sendMessage("/idj <start|leave|reward>");
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "start":
                    // Start
                    initDungeon(player);
                    break;
                case "leave":
                    // Leave
                    leaveDungeon(player);
                    break;
                case "reward":
                    // Reward
                    giveReward(player);
                    break;
                default:
                    player.sendMessage("Commande inconnue. Utilisez /idj <start|leave|reward>");
            }
            return true;
        }

        return false;
    }

    private void initDungeon(Player player) {
        player.sendMessage("");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("infinite-dungeon-extension"), new Runnable() {
            @Override
            public void run() {
                startDungeon(player);
            }
        }, 400L);
    }

    private void startDungeon(Player player) {
        player.sendMessage("");
        // Save the player inventory
        player.getInventory().clear();
        Location location = new Location(player.getWorld(),1, 2, 3); // Get location from Dungeon plugin
        player.teleport(location);
        player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
    }

    private void leaveDungeon(Player player) {
    }

    private void giveReward(Player player) {
    }
}