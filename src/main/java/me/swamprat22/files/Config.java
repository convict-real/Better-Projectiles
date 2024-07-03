package me.swamprat22.files;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.swamprat22.Main;
import me.swamprat22.files.commentedfiles.CommentedFileConfiguration;
import me.swamprat22.managers.Initializer;

public class Config implements Initializer {
	private static boolean exists;
	private final Main plugin;
	private CommentedFileConfiguration configuration;

	public Config(final Main plugin) {
		this.plugin = plugin;
	}

	/**
	 * @return the config.yml as a CommentedFileConfiguration
	 */
	public CommentedFileConfiguration getConfig() {
		return configuration;
	}

	@Override
	public void initialize() {
		final File configFile = new File(plugin.getDataFolder(), "config.yml");

		Config.exists = configFile.exists();

		boolean changed = !configFile.exists();

		configuration = CommentedFileConfiguration.loadConfiguration(plugin, configFile);

		for (final Setting setting : Setting.values()) {
			setting.reset();
			changed |= setting.setIfNotExists(configuration);
		}

		if (changed)
			configuration.save();
	}

	@Override
	public void shutdown() {
		for (final Setting setting : Setting.values())
			setting.reset();
	}

	public enum Setting {
		ENDER_PEARL("ender_pearl", null, "Modify ender pearls"), 
		ENDER_PEARL_ENABLED("ender_pearl.enabled", true),
		ENDER_PEARL_SPEED("ender_pearl.speed", 1.25, "The speed of thrown ender pearls"),
		ENDER_PEARL_MOMENTUM_ACCELERATION("ender_pearl.momentum_acceleration", false, "The player's speed increases the speed of thrown pearls"),
		ENDER_PEARL_FALL_DISTANCE("ender_pearl.fall_distance", 0, "How fast a thrown ender pearl will fall"),

		ENDER_SIGNAL("ender_signal", null, "Modify ender signals"), 
		ENDER_SIGNAL_ENABLED("ender_signal.enabled", true),
		ENDER_SIGNAL_SPEED("ender_signal.speed", 1.25, "The speed of thrown ender signals"),
		ENDER_SIGNAL_MOMENTUM_ACCELERATION("ender_signal.momentum_acceleration", false, "The player's speed increases the speed of thrown signals"),
		ENDER_SIGNAL_FALL_DISTANCE("ender_signal.fall_distance", 0, "How fast a thrown ender signal will fall"),

		FISHING_HOOK("fishing_hook", null, "Modify fishing hooks"), 
		FISHING_HOOK_ENABLED("fishing_hook.enabled", true),
		FISHING_HOOK_SPEED("fishing_hook.speed", 1.5, "The speed of casted fishing hooks"),
		FISHING_HOOK_MOMENTUM_ACCELERATION("fishing_hook.momentum_acceleration", false, "The player's speed increases the speed of casted fishing hooks"),
		FISHING_HOOK_FALL_DISTANCE("fishing_hook.fall_distance", 0, "How fast a fishing hook will fall"),

		SNOWBALL("snowball", null, "Modify snowballs"), 
		SNOWBALL_ENABLED("snowball.enabled", true),
		SNOWBALL_SPEED("snowball.speed", 1.25, "The speed of thrown snowballs"),
		SNOWBALL_MOMENTUM_ACCELERATION("snowball.momentum_acceleration", false, "The player's speed increases the speed of thrown snowballs"),
		SNOWBALL_FALL_DISTANCE("snowball.fall_distance", 0, "How fast a thrown snowball will fall"),

		EGG("egg", null, "Modify eggs"), 
		EGG_ENABLED("egg.enabled", true), 
		EGG_SPEED("egg.speed", 1.25, "The speed of thrown eggs"),
		EGG_MOMENTUM_ACCELERATION("egg.momentum_acceleration", false, "The player's speed increases the speed of thrown eggs"),
		EGG_FALL_DISTANCE("egg.fall_distance", 0, "How fast a thrown egg will fall"),

