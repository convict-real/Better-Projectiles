package me.swamprat22;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {
   public static double preciseFloatToDouble(float value) {
      return Double.parseDouble(Float.valueOf(value).toString());
   }

   public void onEnable() {
      this.getServer().getPluginManager().registerEvents(this, this);
   }

   @EventHandler
   public void onProjectileLaunch(ProjectileLaunchEvent event) {
      Projectile projectile = event.getEntity();

      Entity shooter = (Entity) projectile.getShooter();
      if (shooter == null)
         return;

      if (shooter.getType() == EntityType.PLAYER) {
         Player player = (Player) projectile.getShooter();

         double yaw = Math.toRadians(preciseFloatToDouble(player.getEyeLocation().getYaw()));
         double pitch = Math.toRadians(preciseFloatToDouble(player.getEyeLocation().getPitch()));

         Vector direction = new Vector(-Math.sin(yaw) * Math.cos(pitch), -Math.sin(pitch), Math.cos(yaw) * Math.cos(pitch)).normalize();

         switch (projectile.getType()) {
            case ENDER_PEARL:
               direction.multiply(1.25D);
   
               if (player.getVelocity().length() > 0D)
                  direction.multiply(1.25D + (player.getVelocity().length() / 10D));
   
               projectile.setVelocity(direction);
               projectile.setFallDistance(0F);
               break;

            case FISHING_HOOK:
               direction.multiply(1.5D);

               projectile.setVelocity(direction);
               projectile.setFallDistance(0F);
         }
      }
   }

   @EventHandler
   public void onProjectileHit(ProjectileHitEvent event) {
      Projectile projectile = event.getEntity();

      if (projectile.getType() == EntityType.ENDER_PEARL) {
         Entity shooter = (Entity) projectile.getShooter();
         if (shooter == null)
            return;

         if (shooter.getType() == EntityType.PLAYER) {
            Player player = (Player) shooter;

            player.getLocation().setX(projectile.getLocation().getX());
            player.getLocation().setY(projectile.getLocation().getY());
            player.getLocation().setZ(projectile.getLocation().getZ());
         }
      }
   }

   public void onDisable() {}
}
