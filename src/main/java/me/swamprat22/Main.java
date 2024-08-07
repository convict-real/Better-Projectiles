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

import me.swamprat22.fastmath.FastMath;
import me.swamprat22.files.Config;
import me.swamprat22.files.commentedfiles.CommentedFileConfiguration;

public class Main extends JavaPlugin implements Listener {
	private static Main instance;
	private Config configuration;

	public static double preciseFloatToDouble(final float value) {
		return Double.parseDouble(Float.toString(value));
	}

	public static Main getInstance() {
		return Main.instance;
	}

	@Override
	public void onEnable() {
		Main.instance = this;
		(configuration = new Config(this)).initialize();

		Main.getInstance().getLogger().warning("Please ensure that you do not have some other form of custom projectiles enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onProjectileLaunch(final ProjectileLaunchEvent event) {
		final Projectile projectile = event.getEntity();

		final Entity shooter = (Entity) projectile.getShooter();
		if (shooter == null)
			return;

		if (shooter.getType() == EntityType.PLAYER) {
			final Player player = (Player) projectile.getShooter();

			final double yaw = FastMath.toRadians(Main.preciseFloatToDouble(player.getLocation().getYaw()));
			final double pitch = FastMath.toRadians(Main.preciseFloatToDouble(player.getLocation().getPitch()));

			final Vector direction = new Vector(-FastMath.sin(yaw) * FastMath.cos(pitch), -FastMath.sin(pitch), FastMath.cos(yaw) * FastMath.cos(pitch)).normalize();

			switch (projectile.getType()) {
			case ENDER_PEARL:
				if (!Config.Setting.ENDER_PEARL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.ENDER_PEARL_SPEED.getDouble());

				if (Config.Setting.ENDER_PEARL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.ENDER_PEARL_FALL_DISTANCE.getFloat());
				break;

			case ENDER_SIGNAL:
				if (!Config.Setting.ENDER_SIGNAL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.ENDER_SIGNAL_SPEED.getDouble());

				if (Config.Setting.ENDER_SIGNAL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.ENDER_SIGNAL_FALL_DISTANCE.getFloat());
				break;

			case FISHING_HOOK:
				if (!Config.Setting.FISHING_HOOK_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.FISHING_HOOK_SPEED.getDouble());

				if (Config.Setting.FISHING_HOOK_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.FISHING_HOOK_FALL_DISTANCE.getFloat());
				break;

			case SNOWBALL:
				if (!Config.Setting.SNOWBALL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.SNOWBALL_SPEED.getDouble());

				if (Config.Setting.SNOWBALL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.SNOWBALL_FALL_DISTANCE.getFloat());
				break;

			case EGG:
				if (!Config.Setting.EGG_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.EGG_SPEED.getDouble());

				if (Config.Setting.EGG_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.EGG_FALL_DISTANCE.getFloat());
				break;

			case SPLASH_POTION:
				if (!Config.Setting.SPLASH_POTION_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.SPLASH_POTION_SPEED.getDouble());

				if (Config.Setting.SPLASH_POTION_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.SPLASH_POTION_FALL_DISTANCE.getFloat());
				break;

			case THROWN_EXP_BOTTLE:
				if (!Config.Setting.THROWN_EXP_BOTTLE_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.THROWN_EXP_BOTTLE_SPEED.getDouble());

				if (Config.Setting.THROWN_EXP_BOTTLE_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.THROWN_EXP_BOTTLE_FALL_DISTANCE.getFloat());
				break;

			case FIREBALL:
				if (!Config.Setting.FIREBALL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.FIREBALL_SPEED.getDouble());

				if (Config.Setting.FIREBALL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.FIREBALL_FALL_DISTANCE.getFloat());
				break;

			case DRAGON_FIREBALL:
				if (!Config.Setting.DRAGON_FIREBALL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.DRAGON_FIREBALL_SPEED.getDouble());

				if (Config.Setting.DRAGON_FIREBALL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.DRAGON_FIREBALL_FALL_DISTANCE.getFloat());
				break;

			case SMALL_FIREBALL:
				if (!Config.Setting.SMALL_FIREBALL_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.SMALL_FIREBALL_SPEED.getDouble());

				if (Config.Setting.SMALL_FIREBALL_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.SMALL_FIREBALL_FALL_DISTANCE.getFloat());
				break;

			case ARROW:
				if (!Config.Setting.ARROW_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.ARROW_SPEED.getDouble());

				if (Config.Setting.ARROW_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.ARROW_FALL_DISTANCE.getFloat());
				break;

			case SPECTRAL_ARROW:
				if (!Config.Setting.SPECTRAL_ARROW_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.SPECTRAL_ARROW_SPEED.getDouble());

				if (Config.Setting.SPECTRAL_ARROW_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.SPECTRAL_ARROW_FALL_DISTANCE.getFloat());
				break;

			case TRIDENT:
				if (!Config.Setting.TRIDENT_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.TRIDENT_SPEED.getDouble());

				if (Config.Setting.TRIDENT_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				projectile.setFallDistance(Config.Setting.TRIDENT_FALL_DISTANCE.getFloat());
				break;

			case FIREWORK:
				if (!Config.Setting.FIREWORK_ENABLED.getBoolean())
					return;

				direction.multiply(Config.Setting.FIREWORK_SPEED.getDouble());

				if (Config.Setting.FIREWORK_MOMENTUM_ACCELERATION.getBoolean() && player.getVelocity().length() > 0D)
					direction.multiply(1.25D + player.getVelocity().length() / 10D);

				projectile.setVelocity(direction);
				break;

			default:
				break;
			}
		}
	}

	@EventHandler
	public void onProjectileHit(final ProjectileHitEvent event) {
		final Projectile projectile = event.getEntity();

		if (projectile.getType() == EntityType.ENDER_PEARL) {
			final Entity shooter = (Entity) projectile.getShooter();
			if (shooter == null)
				return;

			if (shooter.getType() == EntityType.PLAYER) {
				final Player player = (Player) shooter;

				player.getLocation().setX(projectile.getLocation().getX());
				player.getLocation().setY(projectile.getLocation().getY());
				player.getLocation().setZ(projectile.getLocation().getZ());
			}
		}
	}

	public CommentedFileConfiguration getConfiguration() {
		return configuration.getConfig();
	}

	@Override
	public void onDisable() {
		configuration.shutdown();
		Main.instance = null;
	}
}