		SPLASH_POTION("splash_potion", null, "Modify splash potions"), 
		SPLASH_POTION_ENABLED("splash_potion.enabled", true),
		SPLASH_POTION_SPEED("splash_potion.speed", 1.25, "The speed of thrown splash potions"),
		SPLASH_POTION_MOMENTUM_ACCELERATION("splash_potion.momentum_acceleration", false, "The player's speed increases the speed of thrown splash potions"),
		SPLASH_POTION_FALL_DISTANCE("splash_potion.fall_distance", 0, "How fast a thrown splash potion will fall"),

		THROWN_EXP_BOTTLE("thrown_exp_bottle", null, "Modify thrown exp bottles"), 
		THROWN_EXP_BOTTLE_ENABLED("thrown_exp_bottle.enabled", true),
		THROWN_EXP_BOTTLE_SPEED("thrown_exp_bottle.speed", 1.25, "The speed of thrown exp bottles"),
		THROWN_EXP_BOTTLE_MOMENTUM_ACCELERATION("thrown_exp_bottle.momentum_acceleration", false, "The player's speed increases the speed of thrown exp bottles"),
		THROWN_EXP_BOTTLE_FALL_DISTANCE("thrown_exp_bottle.fall_distance", 0, "How fast a thrown exp bottle will fall"),

		FIREBALL("fireball", null, "Modify thrown fireballs"), 
		FIREBALL_ENABLED("fireball.enabled", true),
		FIREBALL_SPEED("fireball.speed", 1.25, "The speed of thrown fireballs"),
		FIREBALL_MOMENTUM_ACCELERATION("fireball.momentum_acceleration", false, "The player's speed increases the speed of thrown fireballs"),
		FIREBALL_FALL_DISTANCE("fireball.fall_distance", 0, "How fast a thrown fireball will fall"),

		DRAGON_FIREBALL("dragon_fireball", null, "Modify thrown dragon fireballs"), 
		DRAGON_FIREBALL_ENABLED("dragon_fireball.enabled", true),
		DRAGON_FIREBALL_SPEED("dragon_fireball.speed", 1.25, "The speed of thrown dragon fireballs"),
		DRAGON_FIREBALL_MOMENTUM_ACCELERATION("dragon_fireball.momentum_acceleration", false, "The player's speed increases the speed of thrown dragon fireballs"),
		DRAGON_FIREBALL_FALL_DISTANCE("dragon_fireball.fall_distance", 0, "How fast a thrown dragon fireball will fall"),

		SMALL_FIREBALL("small_fireball", null, "Modify thrown small fireballs"), 
		SMALL_FIREBALL_ENABLED("small_fireball.enabled", true),
		SMALL_FIREBALL_SPEED("small_fireball.speed", 1.25, "The speed of thrown small fireballs"),
		SMALL_FIREBALL_MOMENTUM_ACCELERATION("small_fireball.momentum_acceleration", false, "The player's speed increases the speed of thrown small fireballs"),
		SMALL_FIREBALL_FALL_DISTANCE("small_fireball.fall_distance", 0, "How fast a thrown small fireball will fall"),

		ARROW("arrow", null, "Modify shot arrows"), 
		ARROW_ENABLED("arrow.enabled", true),
		ARROW_SPEED("arrow.speed", 1.25, "The speed of shot arrows"),
		ARROW_MOMENTUM_ACCELERATION("arrow.momentum_acceleration", false, "The player's speed increases the speed of shot arrows"),
		ARROW_FALL_DISTANCE("arrow.fall_distance", 0, "How fast a shot arrow will fall"),

		SPECTRAL_ARROW("spectral_arrow", null, "Modify shot spectral arrows"), 
		SPECTRAL_ARROW_ENABLED("spectral_arrow.enabled", true),
		SPECTRAL_ARROW_SPEED("spectral_arrow.speed", 1.25, "The speed of shot spectral arrows"),
		SPECTRAL_ARROW_MOMENTUM_ACCELERATION("spectral_arrow.momentum_acceleration", false, "The player's speed increases the speed of shot spectral arrows"),
		SPECTRAL_ARROW_FALL_DISTANCE("spectral_arrow.fall_distance", 0, "How fast a shot spectral arrow will fall"),

		TRIDENT("trident", null, "Modify thrown tridents"), 
		TRIDENT_ENABLED("trident.enabled", true),
		TRIDENT_SPEED("trident.speed", 1.25, "The speed of thrown tridents"),
		TRIDENT_MOMENTUM_ACCELERATION("trident.momentum_acceleration", false, "The player's speed increases the speed of thrown tridents"),
		TRIDENT_FALL_DISTANCE("trident.fall_distance", 0, "How fast a thrown trident will fall"),
		
		FIREWORK("firework", null, "Modify shot fireworks"), 
		FIREWORK_ENABLED("firework.enabled", true),
		FIREWORK_SPEED("firework.speed", 1.25, "The speed of shot fireworks"),
		FIREWORK_MOMENTUM_ACCELERATION("firework.momentum_acceleration", false, "The player's speed increases the speed of shot fireworks");

		private final String key;
		private final Object defaultValue;
		private final String[] comments;
		private boolean excluded;
		private Object value = null;

		Setting(final String key, final Object defaultValue, final String... comments) {
			this.key = key;
			this.defaultValue = defaultValue;
			this.comments = comments != null ? comments : new String[0];
		}

		Setting(final String key, final Object defaultValue, final boolean excluded, final String... comments) {
			this.key = key;
			this.defaultValue = defaultValue;
			this.comments = comments != null ? comments : new String[0];
			this.excluded = excluded;
		}

		/**
		 * Gets the setting as a boolean
		 *
		 * @return The setting as a boolean
		 */
		public boolean getBoolean() {
			loadValue();
			return (boolean) value;
		}

		public String getKey() {
			return key;
		}

		/**
		 * @return the setting as an int
		 */
		public int getInt() {
			loadValue();
			return (int) getNumber();
		}

		/**
		 * @return the setting as a long
		 */
		public long getLong() {
			loadValue();
			return (long) getNumber();
		}

		/**
		 * @return the setting as a double
		 */
		public double getDouble() {
			loadValue();
			return getNumber();
		}

		/**
		 * @return the setting as a float
		 */
		public float getFloat() {
			loadValue();
			return (float) getNumber();
		}

		/**
		 * @return the setting as a String
		 */
		public String getString() {
			loadValue();
			return String.valueOf(value);
		}

		private double getNumber() {
			if (value instanceof Integer)
				return (int) value;
			else if (value instanceof Short)
				return (short) value;
			else if (value instanceof Byte)
				return (byte) value;
			else if (value instanceof Float)
				return (float) value;

			return (double) value;
		}

		/**
		 * @return the setting as a string list
		 */
		@SuppressWarnings("unchecked")
		public List<String> getStringList() {
			loadValue();
			return (List<String>) value;
		}

		private boolean setIfNotExists(final CommentedFileConfiguration fileConfiguration) {
			loadValue();

			if (Config.exists && excluded)
				return false;

			if (fileConfiguration.get(key) == null) {
				final List<String> comments = Stream.of(this.comments).collect(Collectors.toList());

				if (defaultValue != null)
					fileConfiguration.set(key, defaultValue, comments.toArray(new String[0]));
				else
					fileConfiguration.addComments(comments.toArray(new String[0]));

				return true;
			}

			return false;
		}

		/**
		 * Resets the cached value
		 */
		public void reset() {
			value = null;
		}

		/**
		 * @return true if this setting is only a section and doesn't contain an actual
		 *         value
		 */
		public boolean isSection() {
			return defaultValue == null;
		}

		/**
		 * Loads the value from the config and caches it if it isn't set yet
		 */
		public void loadValue() {
			if (value != null)
				return;

			value = Main.getInstance().getConfiguration().get(key);
		}
	}
}
